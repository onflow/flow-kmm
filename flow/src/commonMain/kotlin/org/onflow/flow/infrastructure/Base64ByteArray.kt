package org.onflow.flow.infrastructure

import io.ktor.util.decodeBase64Bytes
import io.ktor.util.encodeBase64
import io.ktor.util.hex
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

class Base64ByteArray(val bytes: ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Base64ByteArray
        return bytes.contentEquals(other.bytes)
    }

    override fun hashCode(): Int {
        return bytes.contentHashCode()
    }

    override fun toString(): String {
        return "Base64ByteArray(${hex(bytes)})"
    }
}

object Base64ByteArraySerializer : KSerializer<Base64ByteArray> {
    override val descriptor = PrimitiveSerialDescriptor("Base64ByteArray", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Base64ByteArray) {
        encoder.encodeString(value.bytes.encodeBase64())
    }
    override fun deserialize(decoder: Decoder): Base64ByteArray {
        return Base64ByteArray(decoder.decodeString().decodeBase64Bytes())
    }
}