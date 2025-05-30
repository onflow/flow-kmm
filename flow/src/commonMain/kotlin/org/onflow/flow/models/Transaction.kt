package org.onflow.flow.models

import org.onflow.flow.infrastructure.BigIntegerCadenceSerializer
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.removeHexPrefix
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
    private fun findSigners(address: String, signers: List<Signer>): List<Signer> {
        // Normalize addresses by removing hex prefix for comparison
        val normalizedAddress = address.removeHexPrefix()
        return signers.filter { signer ->
            signer.address.removeHexPrefix() == normalizedAddress
        }
    }

    private suspend fun signPayload(signers: List<Signer>): Transaction {
        val payloadSignatures = mutableListOf<TransactionSignature>()
        val signedAddresses = mutableSetOf<String>()

        // Flow signature ordering rule: proposer first, then authorizers in order
        // Step 1: Proposer signs first (if proposer is not already an authorizer)
        val proposerAddress = proposalKey.address.removeHexPrefix()
        val authorizerAddresses = authorizers.map { it.removeHexPrefix() }
        
        // If proposer is NOT in authorizers, they sign first
        if (!authorizerAddresses.contains(proposerAddress)) {
            val signerList = findSigners(proposalKey.address, signers)
            for (signUser in signerList) {
                // Use payloadMessage() which already includes domain tags
                val messageToSign = payloadMessage()
                val signature = signUser.sign(messageToSign)  // Fix: Use sign() not signAsTransaction() since message has domain tags
                val txSignature = TransactionSignature(
                    address = signUser.address,
                    keyIndex = signUser.keyIndex,
                    signature = signature.toHexString()
                )
                payloadSignatures.add(txSignature)
                signedAddresses.add(signUser.address.removeHexPrefix())
            }
        }

        // Step 2: Authorizers sign in the order they appear in the authorizers list
        for (authorizer in authorizers) {
            val authorizerAddress = authorizer.removeHexPrefix()
            // Skip if already signed (deduplication for proposer who is also authorizer)
            if (!signedAddresses.contains(authorizerAddress)) {
                val signerList = findSigners(authorizer, signers)
                for (signUser in signerList) {
                    // Use payloadMessage() which already includes domain tags
                    val messageToSign = payloadMessage()
                    val signature = signUser.sign(messageToSign)  // Fix: Use sign() not signAsTransaction() since message has domain tags
                    val txSignature = TransactionSignature(
                        address = signUser.address,
                        keyIndex = signUser.keyIndex,
                        signature = signature.toHexString()
                    )
                    payloadSignatures.add(txSignature)
                    signedAddresses.add(signUser.address.removeHexPrefix())
                }
            }
        }

        // NO SORTING! Order is strictly determined by Flow specification
        return copy(payloadSignatures = payloadSignatures)
    }

    private suspend fun signEnvelope(signers: List<Signer>): Transaction {
        val envelopeSignatures = mutableListOf<TransactionSignature>()

        // Sign the transaction with payer(s) - order should match payer list
        val signerList = findSigners(payer, signers)
        for (signUser in signerList) {
            // Use envelopeMessage() which already includes domain tags
            val messageToSign = envelopeMessage()
            val signature = signUser.sign(messageToSign)  // Fix: Use sign() not signAsTransaction() since message has domain tags
            val txSignature = TransactionSignature(
                address = signUser.address,
                keyIndex = signUser.keyIndex,
                signature = signature.toHexString()
            )
            envelopeSignatures.add(txSignature)
        }

        // NO SORTING! Order is strictly determined by Flow specification
        return copy(envelopeSignatures = envelopeSignatures)
    }

    suspend fun sign(signers: List<Signer>): Transaction {
        // Check if this is a single-signer transaction (all roles performed by same account)
        val allSignerAddresses = signers.map { it.address.removeHexPrefix() }.toSet()
        val proposerAddress = proposalKey.address.removeHexPrefix()
        val payerAddress = payer.removeHexPrefix()
        val authorizerAddresses = authorizers.map { it.removeHexPrefix() }.toSet()
        
        val allRoleAddresses = setOf(proposerAddress, payerAddress) + authorizerAddresses
        
        // If all roles are performed by the same single account, only sign envelope
        if (allRoleAddresses.size == 1 && allSignerAddresses.size == 1 && allRoleAddresses == allSignerAddresses) {
            println("🔍 Single-signer transaction detected - only signing envelope")
            return signEnvelope(signers)
        } else {
            println("🔍 Multi-signer transaction detected - signing both payload and envelope")
            return signPayload(signers).signEnvelope(signers)
        }
    }

    /**
     * Add a payload signature to the transaction (like JVM SDK)
     * Note: This method preserves Flow's strict signature ordering
     */
    suspend fun addPayloadSignature(address: String, keyIndex: Int, signer: Signer): Transaction {
        // Use payloadMessage() which already includes domain tags
        val messageToSign = payloadMessage()
        val signature = signer.sign(messageToSign)  // Fix: Use sign() not signAsTransaction() since message has domain tags
        val txSignature = TransactionSignature(
            address = address,
            keyIndex = keyIndex,
            signature = signature.toHexString()
        )
        // DO NOT SORT - preserve the order signatures are added (Flow requirement)
        val newPayloadSignatures = payloadSignatures + txSignature
        return copy(payloadSignatures = newPayloadSignatures)
    }

    /**
     * Add an envelope signature to the transaction (like JVM SDK)
     * Note: This method preserves Flow's strict signature ordering
     */
    suspend fun addEnvelopeSignature(address: String, keyIndex: Int, signer: Signer): Transaction {
        // Use envelopeMessage() which already includes domain tags
        val messageToSign = envelopeMessage()
        val signature = signer.sign(messageToSign)  // Fix: Use sign() not signAsTransaction() since message has domain tags
        val txSignature = TransactionSignature(
            address = address,
            keyIndex = keyIndex,
            signature = signature.toHexString()
        )
        // DO NOT SORT - preserve the order signatures are added (Flow requirement)
        val newEnvelopeSignatures = envelopeSignatures + txSignature
        return copy(envelopeSignatures = newEnvelopeSignatures)
    }
}

