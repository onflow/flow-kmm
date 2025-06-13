package org.onflow.flow.infrastructure

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DoubleCadenceSerializerTest {

    @Test
    fun testScientificNotationConversion() {
        // Test that 1.0E-8 gets converted to proper decimal format
        val scientificValue = 1.0E-8
        println("Original value: $scientificValue")
        println("Value toString: ${scientificValue.toString()}")
        
        val ufixValue = Cadence.ufix64(scientificValue)
        
        // Serialize to JSON
        val json = Json.encodeToString(ufixValue)
        println("Serialized JSON: $json")
        
        // Parse the JSON to extract just the value
        val jsonElement = Json.parseToJsonElement(json)
        val valueString = jsonElement.jsonObject["value"]?.jsonPrimitive?.content ?: ""
        println("Extracted value: $valueString")
        
        // Debug the boolean conditions on the actual value
        val containsE = valueString.contains("E")
        val containse = valueString.contains("e")
        val condition = !valueString.contains("E") && !valueString.contains("e")
        
        println("Value contains 'E': $containsE")
        println("Value contains 'e': $containse")
        println("Combined condition: $condition")
        
        // Verify that the serialized value is in decimal format, not scientific notation
        assertTrue("Serialized value should not contain scientific notation: $valueString") {
            condition
        }
        
        // Verify it contains the expected decimal representation
        assertTrue("Should contain decimal representation: $valueString") {
            valueString == "0.00000001"
        }
    }
    
    @Test
    fun testRegularDecimalValues() {
        // Test that regular decimal values are preserved
        val regularValue = 1.5
        val ufixValue = Cadence.ufix64(regularValue)
        
        val json = Json.encodeToString(ufixValue)
        
        assertTrue("Should contain the decimal value") {
            json.contains("1.5")
        }
    }
    
    @Test
    fun testZeroValue() {
        val zeroValue = 0.0
        val ufixValue = Cadence.ufix64(zeroValue)
        
        val json = Json.encodeToString(ufixValue)
        
        assertTrue("Should contain zero") {
            json.contains("\"0\"")
        }
    }
    
    @Test
    fun testVerySmallValue() {
        // Test another small scientific notation value
        val smallValue = 5.0E-7  // 0.0000005
        val ufixValue = Cadence.ufix64(smallValue)
        
        val json = Json.encodeToString(ufixValue)
        
        // Extract just the value from JSON
        val jsonElement = Json.parseToJsonElement(json)
        val valueString = jsonElement.jsonObject["value"]?.jsonPrimitive?.content ?: ""
        
        assertTrue("Should not contain scientific notation") {
            !valueString.contains("E") && !valueString.contains("e")
        }
        
        assertTrue("Should contain decimal representation") {
            valueString.contains("0.0000005")
        }
    }
    
    @Test
    fun testDirectConversion() {
        // Test the conversion logic directly
        val scientificValue = 1.0E-8
        println("Testing conversion of: $scientificValue")
        
        // Create a test instance to access private methods
        val serializer = DoubleCadenceSerializer
        
        // We need to test the formatDoubleAsDecimal method indirectly
        // by checking what gets passed to FixedPointFormatter
        val stringValue = scientificValue.toString()
        println("toString() result: $stringValue")
        
        // Manual conversion test
        if (stringValue.contains("E-") || stringValue.contains("e-")) {
            val parts = stringValue.uppercase().split("E")
            println("Parts: $parts")
            if (parts.size == 2) {
                val coefficient = parts[0].toDoubleOrNull()
                val exponent = parts[1].toIntOrNull()
                println("Coefficient: $coefficient, Exponent: $exponent")
                
                if (coefficient != null && exponent != null) {
                    val totalDecimalPlaces = kotlin.math.abs(exponent)
                    val coefficientInt = if (coefficient == coefficient.toInt().toDouble()) {
                        coefficient.toInt()
                    } else {
                        (coefficient * 10).toInt()
                    }
                    
                    val result = when {
                        totalDecimalPlaces == 0 -> coefficientInt.toString()
                        totalDecimalPlaces == 1 -> "0.$coefficientInt"
                        else -> {
                            val leadingZeros = totalDecimalPlaces - 1
                            "0." + "0".repeat(leadingZeros) + coefficientInt.toString()
                        }
                    }
                    println("Manual conversion result: $result")
                }
            }
        }
    }
} 