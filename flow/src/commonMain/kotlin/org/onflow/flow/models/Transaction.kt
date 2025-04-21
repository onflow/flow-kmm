package org.onflow.flow.models

import org.onflow.flow.infrastructure.BigIntegerCadenceSerializer
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.rlp.*
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.*

/**
 *
 *
 * @param id A 32-byte unique identifier for an entity.
 * @param script Base64 encoded Cadence script.
 * @param arguments Array of Base64 encoded arguments with in [JSON-Cadence interchange format](https://docs.onflow.org/cadence/json-cadence-spec/).
 * @param referenceBlockId A 32-byte unique identifier for an entity.
 * @param gasLimit The limit on the amount of computation a transaction is allowed to preform.
 * @param payer The 8-byte address of an account.
 * @param proposalKey
 * @param authorizers
 * @param payloadSignatures
 * @param envelopeSignatures
 * @param expandable
 * @param result
 * @param links
 */
@Serializable
data class Transaction(

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "id")
    @Required
    val id: String? = null,

    /* Base64 encoded Cadence script. */
    @SerialName(value = "script")
    @Serializable(Base64UFT8Serializer::class)
    @Required
    val script: String,

    /* Array of Base64 encoded arguments with in [JSON-Cadence interchange format](https://docs.onflow.org/cadence/json-cadence-spec/). */
    @SerialName(value = "arguments")
    @Serializable(CadenceBase64ListSerializer::class)
    @Required
    val arguments: List<Cadence.Value>,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "reference_block_id")
    @Required
    val referenceBlockId: String,

    /* The limit on the amount of computation a transaction is allowed to preform. */
    @Serializable(BigIntegerCadenceSerializer::class)
    @SerialName(value = "gas_limit")
    @Required
    val gasLimit: BigInteger,

    /* The 8-byte address of an account. */
    @SerialName(value = "payer")
    @Required
    val payer: String,

    @SerialName(value = "proposal_key")
    @Required
    val proposalKey: ProposalKey,

    @SerialName(value = "authorizers")
    @Required
    val authorizers: List<String>,

    @SerialName(value = "payload_signatures")
    @Required
    val payloadSignatures: List<TransactionSignature> = emptyList(),

    @SerialName(value = "envelope_signatures") @Required val envelopeSignatures: List<TransactionSignature> = emptyList(),

    @SerialName(value = "_expandable") @Required val expandable: TransactionExpandable? = null,

    @SerialName(value = "result") val result: TransactionResult? = null,

    @SerialName(value = "_links") val links: Links? = null
) {
    val signers: Map<String, Int>
        get() = listOf(listOf(proposalKey.address, payer), authorizers)
            .flatten()
            .toSet()
            .mapIndexed { index, item ->
                item to index
            }
            .toMap()

    private fun findSigners(address: String, signers: List<Signer>): List<Signer> {
        return signers.filter { signer ->
            signer.address == address
        }
    }

    suspend fun signPayload(signers: List<Signer>): Transaction {
        val payloadMessage = payloadMessage()
        val payloadSignatures = mutableListOf<TransactionSignature>()

        // Sign with the proposal key first.
        // If proposer is same as payer, we skip this step
        if (proposalKey.address != payer) {
            val signerList = findSigners(proposalKey.address, signers)
            for (signUser in signerList) {
                val signature = signUser.sign(payloadMessage)
                val txSignature = TransactionSignature(
                    address = signUser.address,
                    keyIndex = signUser.keyIndex,
                    signature = signature.toHexString(),
                    signerIndex = this.signers[signUser.address] ?: -1
                )
                payloadSignatures.add(txSignature)
            }
        }

        // Sign the transaction with each authorizer
        for (authorizer in authorizers) {
            if (proposalKey.address == authorizer || payer == authorizer) {
                continue
            }

            val signerList = findSigners(authorizer, signers)
            for (signUser in signerList) {
                val signature = signUser.sign(payloadMessage)
                val txSignature = TransactionSignature(
                    address = signUser.address,
                    keyIndex = signUser.keyIndex,
                    signature = signature.toHexString(),
                    signerIndex = this.signers[signUser.address] ?: -1
                )
                payloadSignatures.add(txSignature)
            }
        }

        payloadSignatures.sortWith(CompareTransactionSignature)
        return copy(payloadSignatures = payloadSignatures)
    }

    suspend fun signEnvelope(signers: List<Signer>): Transaction {
        val envelopeMessage = envelopeMessage()
        val envelopeSignatures = mutableListOf<TransactionSignature>()

        // Sign the transaction with payer
        val signerList = findSigners(payer, signers)
        for (signUser in signerList) {
            val signature = signUser.sign(envelopeMessage)
            val txSignature = TransactionSignature(
                address = signUser.address,
                keyIndex = signUser.keyIndex,
                signature = signature.toHexString(),
                //signerIndex = this.signers[signUser.address] ?: -1
            )
            envelopeSignatures.add(txSignature)
        }

        envelopeSignatures.sortWith(CompareTransactionSignature)
        return copy(envelopeSignatures = envelopeSignatures)
    }

    suspend fun sign(signers: List<Signer>): Transaction {
        return signPayload(signers).signEnvelope(signers)
    }
}

