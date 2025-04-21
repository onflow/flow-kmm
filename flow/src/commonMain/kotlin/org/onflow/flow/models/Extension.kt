package org.onflow.flow.models

@OptIn(ExperimentalUnsignedTypes::class)
fun ByteArray.bytesToHex(): String = asUByteArray().joinToString("") { it.toString(16).padStart(2, '0') }

fun String.hexToBytes(): ByteArray {
    val cleanHex = if (startsWith("0x")) substring(2) else this
    if (cleanHex.isEmpty()) return ByteArray(0)
    return cleanHex.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
}

//fun ByteArray.sha3256Hash(): ByteArray = MessageDigest.getInstance("SHA3-256", "BC").digest(this)
//
//fun ByteArray.sha2256Hash(): ByteArray = MessageDigest.getInstance("SHA2-256", "BC").digest(this)

fun fixedSize(bytes: ByteArray, size: Int): ByteArray {
    if (bytes.size > size) {
        throw IllegalArgumentException("must have no more than $size bytes long")
    }
    return if (bytes.size < size) {
        ByteArray(size - bytes.size) + bytes
    } else {
        bytes
    }
}