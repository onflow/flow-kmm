fun ByteArray.bytesToHex(): String {
    val hexChars = "0123456789abcdef"
    val result = CharArray(size * 2)
    for (i in indices) {
        val v = this[i].toInt() and 0xFF
        result[i * 2] = hexChars[v ushr 4]
        result[i * 2 + 1] = hexChars[v and 0x0F]
    }
    return String(result)
}

fun String.hexToBytes(): ByteArray {
    // Remove a leading "0x", if present.
    val cleanInput = if (lowercase().startsWith("0x")) substring(2) else this
    require(cleanInput.length % 2 == 0) { "Hex string must have an even length" }
    val result = ByteArray(cleanInput.length / 2)
    for (i in 0 until cleanInput.length step 2) {
        val firstDigit = hexCharToInt(cleanInput[i])
        val secondDigit = hexCharToInt(cleanInput[i + 1])
        result[i / 2] = ((firstDigit shl 4) or secondDigit).toByte()
    }
    return result
}

private fun hexCharToInt(c: Char): Int = when (c) {
    in '0'..'9' -> c - '0'
    in 'a'..'f' -> c - 'a' + 10
    in 'A'..'F' -> c - 'A' + 10
    else -> throw IllegalArgumentException("Invalid hex character: $c")
}
