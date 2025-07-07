package org.onflow.flow.infrastructure

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FixedPointFormatterTest {

    @Test
    fun testFormatZeroValue() {
        // Test that zero value gets formatted with decimal point
        val result = FixedPointFormatter.format("0", 8UL)
        
        assertNotNull(result, "Result should not be null")
        assertEquals("0.0", result, "Zero should be formatted as '0.0', not '0'")
    }

    @Test
    fun testFormatWholeNumbers() {
        // Test that whole numbers get formatted with decimal point
        val result1 = FixedPointFormatter.format("1", 8UL)
        assertEquals("1.0", result1, "Whole numbers should include decimal point")
        
        val result2 = FixedPointFormatter.format("123", 8UL)
        assertEquals("123.0", result2, "Large whole numbers should include decimal point")
    }

    @Test
    fun testFormatDecimalValues() {
        // Test that existing decimal values are preserved
        val result1 = FixedPointFormatter.format("1.5", 8UL)
        assertEquals("1.5", result1, "Existing decimal values should be preserved")
        
        val result2 = FixedPointFormatter.format("0.00000001", 8UL)
        assertEquals("0.00000001", result2, "Small decimal values should be preserved")
    }

    @Test
    fun testFormatWithPrecision() {
        // Test that precision is respected
        val result1 = FixedPointFormatter.format("1.23456789", 4UL)
        assertEquals("1.2345", result1, "Precision should limit decimal places")
        
        val result2 = FixedPointFormatter.format("0.123456789", 2UL)
        assertEquals("0.12", result2, "Precision should limit decimal places for values < 1")
    }

    @Test
    fun testFormatScientificNotationInput() {
        // Test that scientific notation input is handled correctly
        // Note: This tests the input format, not the actual scientific notation conversion
        val result = FixedPointFormatter.format("1E-8", 8UL)
        assertEquals("1E-8.0", result, "Scientific notation input should get decimal point added")
    }

    @Test
    fun testFormatUFix64SpecificCases() {
        // Test cases specifically for UFix64 usage
        val zeroResult = FixedPointFormatter.format("0", 8UL)
        assertEquals("0.0", zeroResult, "UFix64 zero must have decimal point")
        
        val oneResult = FixedPointFormatter.format("1", 8UL)
        assertEquals("1.0", oneResult, "UFix64 whole numbers must have decimal point")
        
        val smallResult = FixedPointFormatter.format("0.00000001", 8UL)
        assertEquals("0.00000001", smallResult, "UFix64 small values should be preserved")
    }

    @Test
    fun testFormatErrorHandling() {
        // Test error cases
        val result1 = FixedPointFormatter.format("", 8UL)
        assertEquals(null, result1, "Empty string should return null")
        
        val result2 = FixedPointFormatter.format("   ", 8UL)
        assertEquals(null, result2, "Blank string should return null")
        
        val result3 = FixedPointFormatter.format("invalid", 8UL)
        assertEquals("invalid.0", result3, "Non-numeric input gets decimal point added (handled by caller)")
        
        val result4 = FixedPointFormatter.format("abc.def", 8UL)
        assertEquals("abc.def", result4, "Invalid decimal input is passed through (handled by caller)")
    }

    @Test
    fun testFormatCriticalCases() {
        // Test the exact cases that were causing the UFix64 error
        val zeroResult = FixedPointFormatter.format("0", 8UL)
        assertEquals("0.0", zeroResult, "Zero must be formatted with decimal point")
        
        val zeroDoubleResult = FixedPointFormatter.format("0.0", 8UL)
        assertEquals("0.0", zeroDoubleResult, "Zero with decimal should be preserved")
        
        val smallValueResult = FixedPointFormatter.format("0.00000001", 8UL)
        assertEquals("0.00000001", smallValueResult, "Small UFix64 values should be preserved")
        
        println("✅ All critical UFix64 formatting cases pass")
    }
} 