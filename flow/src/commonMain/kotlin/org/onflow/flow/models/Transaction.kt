package org.onflow.flow.models

import org.onflow.flow.infrastructure.BigIntegerCadenceSerializer
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.addHexPrefix
import org.onflow.flow.infrastructure.removeHexPrefix
import org.onflow.flow.rlp.*
import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
data class Transaction (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "id") @Required val id: String? = null,

    /* Base64 encoded Cadence script. */
    @Serializable(Base64UFT8Serializer::class)
    @SerialName(value = "script") @Required val script: String,

    /* Array of Base64 encoded arguments with in [JSON-Cadence interchange format](https://docs.onflow.org/cadence/json-cadence-spec/). */
    @Serializable(CadenceBase64ListSerializer::class)
    @SerialName(value = "arguments") @Required val arguments: List<Cadence.Value>,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "reference_block_id") @Required val referenceBlockId: String,

    /* The limit on the amount of computation a transaction is allowed to preform. */
    @Serializable(BigIntegerCadenceSerializer::class)
    @SerialName(value = "gas_limit") @Required val gasLimit: BigInteger,

    /* The 8-byte address of an account. */
    @SerialName(value = "payer") @Required val payer: String,

    @SerialName(value = "proposal_key") @Required val proposalKey: ProposalKey,

    @SerialName(value = "authorizers") @Required val authorizers: List<String>,

    @SerialName(value = "payload_signatures") @Required val payloadSignatures: List<TransactionSignature> = emptyList(),

    @SerialName(value = "envelope_signatures") @Required val envelopeSignatures: List<TransactionSignature> = emptyList(),

    @SerialName(value = "_expandable") @Required val expandable: TransactionExpandable? = null,

    @SerialName(value = "result") val result: TransactionResult? = null,

    @SerialName(value = "_links") val links: Links? = null
) {
    val signers: Map<String, Int>
        get() = listOf(listOf(proposalKey.address, payer), authorizers)
            .flatten()
            .toSet()
            .mapIndexed{ index, item ->
                item to index
            }
            .toMap()
}

fun Transaction.payload(): List<RLPType> = listOf(
    script.toRLP(),
    RLPList(arguments.map{ it.encode().toByteArray().toRLP() }),
    hex(referenceBlockId).toRLP(),
    gasLimit.toRLP(),
    hex(proposalKey.address).paddingZeroLeft().toRLP(),
    proposalKey.keyIndex.toRLP(),
    proposalKey.sequenceNumber.toRLP(),
    hex(payer).paddingZeroLeft().toRLP(),
    RLPList(authorizers.map{hex(it).paddingZeroLeft().toRLP()})
)

fun Transaction.toRLP(): RLPElement = payload().toRLP()

fun Transaction.payloadMessage(): ByteArray =
    DomainTag.Transaction().bytes +
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

object Base64UFT8Serializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("base64ToUTF8", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: String) = encoder.encodeString(value.toByteArray().encodeBase64())
    override fun deserialize(decoder: Decoder): String = decoder.decodeString().decodeBase64Bytes().decodeToString()
}

object Base64HexSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("base64ToUTF8", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: String) = encoder.encodeString(hex(value.removeHexPrefix()).encodeBase64())
    override fun deserialize(decoder: Decoder): String = hex(decoder.decodeString().decodeBase64Bytes()).addHexPrefix()
}

object CadenceBase64Serializer : KSerializer<Cadence.Value> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CadenceBase64", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Cadence.Value) = encoder.encodeString(value.encodeBase64())
    override fun deserialize(decoder: Decoder): Cadence.Value = Cadence.Value.decodeFromBase64(decoder.decodeString())
}

class CadenceBase64ListSerializer : KSerializer<List<Cadence.Value>> {
    private val elementSerializer = ListSerializer(CadenceBase64Serializer)
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CadenceBase64List", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): List<Cadence.Value> {
        return decoder.decodeSerializableValue(elementSerializer)
    }

    override fun serialize(encoder: Encoder, value: List<Cadence.Value>) {
        encoder.encodeSerializableValue(elementSerializer, value)
    }
}


