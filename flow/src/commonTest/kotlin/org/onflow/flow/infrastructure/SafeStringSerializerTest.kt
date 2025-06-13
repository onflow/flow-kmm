package org.onflow.flow.infrastructure

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.test.Test
import kotlin.test.assertEquals

@Serializable
data class TestData(
    @Serializable(with = SafeStringSerializer::class)
    val value: String
)

class SafeStringSerializerTest {
    
    private val json = Json { 
        ignoreUnknownKeys = true
        isLenient = true
    }
    
    @Test
    fun `test normal string parsing`() {
        val jsonString = """{"value":"normal_string"}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("normal_string", result.value)
    }
    
    @Test
    fun `test small number as string`() {
        val jsonString = """{"value":"123"}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("123", result.value)
    }
    
    @Test
    fun `test large number as unquoted number`() {
        val jsonString = """{"value":1544440348859079121}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("1544440348859079121", result.value)
    }
    
    @Test
    fun `test specific error number from logs`() {
        val jsonString = """{"value":1604440348859079121}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("1604440348859079121", result.value)
    }
    
    @Test
    fun `test large number as quoted string`() {
        val jsonString = """{"value":"1544440348859079121"}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("1544440348859079121", result.value)
    }
    
    @Test
    fun `test very large number that exceeds Long range`() {
        val jsonString = """{"value":"999999999999999999999999999999"}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("999999999999999999999999999999", result.value)
    }
    
    @Test
    fun `test floating point number`() {
        val jsonString = """{"value":123.456}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("123.456", result.value)
    }
    
    @Test
    fun `test zero value`() {
        val jsonString = """{"value":0}"""
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("0", result.value)
    }
    
    @Test
    fun `test serialization`() {
        val testData = TestData("1544440348859079121")
        val jsonString = json.encodeToString(testData)
        val result = json.decodeFromString<TestData>(jsonString)
        assertEquals("1544440348859079121", result.value)
    }
} 