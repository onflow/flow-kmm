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
        scriptsApi = ScriptsApi(baseUrl)
    )

    suspend fun createCOAAccount(
        proposer: FlowAddress,
        payer: FlowAddress,
        amount: Double = 0.0,
        signers: List<Signer>
    ): String = impl.createCOAAccount(proposer, payer, amount, signers)

    suspend fun getEVMAddress(flowAddress: FlowAddress): String = impl.getEVMAddress(flowAddress)

    suspend fun getChildAccountMetadata(flowAddress: FlowAddress): Map<String, ChildAccountMetadata> =
        impl.getChildAccountMetadata(flowAddress)

    @Serializable
    data class ChildAccountMetadata(
        val name: String? = null,
        val description: String? = null,
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
        private val scriptsApi: ScriptsApi
    ) {
        suspend fun createCOAAccount(
            proposer: FlowAddress,
            payer: FlowAddress,
            amount: Double,
            signers: List<Signer>
        ): String {
            val script = CadenceScriptLoader.load("create_coa", "common/evm")
            val latestBlock = blocksApi.getBlock()
            val proposerAccount = accountsApi.getAccount(proposer.base16Value)
            val proposerKey = proposerAccount.keys?.firstOrNull()
                ?: throw IllegalArgumentException("Proposer has no keys")

            // Fill in keyIndex dynamically if not set
            signers.forEach { signer ->
                if (signer.keyIndex == -1) {
                    val account = accountsApi.getAccount(signer.address)
                    signer.keyIndex = account.keys?.firstOrNull()?.index?.toInt()
                        ?: throw IllegalStateException("No key found for ${signer.address}")
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
            val script = CadenceScriptLoader.load("get_addr", "common/evm")
            val result = scriptsApi.executeScript(
                script = script,
                arguments = listOf(Cadence.address(flowAddress.base16Value))
            )
            return result.decode<String>()
        }

        suspend fun getChildAccountMetadata(flowAddress: FlowAddress): Map<String, ChildAccountMetadata> {
            val script = CadenceScriptLoader.load("get_child_account_meta", "common/evm")
            val result = scriptsApi.executeScript(
                script = script,
                arguments = listOf(Cadence.address(flowAddress.base16Value))
            )
            return result.decode<Map<String, ChildAccountMetadata>>()
        }
    }
}