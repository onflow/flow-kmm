package org.onflow.flow.models

import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.addHexPrefix
import org.onflow.flow.infrastructure.removeHexPrefix

object Base64UFT8Serializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("base64ToUTF8", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: String) = encoder.encodeString(value.toByteArray().encodeBase64())
    override fun deserialize(decoder: Decoder): String = decoder.decodeString().decodeBase64Bytes().decodeToString()
}

object StringIntSerializer : KSerializer<Int> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("StringInt", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Int) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Int = decoder.decodeString().toInt()
}

object Base64HexSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("base64ToUTF8", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: String) = encoder.encodeString(hex(value.removeHexPrefix()).encodeBase64())
    override fun deserialize(decoder: Decoder): String = hex(decoder.decodeString().decodeBase64Bytes()).addHexPrefix()
}

object CadenceBase64Serializer : KSerializer<Cadence.Value> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CadenceBase64", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Cadence.Value) = encoder.encodeString(value.encodeBase64())
    override fun deserialize(decoder: Decoder): Cadence.Value {
        return try {
            Cadence.Value.decodeFromBase64(decoder.decodeString())
        } catch (e: Exception) {
            // Minimal fallback for problematic Cadence values (e.g., empty type fields)
            Cadence.void()
        }
    }
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

fun ByteArray.toHexString() = hex(this)
fun ByteArray.toBase64() = encodeBase64()