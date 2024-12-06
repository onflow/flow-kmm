package org.onflow.flow.cadence

import org.onflow.flow.infrastructure.*
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import kotlinx.serialization.modules.SerializersModule
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.reflect.KClass

@Serializable
data class TestStruct(
    val capacity: Int,
    val used: Int,
    val available: Int
)

class CadenceTests {

//    @Test
//    fun testVoid() {
//        val rawValue: Unit? = null
//        val field = Cadence.void()
//        val jsonString = "{\"type\":\"Void\"}"
//        genericCadenceTest<Unit?>(field, null, jsonString, rawValue)
//    }
//
//    @Test
//    fun testOptional() {
//        var rawValue: String? = "bar"
//        var field = Cadence.optional(Cadence.string("bar"))
//        var jsonString = "{\"type\":\"Optional\",\"value\":{\"type\":\"String\",\"value\":\"bar\"}}"
//        genericCadenceTest<String?>(field, Cadence.string("bar"), jsonString, rawValue)
//
//        rawValue = null
//        field = Cadence.optional(null)
//        jsonString = "{\"type\":\"Optional\",\"value\":null}"
//        genericCadenceTest<String?>(field, null, jsonString, rawValue)
//    }
//
//    @Test
//    fun testString() {
//        val value = "foo"
//        val field = Cadence.string(value)
//        val jsonString = "{\"type\":\"String\",\"value\":\"$value\"}"
//        genericCadenceTest<String>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testAddress() {
//        val value = "0x84221fe0294044d7"
//        val field = Cadence.address(value)
//        val jsonString = "{\"type\":\"Address\",\"value\":\"$value\"}"
//        genericCadenceTest<String>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testInt() {
//        val value = 123
//        val field = Cadence.int(value)
//        val jsonString = "{\"type\":\"Int\",\"value\":\"$value\"}"
//        genericCadenceTest<Int>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testUInt() {
//        val value: UInt = 8u
//        val field = Cadence.uint(value)
//        val jsonString = "{\"type\":\"UInt\",\"value\":\"$value\"}"
//        genericCadenceTest<UInt>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testWord8() {
//        val value: UByte = 8u
//        val field = Cadence.word8(value)
//        val jsonString = "{\"type\":\"Word8\",\"value\":\"$value\"}"
//        genericCadenceTest<UByte>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testUInt128() {
//        val value: BigInteger = "8507059173023461585662027982108".toBigInteger()
//        val field = Cadence.uint128(value)
//        val jsonString = "{\"type\":\"UInt128\",\"value\":\"$value\"}"
//        genericCadenceTest<BigInteger>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testInt256() {
//        val value: BigInteger = "-85070591730234615856620279821087277056".toBigInteger()
//        val field = Cadence.int256(value)
//        val jsonString = "{\"type\":\"Int256\",\"value\":\"$value\"}"
//        genericCadenceTest<BigInteger>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testBoolean() {
//        val rawValue = true
//        val field = Cadence.bool(rawValue)
//        val jsonString = "{\"type\":\"Bool\",\"value\":true}"
//        genericCadenceTest<Boolean>(field, true, jsonString, rawValue)
//    }
//
//    @Test
//    fun testFix64() {
//        val value = 23.098842
//        val field = Cadence.fix64(value)
//        val jsonString = "{\"type\":\"Fix64\",\"value\":\"23.09884200\"}"
//        genericCadenceTest<Double>(field, value, jsonString, value)
//    }
//
//    @Test
//    fun testArray() {
//        val rawValue = listOf<String>("bar", "foo")
//        val cadenceInt = Cadence.string("bar")
//        val cadenceOptional = Cadence.optional(Cadence.string("foo"))
//        val cadenceList = listOf(cadenceInt, cadenceOptional)
//        val field = Cadence.array(cadenceList)
//        val jsonString = "{\"type\":\"Array\",\"value\":[{\"type\":\"String\",\"value\":\"bar\"},{\"type\":\"Optional\",\"value\":{\"type\":\"String\",\"value\":\"foo\"}}]}"
//        genericCadenceTest<List<String>>(field, cadenceList, jsonString, rawValue)
//    }
//
//    @Test
//    fun testStruct() {
//        val value = listOf(TestStruct(1,2,3))
//        val cadenceStruct = Cadence.struct(
//            Cadence.CompositeValue(
//                id = "s.ae201908260897d0362313d810b2e5dc5aa7d48af253e068b716a0ce7ac0212e.StorageInfo",
//                listOf(
//                    Cadence.CompositeAttribute("capacity", Cadence.int(1)),
//                    Cadence.CompositeAttribute("used", Cadence.int(2)),
//                    Cadence.CompositeAttribute("available", Cadence.int(3))
//                )
//            )
//        )
//        val cadenceList = listOf(cadenceStruct)
//        val field = Cadence.array(cadenceList)
//        val jsonString = "{\"type\":\"Array\",\"value\":[{\"type\":\"Struct\",\"value\":{\"id\":\"s.ae201908260897d0362313d810b2e5dc5aa7d48af253e068b716a0ce7ac0212e.StorageInfo\",\"fields\":[{\"name\":\"capacity\",\"value\":{\"type\":\"Int\",\"value\":\"1\"}},{\"name\":\"used\",\"value\":{\"type\":\"Int\",\"value\":\"2\"}},{\"name\":\"available\",\"value\":{\"type\":\"Int\",\"value\":\"3\"}}]}}]}"
//
//        genericCadenceTest<List<TestStruct>>(field, cadenceList, jsonString, value)
//    }
//
//    @Test
//    fun testDictionary() {
//        val rawValue = mapOf<Int, String?>(
//            42 to "foo"
//        )
//        val cadenceInt = Cadence.int(42)
//        val cadenceOptional = Cadence.optional(Cadence.string("foo"))
//        val dict = listOf(Cadence.DictionaryFieldEntry(cadenceInt to cadenceOptional))
//        val field = Cadence.dictionary(dict)
//        val jsonString = "{\"type\":\"Dictionary\",\"value\":[{\"key\":{\"type\":\"Int\",\"value\":\"42\"},\"value\":{\"type\":\"Optional\",\"value\":{\"type\":\"String\",\"value\":\"foo\"}}}]}"
//        genericCadenceTest(field, dict, jsonString, rawValue)
//    }
//
//    @Test
//    fun testComposite() {
//        @Serializable
//        data class TestContract(
//            val foo: Int
//        )
//        val rawValue = TestContract(42)
//        val id = "some.id"
//        val cadenceInt = Cadence.int(42)
//        val compositeValue = Cadence.CompositeAttribute("foo", cadenceInt)
//        val cadenceCompositeValue = Cadence.CompositeValue(id, listOf( compositeValue))
//        val field = Cadence.contractValue(cadenceCompositeValue)
//        val jsonString = "{\"type\":\"Contract\",\"value\":{\"id\":\"some.id\",\"fields\":[{\"name\":\"foo\",\"value\":{\"type\":\"Int\",\"value\":\"42\"}}]}}"
//        genericCadenceTest(field, cadenceCompositeValue, jsonString, rawValue)
//    }
//
//    @Test
//    fun testPath() {
//        val cadenceValue = Cadence.Path(Cadence.PathDomain.STORAGE, "someIdentifier")
//        val field = Cadence.path(Cadence.PathDomain.STORAGE, "someIdentifier")
//        val jsonString = "{\"type\":\"Path\",\"value\":{\"domain\":\"storage\",\"identifier\":\"someIdentifier\"}}"
//        genericCadenceTest(field, cadenceValue, jsonString, cadenceValue)
//    }
//
//    @Test
//    fun testCapability() {
//        val cadenceValue = Cadence.Capability("/public/someInteger", "0x1", Cadence.Type.INT)
//        val field = Cadence.capability(cadenceValue)
//        val jsonString = "{\"type\":\"Capability\",\"value\":{\"path\":\"/public/someInteger\",\"address\":\"0x1\",\"borrowType\":\"Int\"}}"
//        genericCadenceTest(field, cadenceValue, jsonString, cadenceValue)
//    }

    private inline fun <reified T> genericCadenceTest(field: Cadence.Value, value: Any?, jsonString: String, rawValue: T) {
        // Decode Test
        val result = Cadence.Value.decodeFromJson(jsonString)
        assertEquals(field, result)
        assertEquals(result.value, value)

        // Encode Test
        val encoded = field.encode()
        assertEquals(jsonString, encoded)

        // Decode to Kotlin value
        val decode = result.decode<T>()
        assertEquals(rawValue, decode)
    }
}