fun Transaction.payload(): List<RLPType> = listOf(
    script.toRLP(),
    RLPList(arguments.map { it.encode().toByteArray().toRLP() }),
    hex(referenceBlockId).paddingZeroLeft(32).toRLP(),
    gasLimit.toRLP(),
    hex(proposalKey.address).paddingZeroLeft().toRLP(),
    proposalKey.keyIndex.toRLP(),
    proposalKey.sequenceNumber.toRLP(),
    hex(payer).paddingZeroLeft().toRLP(),
    RLPList(authorizers.map { hex(it).paddingZeroLeft().toRLP() })
)

/**
 * Create payload that exactly matches Flow JVM SDK structure
 * 
 * JVM SDK Payload structure:
 * @RLP(0) script: ByteArray
 * @RLP(1) arguments: List<ByteArray>  
 * @RLP(2) referenceBlockId: ByteArray
 * @RLP(3) gasLimit: Long
 * @RLP(4) proposalKeyAddress: ByteArray
 * @RLP(5) proposalKeyIndex: Long
 * @RLP(6) proposalKeySequenceNumber: Long
 * @RLP(7) payer: ByteArray
 * @RLP(8) authorizers: List<ByteArray>
 */
fun Transaction.payloadJVMStyle(): List<RLPType> = listOf(
    script.toByteArray().toRLP(),                                    // ByteArray
    RLPList(arguments.map { it.encode().toByteArray().toRLP() }),    // List<ByteArray>
    hex(referenceBlockId).paddingZeroLeft(32).toRLP(),              // Fix: Pad to 32 bytes like Flow JS SDK
    gasLimit.intValue().toRLP(),                                     // Convert BigInteger to Int (which can be used as Long)
    hex(proposalKey.address).paddingZeroLeft().toRLP(),             // ByteArray (8 bytes)
    proposalKey.keyIndex.toRLP(),                                    // Int (compatible with Long)
    proposalKey.sequenceNumber.intValue().toRLP(),                   // Convert BigInteger to Int
    hex(payer).paddingZeroLeft().toRLP(),                           // ByteArray (8 bytes)
    RLPList(authorizers.map { hex(it).paddingZeroLeft().toRLP() })  // List<ByteArray>
)

