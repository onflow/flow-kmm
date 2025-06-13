package org.onflow.flow.infrastructure

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.toBigDecimal
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

object ByteCadenceSerializer : KSerializer<Byte> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Byte) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Byte = decoder.decodeString().toByte()
}

object UByteCadenceSerializer : KSerializer<UByte> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: UByte) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): UByte = decoder.decodeString().toUByte()
}

object IntCadenceSerializer : KSerializer<Int> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Int) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Int = decoder.decodeString().toInt()
}

object UIntCadenceSerializer : KSerializer<UInt> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: UInt) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): UInt = decoder.decodeString().toUInt()
}

object ShortCadenceSerializer : KSerializer<Short> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Short) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Short = decoder.decodeString().toShort()
}

object UShortCadenceSerializer : KSerializer<UShort> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: UShort) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): UShort = decoder.decodeString().toUShort()
}

object LongCadenceSerializer : KSerializer<Long> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Long) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Long = decoder.decodeString().toLong()
}

object ULongCadenceSerializer : KSerializer<ULong> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: ULong) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): ULong = decoder.decodeString().toULong()
}

object BigIntegerCadenceSerializer : KSerializer<BigInteger> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: BigInteger) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): BigInteger = decoder.decodeString().toBigInteger()
}

object BigDecimalCadenceSerializer : KSerializer<BigDecimal> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: BigDecimal) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): BigDecimal = decoder.decodeString().toBigDecimal()
}

object DoubleCadenceSerializer : KSerializer<Double> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Double) {
        // Convert scientific notation to proper decimal format
        val decimalString = formatDoubleAsDecimal(value)
        encoder.encodeString(FixedPointFormatter.format(decimalString, 8UL) ?: "")
    }
    override fun deserialize(decoder: Decoder): Double = decoder.decodeString().toDouble()
    
    private fun formatDoubleAsDecimal(value: Double): String {
        // Handle special cases
        if (value == 0.0) return "0"
        if (value.isNaN()) return "0"
        if (value.isInfinite()) return "0"
        
        val stringValue = value.toString()
        
        // If already in decimal format, return as is
        if (!stringValue.contains('E') && !stringValue.contains('e')) {
            return stringValue
        }
        
        // For scientific notation, manually convert to decimal
        return try {
            // Handle the specific case of 1.0E-8 and similar small values
            when {
                value >= 1.0 -> {
                    // For values >= 1, should not normally be in scientific notation for our use case
                    val longValue = value.toLong()
                    if (value == longValue.toDouble()) longValue.toString() else stringValue
                }
                value > 0.0 -> {
                    // For positive values < 1, convert scientific notation to decimal
                    val decimalValue = convertSmallNumberToDecimal(value)
                    decimalValue
                }
                value < 0.0 -> {
                    // For negative values, handle recursively
                    "-" + formatDoubleAsDecimal(-value)
                }
                else -> "0"
            }
        } catch (e: Exception) {
            // Fallback: use a safe default for UFix64
            if (value > 0 && value <= 1e-8) "0.00000001" else "0"
        }
    }
    
    private fun convertSmallNumberToDecimal(value: Double): String {
        // Handle conversion of small numbers like 1.0E-8 to 0.00000001
        val stringValue = value.toString()
        
        if (stringValue.contains("E-") || stringValue.contains("e-")) {
            // Extract exponent
            val parts = stringValue.uppercase().split("E")
            if (parts.size == 2) {
                val coefficient = parts[0].toDoubleOrNull() ?: return "0"
                val exponent = parts[1].toIntOrNull() ?: return "0"
                
                // For 1.0E-8: coefficient=1.0, exponent=-8
                // We want: 0.00000001 (8 decimal places total)
                val totalDecimalPlaces = kotlin.math.abs(exponent)
                
                // Convert coefficient to integer representation
                val coefficientInt = if (coefficient == coefficient.toInt().toDouble()) {
                    coefficient.toInt()
                } else {
                    // Handle coefficients with decimals
                    (coefficient * 10).toInt()
                }
                
                // Build the decimal string
                return when {
                    totalDecimalPlaces == 0 -> coefficientInt.toString()
                    totalDecimalPlaces == 1 -> "0.$coefficientInt"
                    else -> {
                        val leadingZeros = totalDecimalPlaces - 1
                        "0." + "0".repeat(leadingZeros) + coefficientInt.toString()
                    }
                }
            }
        }
        
        return stringValue
    }
}

/**
 * A safe string serializer that can handle both string and numeric values in JSON.
 * This prevents parsing failures when large numbers are encountered in string fields.
 * 
 * The serializer will:
 * - Accept both quoted strings and unquoted numbers from JSON
 * - Always return a string representation
 * - Handle very large numbers that might cause parsing issues
 */
object SafeStringSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("SafeString", PrimitiveKind.STRING)
    
    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }
    
    override fun deserialize(decoder: Decoder): String {
        return try {
            // Try to decode as string first
            decoder.decodeString()
        } catch (e: Exception) {
            try {
                // If that fails, try to decode as JsonElement and convert to string
                val jsonDecoder = decoder as? JsonDecoder
                if (jsonDecoder != null) {
                    val element = jsonDecoder.decodeJsonElement()
                    when (element) {
                        is JsonPrimitive -> {
                            // Handle both quoted strings and unquoted numbers
                            if (element.isString) {
                                element.content
                            } else {
                                // Convert numeric value to string
                                element.content
                            }
                        }
                        else -> element.toString()
                    }
                } else {
                    // Fallback: try to decode as long and convert to string
                    decoder.decodeLong().toString()
                }
            } catch (e2: Exception) {
                try {
                    // Last resort: try to decode as double and convert to string
                    decoder.decodeDouble().toString()
                } catch (e3: Exception) {
                    // If all else fails, return "0" as a safe default
                    "0"
                }
            }
        }
    }
}

object CadenceTypeSerializer : KSerializer<Cadence.Type> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Cadence.Type", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Cadence.Type) {
        encoder.encodeString(value.value)
    }

    override fun deserialize(decoder: Decoder): Cadence.Type {
        return try {
            val key = decoder.decodeString()
            Cadence.Type.findByKey(key)
        } catch (e: IllegalArgumentException) {
            Cadence.Type.VOID
        }
    }
}

//open class NewNumberSerializer<T : Any>(val type: KClass<T> ): KSerializer<T> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)
//    override fun serialize(encoder: Encoder, value: T) = encoder.encodeString(value.toString())
//    override fun deserialize(decoder: Decoder): T {
//        val value = decoder.decodeString()
//        return when (type) {
//            Int::class -> { value.toInt() }
//            UInt::class -> { value.toUInt() }
//            else -> {
//                throw Exception("Can't convert $this to Number ")
//            }
//        } as T
//    }
//}

//class IntSerializer: NewNumberSerializer<Int>(type = Int::class)
//class UIntSerializer: NewNumberSerializer<UInt>(type = UInt::class)

//inline fun <reified T: Any> String.toNumber(t: KClass<T>): T {
//    return when (t) {
//        Int::class -> { toInt() }
//        UInt::class -> { toUInt() }
//        else -> {
//            throw Exception("Can't convert $this to Number ")
//        }
//    } as T
//}