fun Transaction.payload(): List<RLPType> = listOf(
    script.toRLP(),
    RLPList(arguments.map { it.encode().toByteArray().toRLP() }),
    hex(referenceBlockId).toRLP(),
    gasLimit.toRLP(),
    hex(proposalKey.address).paddingZeroLeft().toRLP(),
    proposalKey.keyIndex.toRLP(),
    proposalKey.sequenceNumber.toRLP(),
    hex(payer).paddingZeroLeft().toRLP(),
    RLPList(authorizers.map { hex(it).paddingZeroLeft().toRLP() })
)

fun Transaction.toRLP(): RLPElement = payload().toRLP()

fun Transaction.payloadMessage(): ByteArray =
    DomainTag.Transaction.bytes +
            (RLPList(
                listOf(
                    RLPList(payload()),
                    RLPList(
                        payloadSignatures.map {
                            listOf((signers[it.address] ?: -1).toRLP(), it.keyIndex.toRLP(), hex(it.signature).toRLP()).toRLP()
                        }
                    )
                )
            )).encode()

fun Transaction.envelopeMessage(): ByteArray =
    DomainTag.Transaction.bytes +
            RLPList(
                listOf(
                    RLPList(payload()),
                    RLPList(
                        payloadSignatures.map {
                            listOf(
                                (signers[it.address] ?: -1).toRLP(),
                                it.keyIndex.toRLP(),
                                hex(it.signature).toRLP()
                            ).toRLP()
                        }
                    )
                )
            ).encode()

/**
 * Builder class to simplify transaction creation and signing
 */
class TransactionBuilder(
    private val script: String,
    private val arguments: List<Cadence.Value> = emptyList(),
    private val gasLimit: BigInteger = 1000.toBigInteger()
) {
    private var referenceBlockId: String? = null
    private var payer: String? = null
    private var proposalKey: ProposalKey? = null
    private var authorizers: List<String> = emptyList()
    private var signers: List<Signer> = emptyList()

    fun withReferenceBlockId(blockId: String): TransactionBuilder {
        this.referenceBlockId = blockId
        return this
    }

    fun withPayer(payer: String): TransactionBuilder {
        this.payer = payer
        return this
    }

    fun withProposalKey(address: String, keyIndex: Int, sequenceNumber: BigInteger): TransactionBuilder {
        this.proposalKey = ProposalKey(address, keyIndex, sequenceNumber)
        return this
    }

    fun withAuthorizers(authorizers: List<String>): TransactionBuilder {
        this.authorizers = authorizers
        return this
    }

    fun withSigners(signers: List<Signer>): TransactionBuilder {
        this.signers = signers
        return this
    }

    fun build(): Transaction {
        require(referenceBlockId != null) { "Reference block ID must be set" }
        require(payer != null) { "Payer must be set" }
        require(proposalKey != null) { "Proposal key must be set" }

        return Transaction(
            script = script,
            arguments = arguments,
            referenceBlockId = referenceBlockId!!,
            gasLimit = gasLimit,
            payer = payer!!,
            proposalKey = proposalKey!!,
            authorizers = authorizers
        )
    }

    /**
     * Builds and signs the transaction in one step
     */
    suspend fun buildAndSign(): Transaction {
        require(signers.isNotEmpty()) { "Signers must be set before signing" }
        return build().sign(signers)
    }
}