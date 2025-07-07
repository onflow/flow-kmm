package org.onflow.flow.infrastructure

object FixedPointFormatter {
    fun format(num: String, precision: ULong): String? {
        return try {
            // Handle empty or invalid input
            if (num.isEmpty() || num.isBlank()) {
                return null
            }
            
            val parts = num.split(".")
            if (parts.size == 1) {
                // For whole numbers (including "0"), add decimal point with appropriate precision
                "$num.0"
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