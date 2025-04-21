package org.onflow.flow.models

import kotlinx.serialization.*

@Serializable
data class FlowAddress(val bytes: ByteArray) {
    companion object {
        val FLOW_ADDRESS_SIZE_BYTES = 8
        fun of(bytes: ByteArray): FlowAddress = FlowAddress(fixedSize(bytes, FLOW_ADDRESS_SIZE_BYTES))
    }
    constructor(hex: String) : this(fixedSize(hex.hexToBytes(), FLOW_ADDRESS_SIZE_BYTES))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
//        if (!bytes.contentEquals(other.bytes)) return false
        return true
    }

    val base16Value: String get() = bytes.toHexString()

    val formatted: String = "0x$base16Value"

    override fun hashCode(): Int {
        return bytes.contentHashCode()
    }
}