/**
 * Create the payload message for signing - should be just the payload structure for Flow JS SDK compatibility
 * This matches the Flow JS SDK behavior exactly
 */
fun Transaction.payloadMessage(): ByteArray =
    DomainTag.Transaction.bytes + RLPList(payload()).encode()

/**
 * Create the envelope message for signing - should include existing payload signatures with JVM-style encoding
 * This matches the Flow JS SDK behavior exactly  
 */
fun Transaction.envelopeMessage(): ByteArray =
    DomainTag.Transaction.bytes + createEnvelopeRLPFlowJSStyle()

/**
 * Create the complete transaction envelope that includes both payload and envelope signatures
 * This is what gets broadcast to the network, different from envelopeMessage() which is for signing
 */
fun Transaction.completeEnvelopeMessage(): ByteArray =
    DomainTag.Transaction.bytes + createCompleteEnvelopeRLP()

/**
 * Helper function to create RLP-encoded envelope data for Flow JS SDK compatibility
 * Structure: [payload, payloadSignatures] where signatures use signer indices
 */
internal fun Transaction.createEnvelopeRLPFlowJSStyle(): ByteArray {
    // Build signer list like JVM SDK
    val signerList = mutableListOf<String>()
    val seen = mutableSetOf<String>()
    
    // Add signers in JVM SDK order: proposer, payer, then authorizers
    fun addSigner(address: String) {
        val normalized = address.removeHexPrefix()
        if (normalized !in seen) {
            signerList.add(normalized)
            seen.add(normalized)
        }
    }
    
    addSigner(proposalKey.address)
    addSigner(payer)
    authorizers.forEach { addSigner(it) }
    
    // Create signer index map
    val signerIndexMap = signerList.withIndex().associate { it.value to it.index }
    
    // Convert payload signatures to indexed format and sort by signer index, then key index
    val indexedPayloadSignatures = payloadSignatures.map { sig ->
        val signerIndex = signerIndexMap[sig.address.removeHexPrefix()] ?: 0
        Triple(signerIndex, sig.keyIndex, sig.signature)
    }.sortedWith(compareBy<Triple<Int, Int, String>> { it.first }.thenBy { it.second })
    
    val payloadSignaturesList = indexedPayloadSignatures.map { (signerIndex, keyIndex, signature) ->
        // Create each signature as an RLP list: [signerIndex, keyIndex, signature]
        RLPList(listOf(
            signerIndex.toRLP(),
            keyIndex.toRLP(),
            hex(signature).toRLP()
        ))
    }
    
    return RLPList(
        listOf(
            RLPList(payloadJVMStyle()),  // Fix: Use payloadJVMStyle() to match JS SDK script encoding
            RLPList(payloadSignaturesList)
        )
    ).encode()
}

/**
 * Helper function to create RLP-encoded transaction data for signing
 * @param includePayloadSignatures Whether to include existing payload signatures in the structure
 * 
 * NOTE: This implementation differs from Flow JVM SDK in signature encoding:
 * - JVM SDK uses: [signerIndex: Int, keyIndex: Int, signature: ByteArray]
 * - This KMM uses: [address: ByteArray(8), keyIndex: Int, signature: ByteArray]
 * 
 * The JVM SDK approach uses signer indices (position in signerList) while this uses addresses.
 * Both should produce valid Flow transactions, but for maximum compatibility with JVM SDK,
 * consider using createSigningRLPJVMStyle() instead.
 */
internal fun Transaction.createSigningRLP(includePayloadSignatures: Boolean = false): ByteArray {
    val signaturesList = if (includePayloadSignatures) {
        payloadSignatures.map {
            listOf(
                hex(it.address).paddingZeroLeft().toRLP(),
                it.keyIndex.toRLP(),
                hex(it.signature).toRLP()
            ).toRLP()
        }
    } else {
        emptyList<RLPType>()
    }
    
    return RLPList(
        listOf(
            RLPList(payload()),
            RLPList(signaturesList)
        )
    ).encode()
}

/**
 * Alternative RLP encoding that matches Flow JVM SDK format exactly
 * Uses signer indices instead of addresses in signature encoding
 */
