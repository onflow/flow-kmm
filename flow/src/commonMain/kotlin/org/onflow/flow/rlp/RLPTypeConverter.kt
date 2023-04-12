package org.onflow.flow.rlp

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.BigInteger.Companion.ZERO
import com.ionspin.kotlin.bignum.integer.Sign
import io.ktor.utils.io.core.*

/**
   Original file: https://github.com/komputing/KEthereum/blob/master/rlp/src/main/kotlin/org/kethereum/rlp
   Convert it to KMM compatible
 */

fun String.toRLP() = RLPElement(toByteArray())
fun Int.toRLP() = RLPElement(toMinimalByteArray())
fun BigInteger.toRLP() = RLPElement(toByteArray().removeLeadingZero())
fun ByteArray.toRLP() = RLPElement(this)
fun Byte.toRLP() = RLPElement(ByteArray(1) { this })
fun List<RLPType>.toRLP() = RLPElement(RLPList(this.map { it }).encode())

// from RLP
fun RLPElement.toIntFromRLP() = if (bytes.isEmpty()) {
    0
} else {
    bytes.mapIndexed { index, byte -> (byte.toInt() and 0xff).shl((bytes.size - 1 - index) * 8) }
        .reduce { acc, i -> acc + i }
}

fun RLPElement.toUnsignedBigIntegerFromRLP(): BigInteger = if (bytes.isEmpty()) ZERO else BigInteger.fromByteArray(bytes, Sign.POSITIVE)
fun RLPElement.toByteFromRLP(): Byte {
    require(bytes.size == 1) { "trying to convert RLP with != 1 byte to Byte" }
    return bytes.first()
}

fun RLPElement.toStringFromRLP() = String(bytes)

fun Int.toByteArray() = ByteArray(4) { i ->
    shr(8 * (3 - i)).toByte()
}

private fun ByteArray.minimalStart() = indexOfFirst { it != 0.toByte() }.let { if (it == -1) 4 else it }

fun Int.toMinimalByteArray() = toByteArray().let {
    it.copyOfRange(it.minimalStart(), 4)
}
fun ByteArray.removeLeadingZero() = if (first() == 0.toByte()) copyOfRange(1, size) else this


fun ByteArray.paddingZeroLeft(blockSize: Int = 8): ByteArray {
    if (size >= blockSize) {
        return this
    }
    return ByteArray(size = blockSize - size) + this
}

fun ByteArray.paddingZeroRight(blockSize: Int = 8): ByteArray {
    if (size >= blockSize) {
        return this
    }
    return this + ByteArray(size = blockSize - size)
}