package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import org.onflow.flow.apis.AccountsApi
import org.onflow.flow.apis.BlocksApi
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.removeHexPrefix
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.Signer
import org.onflow.flow.models.Transaction

/**
 * DSL entry point for building Flow transactions, mirroring the flow-swift builder style.
 * Handles address resolution, optional reference block lookup, and proposer key hydration.
 */
class TransactionDSLBuilder internal constructor(
    private val chainId: ChainIdProvider,
    private val addressRegistry: AddressRegistry
) {
    internal var script: String? = null
    internal val argumentsList: MutableList<Cadence.Value> = mutableListOf()
    internal var referenceBlockId: String? = null
    internal var gasLimit: BigInteger = 9999.toBigInteger()
    internal var payer: String? = null
    internal var proposalKey: ProposalKey? = null
    internal val authorizers: MutableList<String> = mutableListOf()

    init {
        if (chainId is ChainId) {
            addressRegistry.defaultChainId = chainId
        }
    }

    fun cadence(code: () -> String) {
        script = code()
    }

    fun cadence(code: String) = cadence { code }

    fun script(code: String) = cadence { code }

    fun arguments(arguments: () -> List<Cadence.Value>) {
        argumentsList.clear()
        argumentsList.addAll(arguments())
    }

    fun argument(argument: Cadence.Value) {
        argumentsList.add(argument)
    }

    fun args(vararg arguments: Cadence.Value) {
        this.argumentsList.addAll(arguments)
    }

    fun gasLimit(limit: Int) {
        gasLimit = limit.toBigInteger()
    }

    fun gasLimit(limit: BigInteger) {
        gasLimit = limit
    }

    fun refBlock(id: String?) {
        referenceBlockId = id
    }

    fun payer(address: String) {
        payer = address.removeHexPrefix()
    }

    fun payer(address: FlowAddress) {
        payer = address.base16Value
    }

    fun proposer(address: String, keyIndex: Int = 0, sequenceNumber: BigInteger = (-1).toBigInteger()) {
        proposalKey = ProposalKey(address.removeHexPrefix(), keyIndex, sequenceNumber)
    }

    fun proposer(address: String) = proposer(address, keyIndex = -1, sequenceNumber = (-1).toBigInteger())

    fun proposer(address: FlowAddress, keyIndex: Int = 0, sequenceNumber: BigInteger = (-1).toBigInteger()) =
        proposer(address.base16Value, keyIndex, sequenceNumber)

    fun authorizers(vararg addresses: String) {
        this.authorizers.addAll(addresses.map { it.removeHexPrefix() })
    }

    fun authorizers(addresses: () -> List<String>) {
        this.authorizers.addAll(addresses().map { it.removeHexPrefix() })
    }

    fun authorizers(addresses: List<FlowAddress>) {
        this.authorizers.addAll(addresses.map { it.base16Value })
    }
}

suspend fun FlowApi.buildTransaction(
    chainId: ChainIdProvider = this.chainId,
    addressRegistry: AddressRegistry = AddressRegistry(),
    builder: TransactionDSLBuilder.() -> Unit
): Transaction {
    val blocksApi = BlocksApi(chainId.baseUrl)
    val accountsApi = AccountsApi(chainId.baseUrl)
    val dsl = TransactionDSLBuilder(chainId, addressRegistry).apply(builder)

    val rawScript = dsl.script ?: throw IllegalStateException("Cadence script must be provided")
    val processedScript = addressRegistry.processScript(rawScript, chainId)

    val resolvedProposalKey = dsl.proposalKey?.let { proposalKey ->
        val account = accountsApi.getAccount(proposalKey.address.removeHexPrefix())
        val accountKey = if (proposalKey.keyIndex >= 0) {
            account.keys?.firstOrNull { it.index.toInt() == proposalKey.keyIndex }
        } else {
            account.keys?.firstOrNull()
        } ?: throw IllegalArgumentException("No key found for ${proposalKey.address} at index ${proposalKey.keyIndex}")

        val sequence = if (proposalKey.sequenceNumber < 0.toBigInteger()) {
            accountKey.sequenceNumber.toBigInteger()
        } else {
            proposalKey.sequenceNumber
        }

        proposalKey.copy(
            keyIndex = accountKey.index.toInt(),
            sequenceNumber = sequence
        )
    } ?: throw IllegalStateException("Proposal key must be provided")

    val resolvedRefBlockId = dsl.referenceBlockId ?: blocksApi.getBlock().header.id
    val payerAddress = dsl.payer ?: resolvedProposalKey.address
    val authorizerList = if (dsl.authorizers.isNotEmpty()) {
        dsl.authorizers.toList()
    } else {
        listOf(resolvedProposalKey.address)
    }

    return Transaction(
        script = processedScript,
        arguments = dsl.argumentsList.toList(),
        referenceBlockId = resolvedRefBlockId,
        gasLimit = dsl.gasLimit,
        payer = payerAddress,
        proposalKey = resolvedProposalKey,
        authorizers = authorizerList
    )
}

suspend fun FlowApi.signTransaction(unsignedTransaction: Transaction, signers: List<Signer>): Transaction =
    unsignedTransaction.sign(signers)

suspend fun FlowApi.sendTransaction(
    signers: List<Signer>,
    chainId: ChainIdProvider = this.chainId,
    addressRegistry: AddressRegistry = AddressRegistry(),
    builder: TransactionDSLBuilder.() -> Unit
): Transaction {
    val unsignedTransaction = buildTransaction(chainId, addressRegistry, builder)
    val signedTransaction = signTransaction(unsignedTransaction, signers)
    return sendTransaction(signedTransaction)
}