internal fun Transaction.createSigningRLPJVMStyle(includePayloadSignatures: Boolean = false): ByteArray {
    // Build signer list like JVM SDK
    val signerList = mutableListOf<String>()
    val seen = mutableSetOf<String>()
    
    // Add signers in JVM SDK order: proposer, payer, then authorizers
    fun addSigner(address: String) {
        val normalized = address.removeHexPrefix()
        if (normalized !in seen) {
            signerList.add(normalized)
            seen.add(normalized)
        }
    }
    
    addSigner(proposalKey.address)
    addSigner(payer)
    authorizers.forEach { addSigner(it) }
    
    // Create signer index map
    val signerIndexMap = signerList.withIndex().associate { it.value to it.index }
    
    val signaturesList = if (includePayloadSignatures) {
        payloadSignatures.map { sig ->
            val signerIndex = signerIndexMap[sig.address.removeHexPrefix()] ?: 0
            listOf(
                signerIndex.toRLP(),
                sig.keyIndex.toRLP(),
                hex(sig.signature).toRLP()
            ).toRLP()
        }
    } else {
        emptyList<RLPType>()
    }
    
    return RLPList(
        listOf(
            RLPList(payloadJVMStyle()),  // Fix: Use payloadJVMStyle() to match JS SDK script encoding
            RLPList(signaturesList)
        )
    ).encode()
}

/**
 * Public function for testing JVM-style payload message creation
 */
fun Transaction.payloadMessageJVMStyle(): ByteArray =
    DomainTag.Transaction.bytes + createSigningRLPJVMStyle(includePayloadSignatures = false)

/**
 * Public function for testing JVM-style envelope message creation
 */
fun Transaction.envelopeMessageJVMStyle(): ByteArray =
    DomainTag.Transaction.bytes + createSigningRLPJVMStyle(includePayloadSignatures = true)

/**
 * Helper function to create complete envelope RLP with both payload and envelope signatures
 */
internal fun Transaction.createCompleteEnvelopeRLP(): ByteArray {
    // Build signer list like JVM SDK
    val signerList = mutableListOf<String>()
    val seen = mutableSetOf<String>()
    
    // Add signers in JVM SDK order: proposer, payer, then authorizers
    fun addSigner(address: String) {
        val normalized = address.removeHexPrefix()
        if (normalized !in seen) {
            signerList.add(normalized)
            seen.add(normalized)
        }
    }
    
    addSigner(proposalKey.address)
    addSigner(payer)
    authorizers.forEach { addSigner(it) }
    
    // Create signer index map
    val signerIndexMap = signerList.withIndex().associate { it.value to it.index }
    
    // Convert payload signatures to indexed format and sort by signer index, then key index
    val indexedPayloadSignatures = payloadSignatures.map { sig ->
        val signerIndex = signerIndexMap[sig.address.removeHexPrefix()] ?: 0
        Triple(signerIndex, sig.keyIndex, sig.signature)
    }.sortedWith(compareBy<Triple<Int, Int, String>> { it.first }.thenBy { it.second })
    
    val payloadSignaturesList = indexedPayloadSignatures.map { (signerIndex, keyIndex, signature) ->
        RLPList(listOf(
            signerIndex.toRLP(),
            keyIndex.toRLP(),
            hex(signature).toRLP()
        ))
    }
    
    // Convert envelope signatures to indexed format and sort by signer index, then key index
    val indexedEnvelopeSignatures = envelopeSignatures.map { sig ->
        val signerIndex = signerIndexMap[sig.address.removeHexPrefix()] ?: 0
        Triple(signerIndex, sig.keyIndex, sig.signature)
    }.sortedWith(compareBy<Triple<Int, Int, String>> { it.first }.thenBy { it.second })
    
    val envelopeSignaturesList = indexedEnvelopeSignatures.map { (signerIndex, keyIndex, signature) ->
        RLPList(listOf(
            signerIndex.toRLP(),
            keyIndex.toRLP(),
            hex(signature).toRLP()
        ))
    }
    
    return RLPList(
        listOf(
            RLPList(payloadJVMStyle()),  // Fix: Use payloadJVMStyle() to match JS SDK script encoding
            RLPList(payloadSignaturesList),
            RLPList(envelopeSignaturesList)
        )
    ).encode()
}

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