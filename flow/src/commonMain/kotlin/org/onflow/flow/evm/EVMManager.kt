package org.onflow.flow.evm

import com.ionspin.kotlin.bignum.integer.toBigInteger
import org.onflow.flow.ChainId
import org.onflow.flow.apis.AccountsApi
import org.onflow.flow.apis.BlocksApi
import org.onflow.flow.apis.TransactionsApi
import org.onflow.flow.apis.ScriptsApi
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.Signer
import kotlinx.serialization.Serializable
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.scripts.CadenceScriptLoader
import org.onflow.flow.models.TransactionBuilder

class EVMManager(chainId: ChainId) {
    private val baseUrl = chainId.baseUrl
    private val impl = EVMManagerImpl(
        accountsApi = AccountsApi(baseUrl),
        blocksApi = BlocksApi(baseUrl),
        transactionsApi = TransactionsApi(baseUrl),
        scriptsApi = ScriptsApi(baseUrl),
        chainId = chainId
    )

    /**
     * Creates a Cadence Owned Account (COA) on the Flow blockchain
     * @param proposer The Flow address that will propose the transaction
     * @param payer The Flow address that will pay for the transaction
     * @param amount The amount of FLOW tokens to deposit into the COA
     * @param signers List of signers required for the transaction
     * @return The transaction ID of the created COA
     */
    suspend fun createCOAAccount(
        proposer: FlowAddress,
        payer: FlowAddress,
        amount: Double = 0.0,
        signers: List<Signer>
    ): String = impl.createCOAAccount(proposer, payer, amount, signers)

    /**
     * Gets the EVM address associated with a Flow address
     * @param flowAddress The Flow address to look up
     * @return The EVM address as a hex string
     */
    suspend fun getEVMAddress(flowAddress: FlowAddress): String = impl.getEVMAddress(flowAddress)

    /**
     * Gets metadata for child accounts associated with a Flow address
     * @param flowAddress The Flow address to look up
     * @return Map of child account addresses to their metadata
     */
    suspend fun getChildAccountMetadata(flowAddress: FlowAddress): Map<String, ChildAccountMetadata> = impl.getChildAccountMetadata(flowAddress)

    @Serializable
    data class ChildAccountMetadata(
        val name: String? = null,
        val description: String? = null,
        val address: String? = null,
        val thumbnail: Thumbnail? = null
    )

    @Serializable
    data class Thumbnail(
        val url: String? = null
    )

    private class EVMManagerImpl(
        private val accountsApi: AccountsApi,
        private val blocksApi: BlocksApi,
        private val transactionsApi: TransactionsApi,
        private val scriptsApi: ScriptsApi,
        private val chainId: ChainId
    ) {

        private val scriptLoader = CadenceScriptLoader(chainId)

        suspend fun createCOAAccount(
            proposer: FlowAddress,
            payer: FlowAddress,
            amount: Double,
            signers: List<Signer>
        ): String {
            val script = scriptLoader.load("create_coa", "common/evm")
            val latestBlock = blocksApi.getBlock()
            val proposerAccount = accountsApi.getAccount(proposer.base16Value)
            
            // Find the first non-revoked key instead of just the first key
            val proposerKey = proposerAccount.keys?.firstOrNull { !it.revoked }
                ?: throw IllegalArgumentException("Proposer has no non-revoked keys")

            // Fill in keyIndex dynamically if not set
            signers.forEach { signer ->
                if (signer.keyIndex == -1) {
                    val account = accountsApi.getAccount(signer.address)
                    // Find the first non-revoked key instead of just the first key
                    val validKey = account.keys?.firstOrNull { !it.revoked }
                        ?: throw IllegalStateException("No non-revoked key found for ${signer.address}")
                    signer.keyIndex = validKey.index.toInt()
                }
            }

            // Create and sign transaction in one step
            val signedTransaction = TransactionBuilder(script, listOf(Cadence.ufix64(amount)))
                .withReferenceBlockId(latestBlock.header.id)
                .withPayer(payer.base16Value)
                .withProposalKey(
                    address = proposer.base16Value,
                    keyIndex = proposerKey.index.toInt(),
                    sequenceNumber = proposerKey.sequenceNumber.toBigInteger()
                )
                .withAuthorizers(listOf(proposer.base16Value))
                .withSigners(signers)
                .buildAndSign()

            val result = transactionsApi.sendTransaction(signedTransaction)
            return result.id ?: throw IllegalStateException("Transaction did not return an ID")
        }

        suspend fun getEVMAddress(flowAddress: FlowAddress): String {
            val script = scriptLoader.load("get_addr", "common/evm")
            val result = scriptsApi.executeScript(
                script = script,
                arguments = listOf(Cadence.address(flowAddress.base16Value))
            )
            return result.decode<String>()
        }

        suspend fun getChildAccountMetadata(flowAddress: FlowAddress): Map<String, ChildAccountMetadata> {
            val script = scriptLoader.load("get_child_account_meta", "common/evm")
            val result = scriptsApi.executeScript(
                script = script,
                arguments = listOf(Cadence.address(flowAddress.base16Value))
            )
            // Decode into a map that might contain null values for ChildAccountMetadata
            val decodedMapWithNulls = result.decode<Map<String, ChildAccountMetadata?>>()
            // Filter out entries where the value is null
            // and then populate the address field from the map key
            return decodedMapWithNulls
                .filterValues { it != null }
                .map { (key, value) -> // value is ChildAccountMetadata? here, but non-null due to filterValues
                    // Create a new ChildAccountMetadata with the address field populated from the map key
                    key to value!!.copy(address = key)
                }
                .toMap() // Convert the List<Pair<String, ChildAccountMetadata>> back to a Map
        }
    }
}
