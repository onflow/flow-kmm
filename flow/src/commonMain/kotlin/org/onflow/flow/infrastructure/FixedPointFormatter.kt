package org.onflow.flow.infrastructure

object FixedPointFormatter {
    fun format(num: String, precision: ULong): String? {
        return try {
            val parts = num.split(".")
            if (parts.size == 1) {
                num
            } else {
                val integerPart = parts[0]
                val decimalPart = parts[1].take(precision.toInt())
                "$integerPart.$decimalPart"
            }
        } catch (e: Exception) {
            null
        }
    }
}