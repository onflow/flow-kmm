package org.onflow.flow.rlp

/**
   Original file: https://github.com/komputing/KEthereum/blob/master/rlp/src/main/kotlin/org/kethereum/rlp
   Convert it to KMM compatible
 */

internal const val ELEMENT_OFFSET = 128
internal const val LIST_OFFSET = 192

abstract class RLPType

data class RLPElement(val bytes: ByteArray) : RLPType() {

    override fun equals(other: Any?) = when (other) {
        is RLPElement -> bytes.contentEquals(other.bytes)
        else -> false
    }

    override fun hashCode() = bytes.contentHashCode()
}

data class RLPList(val element: List<RLPType>) : RLPType()

class IllegalRLPException(msg: String) : IllegalArgumentException(msg)