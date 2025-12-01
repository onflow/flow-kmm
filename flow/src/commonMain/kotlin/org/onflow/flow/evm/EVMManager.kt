package org.onflow.flow.evm

import com.ionspin.kotlin.bignum.integer.toBigInteger
import org.onflow.flow.ChainId
import org.onflow.flow.apis.AccountsApi
import org.onflow.flow.apis.BlocksApi
import org.onflow.flow.apis.TransactionsApi
import org.onflow.flow.apis.ScriptsApi
import org.onflow.flow.FlowApi
import org.onflow.flow.sendTransaction
import org.onflow.flow.cadence.ChildAccountMetadata
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.Signer
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.scripts.CadenceScriptLoader

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
     * Execute an EVM transaction via Cadence `evm_run`
     */
    suspend fun runEVMTransaction(
        proposer: FlowAddress,
        payer: FlowAddress,
        rlpEncodedTransaction: ByteArray,
        coinbaseAddress: String,
        signers: List<Signer>
    ): String = impl.runEVMTransaction(proposer, payer, rlpEncodedTransaction, coinbaseAddress, signers)

    /**
     * Call an EVM contract from a COA via `call_contract`
     */
    suspend fun callEVMContract(
        proposer: FlowAddress,
        payer: FlowAddress,
        toEVMAddressHex: String,
        amount: Double,
        data: ByteArray,
        gasLimit: ULong,
        signers: List<Signer>
    ): String = impl.callEVMContract(proposer, payer, toEVMAddressHex, amount, data, gasLimit, signers)

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

    private class EVMManagerImpl(
        private val accountsApi: AccountsApi,
        private val blocksApi: BlocksApi,
        private val transactionsApi: TransactionsApi,
        private val scriptsApi: ScriptsApi,
        private val chainId: ChainId
    ) {

        private val scriptLoader = CadenceScriptLoader(chainId)
        private val flowApi = FlowApi(chainId)

        private fun ByteArray.toCadenceUInt8Array(): Cadence.Value =
            Cadence.array(this.map { Cadence.uint8(it.toUByte()) })

        suspend fun createCOAAccount(
            proposer: FlowAddress,
            payer: FlowAddress,
            amount: Double,
            signers: List<Signer>
        ): String {
            val script = scriptLoader.load("create_coa", "common/evm")
            val resultTx = flowApi.sendTransaction(
                signers = signers,
                chainId = chainId
            ) {
                cadence { script }
                arguments { listOf(Cadence.ufix64(amount)) }
                proposer(proposer.base16Value)
                payer(payer.base16Value)
                authorizers(proposer.base16Value)
            }

            return resultTx.id ?: throw IllegalStateException("Transaction did not return an ID")
        }

        suspend fun runEVMTransaction(
            proposer: FlowAddress,
            payer: FlowAddress,
            rlpEncodedTransaction: ByteArray,
            coinbaseAddress: String,
            signers: List<Signer>
        ): String {
            val script = scriptLoader.load("evm_run", "common/evm")
            val txArgs = listOf(
                rlpEncodedTransaction.toCadenceUInt8Array(),
                Cadence.string(coinbaseAddress)
            )

            val resultTx = flowApi.sendTransaction(
                signers = signers,
                chainId = chainId
            ) {
                cadence { script }
                arguments { txArgs }
                proposer(proposer.base16Value)
                payer(payer.base16Value)
                authorizers(proposer.base16Value)
            }

            return resultTx.id ?: throw IllegalStateException("Transaction did not return an ID")
        }

        suspend fun callEVMContract(
            proposer: FlowAddress,
            payer: FlowAddress,
            toEVMAddressHex: String,
            amount: Double,
            data: ByteArray,
            gasLimit: ULong,
            signers: List<Signer>
        ): String {
            val script = scriptLoader.load("call_contract", "common/evm")
            val txArgs = listOf(
                Cadence.string(toEVMAddressHex),
                Cadence.ufix64(amount),
                data.toCadenceUInt8Array(),
                Cadence.uint64(gasLimit)
            )

            val resultTx = flowApi.sendTransaction(
                signers = signers,
                chainId = chainId
            ) {
                cadence { script }
                arguments { txArgs }
                proposer(proposer.base16Value)
                payer(payer.base16Value)
                authorizers(proposer.base16Value)
                gasLimit(gasLimit.toLong().toBigInteger())
            }

            return resultTx.id ?: throw IllegalStateException("Transaction did not return an ID")
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
            val script = scriptLoader.load("get_child_account_meta", "common/child")
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
