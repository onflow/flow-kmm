package org.onflow.flow.rlp
/**
   Original file: https://github.com/komputing/KEthereum/blob/master/rlp/src/main/kotlin/org/kethereum/rlp
   Convert it to KMM compatible
 */

fun RLPType.encode(): ByteArray = when (this) {
    is RLPElement -> bytes.encodeLegacyTxRLP(ELEMENT_OFFSET)
    is RLPList -> element.asSequence().map { it.encode() }
        .fold(ByteArray(0)) { acc, bytes -> acc + bytes } // this can be speed optimized when needed
        .encodeLegacyTxRLP(LIST_OFFSET)
    else -> throw IllegalArgumentException("Unsupported RLPType: $this")
}

internal fun ByteArray.encodeLegacyTxRLP(offset: Int) = when {
    size == 1 && ((first().toInt() and 0xff) < ELEMENT_OFFSET) && offset == ELEMENT_OFFSET -> this
    size <= 55 -> ByteArray(1) { (size + offset).toByte() }.plus(this)
    else -> size.toMinimalByteArray().let { arr ->
        ByteArray(1) { (offset + 55 + arr.size).toByte() } + arr + this
    }
}