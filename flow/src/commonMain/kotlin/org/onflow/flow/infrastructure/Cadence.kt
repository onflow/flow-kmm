package org.onflow.flow.infrastructure

import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.serialization.kotlinx.humanReadableSerializerModule
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.onflow.flow.infrastructure.Cadence.Type.Companion.jsonSerializer
import org.onflow.flow.infrastructure.Cadence.Value.AddressValue
import org.onflow.flow.infrastructure.Cadence.Value.ArrayValue
import org.onflow.flow.infrastructure.Cadence.Value.BooleanValue
import org.onflow.flow.infrastructure.Cadence.Value.CapabilityValue
import org.onflow.flow.infrastructure.Cadence.Value.ContractValue
import org.onflow.flow.infrastructure.Cadence.Value.DictionaryValue
import org.onflow.flow.infrastructure.Cadence.Value.EnumValue
import org.onflow.flow.infrastructure.Cadence.Value.EventValue
import org.onflow.flow.infrastructure.Cadence.Value.Fix64Value
import org.onflow.flow.infrastructure.Cadence.Value.Int128Value
import org.onflow.flow.infrastructure.Cadence.Value.Int16Value
import org.onflow.flow.infrastructure.Cadence.Value.Int256Value
import org.onflow.flow.infrastructure.Cadence.Value.Int32Value
import org.onflow.flow.infrastructure.Cadence.Value.Int64Value
import org.onflow.flow.infrastructure.Cadence.Value.Int8Value
import org.onflow.flow.infrastructure.Cadence.Value.IntValue
import org.onflow.flow.infrastructure.Cadence.Value.OptionalValue
import org.onflow.flow.infrastructure.Cadence.Value.PathValue
import org.onflow.flow.infrastructure.Cadence.Value.ResourceValue
import org.onflow.flow.infrastructure.Cadence.Value.StringValue
import org.onflow.flow.infrastructure.Cadence.Value.StructValue
import org.onflow.flow.infrastructure.Cadence.Value.TypeValue
import org.onflow.flow.infrastructure.Cadence.Value.UFix64Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt128Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt16Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt256Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt32Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt64Value
import org.onflow.flow.infrastructure.Cadence.Value.UInt8Value
import org.onflow.flow.infrastructure.Cadence.Value.UIntValue
import org.onflow.flow.infrastructure.Cadence.Value.VoidValue
import org.onflow.flow.infrastructure.Cadence.Value.Word16Value
import org.onflow.flow.infrastructure.Cadence.Value.Word32Value
import org.onflow.flow.infrastructure.Cadence.Value.Word64Value
import org.onflow.flow.infrastructure.Cadence.Value.Word8Value

class Cadence {

    @Serializable(with = CadenceTypeSerializer::class)
    enum class Type(val value: String) {
        VOID(TYPE_VOID),
        OPTIONAL(TYPE_OPTIONAL),
        BOOLEAN(TYPE_BOOLEAN),
        STRING(TYPE_STRING),
        INT(TYPE_INT),
        UINT(TYPE_UINT),
        INT8(TYPE_INT8),
        UINT8(TYPE_UINT8),
        INT16(TYPE_INT16),
        UINT16(TYPE_UINT16),
        INT32(TYPE_INT32),
        UINT32(TYPE_UINT32),
        INT64(TYPE_INT64),
        UINT64(TYPE_UINT64),
        INT128(TYPE_INT128),
        UINT128(TYPE_UINT128),
        INT256(TYPE_INT256),
        UINT256(TYPE_UINT256),
        WORD8(TYPE_WORD8),
        WORD16(TYPE_WORD16),
        WORD32(TYPE_WORD32),
        WORD64(TYPE_WORD64),
        FIX64(TYPE_FIX64),
        UFIX64(TYPE_UFIX64),
        ARRAY(TYPE_ARRAY),
        DICTIONARY(TYPE_DICTIONARY),
        ADDRESS(TYPE_ADDRESS),
        PATH(TYPE_PATH),
        CAPABILITY(TYPE_CAPABILITY),
        STRUCT(TYPE_STRUCT),
        RESOURCE(TYPE_RESOURCE),
        EVENT(TYPE_EVENT),
        CONTRACT(TYPE_CONTRACT),
        ENUM(TYPE_ENUM),

        //TODO: Handle More Types
        TYPE(TYPE_TYPE);

        companion object {
            fun findByKey(value: String, default: Type = Type.VOID): Type {
                return Type.values().find { it.value == value } ?: default
            }

            private val valueSerializersModule = SerializersModule {
                polymorphic(Value::class) {
                    subclass(VoidValue::class)
                    subclass(BooleanValue::class)
                    subclass(StringValue::class)
                    subclass(OptionalValue::class)
                    subclass(AddressValue::class)
                    subclass(IntValue::class)
                    subclass(UIntValue::class)
                    subclass(Int8Value::class)
                    subclass(UInt8Value::class)
                    subclass(Int16Value::class)
                    subclass(UInt16Value::class)
                    subclass(Int32Value::class)
                    subclass(UInt32Value::class)
                    subclass(Int64Value::class)
                    subclass(UInt64Value::class)
                    subclass(Int128Value::class)
                    subclass(UInt128Value::class)
                    subclass(Int256Value::class)
                    subclass(UInt256Value::class)
                    subclass(Word8Value::class)
                    subclass(Word16Value::class)
                    subclass(Word32Value::class)
                    subclass(Word64Value::class)
                    subclass(Fix64Value::class)
                    subclass(UFix64Value::class)
                    subclass(ArrayValue::class)
                    subclass(DictionaryValue::class)
                    subclass(StructValue::class)
                    subclass(ContractValue::class)
                    subclass(EventValue::class)
                    subclass(EnumValue::class)
                    subclass(ResourceValue::class)
                    subclass(TypeValue::class)
                    subclass(PathValue::class)
                    subclass(CapabilityValue::class)
                }
            }

            val jsonSerializer = Json {
                serializersModule = valueSerializersModule + humanReadableSerializerModule
                ignoreUnknownKeys = true
                isLenient = true
                classDiscriminator = "type"
            }
        }
    }

    @Serializable
    sealed class Value {
        abstract val value: Any?

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Value) return false
            return this.encodeBase64() == other.encodeBase64()
        }

        override fun hashCode(): Int {
            return encodeBase64().hashCode()
        }

        companion object {

            fun decodeFromJsonElement(jsonElement: JsonElement): Value {
                return jsonSerializer.decodeFromJsonElement(jsonElement)
            }

            fun decodeFromJson(jsonString: String): Value {
                return jsonSerializer.decodeFromString(jsonString)
            }

            fun encodeToJsonString(Value: Value): String {
                return Value.encode()
            }

            fun decodeFromBase64(base64String: String): Value {
                return decodeFromJson(base64String.decodeBase64Bytes().decodeToString())
            }
        }

        fun encode(): String {
            return jsonSerializer.encodeToString(this)
        }

        fun encodeBase64(): String {
            return  encode().toByteArray().encodeBase64()
        }

        fun decodeToAny(): Any? {
            return when (this) {
                is VoidValue -> { null }
                is OptionalValue -> { value?.decodeToAny() }
                is ArrayValue -> { value.map { it.decodeToAny() } }

                // CompositeValue
                is StructValue -> { value.toMap() }
                is ContractValue -> { value.toMap() }
                is EventValue -> { value.toMap() }
                is ResourceValue -> { value.toMap() }
                is EnumValue -> { value.toMap() }

                is DictionaryValue -> {
                    value.associate {
                        it.key.decodeToAny() to it.value.decodeToAny()
                    }
                }

//                is CapabilityValue -> { value.let { toMap(it) } }
//                is PathValue -> { value.let { toMap(it) } }
//                // TODO: Handle type decode
//                is TypeValue -> { value.let { toMap(it) } }

                else -> { value }
            }
        }

        @Throws(Exception::class)
        inline fun <reified T> decode(): T {
            val decode = decodeToAny()
            val jsonElement = decode.toJsonElement()
            return jsonSerializer.decodeFromJsonElement(jsonElement)
        }

        @Serializable
        @SerialName(TYPE_BOOLEAN)
        data class BooleanValue(override val value: Boolean): Value()

        @Serializable
        @SerialName(TYPE_STRING)
        data class StringValue(override val value: String) : Value()

        @Serializable
        @SerialName(TYPE_VOID)
        data class VoidValue(override val value: Unit? = null) : Value()

        @Serializable
        @SerialName(TYPE_OPTIONAL)
        data class OptionalValue(override val value: Value?): Value()

        @Serializable
        @SerialName(TYPE_ADDRESS)
        data class AddressValue(override val value: String): Value()

        @Serializable
        @SerialName(TYPE_INT)
        data class IntValue(
            @Serializable(IntCadenceSerializer::class)
            override val value: Int): Value()

        @Serializable
        @SerialName(TYPE_UINT)
        data class UIntValue(
            @Serializable(UIntCadenceSerializer::class)
            override val value: UInt): Value()

        @Serializable
        @SerialName(TYPE_INT8)
        data class Int8Value(
            @Serializable(ByteCadenceSerializer::class)
            override val value: Byte): Value()

        @Serializable
        @SerialName(TYPE_UINT8)
        data class UInt8Value(
            @Serializable(UByteCadenceSerializer::class)
            override val value: UByte): Value()

        @Serializable
        @SerialName(TYPE_INT16)
        data class Int16Value(
            @Serializable(ShortCadenceSerializer::class)
            override val value: Short): Value()

        @Serializable
        @SerialName(TYPE_UINT16)
        data class UInt16Value(
            @Serializable(UShortCadenceSerializer::class)
            override val value: UShort): Value()

        @Serializable
        @SerialName(TYPE_INT32)
        data class Int32Value(
            @Serializable(IntCadenceSerializer::class)
            override val value: Int): Value()

        @Serializable
        @SerialName(TYPE_UINT32)
        data class UInt32Value(
            @Serializable(UIntCadenceSerializer::class)
            override val value: UInt): Value()

        @Serializable
        @SerialName(TYPE_INT64)
        data class Int64Value(
            @Serializable(LongCadenceSerializer::class)
            override val value: Long): Value()

        @Serializable
        @SerialName(TYPE_UINT64)
        data class UInt64Value(
            @Serializable(ULongCadenceSerializer::class)
            override val value: ULong): Value()

        @Serializable
        @SerialName(TYPE_INT128)
        data class Int128Value(
            @Serializable(BigIntegerCadenceSerializer::class)
            override val value: BigInteger): Value()

        @Serializable
        @SerialName(TYPE_UINT128)
        data class UInt128Value(
            @Serializable(BigIntegerCadenceSerializer::class)
            override val value: BigInteger): Value()

        @Serializable
        @SerialName(TYPE_INT256)
        data class Int256Value(
            @Serializable(BigIntegerCadenceSerializer::class)
            override val value: BigInteger): Value()

        @Serializable
        @SerialName(TYPE_UINT256)
        data class UInt256Value(
            @Serializable(BigIntegerCadenceSerializer::class)
            override val value: BigInteger): Value()

        @Serializable
        @SerialName(TYPE_FIX64)
        data class Fix64Value(
            @Serializable(DoubleCadenceSerializer::class)
            override val value: Double
        ): Value()

        @Serializable
        @SerialName(TYPE_UFIX64)
        data class UFix64Value(
            @Serializable(DoubleCadenceSerializer::class)
            override val value: Double): Value()

        @Serializable
        @SerialName(TYPE_WORD8)
        data class Word8Value(
            @Serializable(UByteCadenceSerializer::class)
            override val value: UByte): Value()

        @Serializable
        @SerialName(TYPE_WORD16)
        data class Word16Value(
            @Serializable(UShortCadenceSerializer::class)
            override val value: UShort): Value()

        @Serializable
        @SerialName(TYPE_WORD32)
        data class Word32Value(
            @Serializable(UIntCadenceSerializer::class)
            override val value: UInt): Value()

        @Serializable
        @SerialName(TYPE_WORD64)
        data class Word64Value(
            @Serializable(ULongCadenceSerializer::class)
            override val value: ULong): Value()

        @Serializable
        @SerialName(TYPE_ARRAY)
        data class ArrayValue(override val value: List<Value>): Value()


        @Serializable
        @SerialName(TYPE_DICTIONARY)
        data class DictionaryValue(override val value: List<DictionaryFieldEntry>): Value()

        @Serializable
        @SerialName(TYPE_CONTRACT)
        data class ContractValue(override val value: CompositeValue): Value()

        @Serializable
        @SerialName(TYPE_EVENT)
        data class EventValue(override val value: CompositeValue): Value()

        @Serializable
        @SerialName(TYPE_RESOURCE)
        data class ResourceValue(override val value: CompositeValue): Value()

        @Serializable
        @SerialName(TYPE_ENUM)
        data class EnumValue(override val value: CompositeValue): Value()

        @Serializable
        @SerialName(TYPE_STRUCT)
        open class StructValue(override val value: CompositeValue) : Value()

        @Serializable
        @SerialName(TYPE_PATH)
        open class PathValue(override val value: Path) : Value()

        @Serializable
        @SerialName(TYPE_TYPE)
        open class TypeValue(override val value: TypeEntry) : Value()

        @Serializable
        @SerialName(TYPE_CAPABILITY)
        open class CapabilityValue(override val value: Capability) : Value()
    }

    companion object {
        fun void() = Value.VoidValue()

        fun optional(value: Value?) = Value.OptionalValue(value)

        fun bool(value: Boolean) = Value.BooleanValue(value)

        fun string(value: String) = Value.StringValue(value)

        fun address(value: String) = Value.AddressValue(value.addHexPrefix())

        fun address(value: ByteArray) = Value.AddressValue(hex(value))

        fun `int`(value: Int) = Value.IntValue(value)

        fun uint(value: UInt) = Value.UIntValue(value)

        fun int8(value: Byte) = Value.Int8Value(value)

        fun uint8(value: UByte) = Value.UInt8Value(value)

        fun int16(value: Short) = Value.Int16Value(value)

        fun uint16(value: UShort) = Value.UInt16Value(value)

        fun struct(value: CompositeValue) = Value.StructValue(value)

        fun int32(value: Int) = Value.Int32Value(value)

        fun uint32(value: UInt) = Value.UInt32Value(value)

        fun int64(value: Long) = Value.Int64Value(value)

        fun uint64(value: ULong) = Value.UInt64Value(value)

        fun int128(value: BigInteger) = Value.Int128Value(value)

        fun uint128(value: BigInteger) = Value.UInt128Value(value)

        fun int256(value: BigInteger) = Value.Int256Value(value)

        fun uint256(value: BigInteger) = Value.UInt256Value(value)

        fun word8(value: UByte) = Value.Word8Value(value)

        fun word16(value: UShort) = Value.Word16Value(value)

        fun word32(value: UInt) = Value.Word32Value(value)

        fun word64(value: ULong) = Value.Word64Value(value)

        fun fix64(value: Double) = Value.Fix64Value(value)
        fun fix64(value: Number) = fix64(value.toDouble())
        fun fix64(value: String) = fix64(value.toDouble())

        fun ufix64(value: Double) = Value.UFix64Value(value)
        fun ufix64(value: Number) = ufix64(value.toDouble())
        fun ufix64(value: String) = ufix64(value.toDouble())

        fun array(value: List<Cadence.Value>) = Value.ArrayValue(value)

        fun dictionary(value: List<DictionaryFieldEntry>) = Value.DictionaryValue(value)
        fun dictionary(value: Map<Value, Value>) = Value.DictionaryValue(value.map { DictionaryFieldEntry(it.key, it.value) })

        fun contractValue(value: CompositeValue) = Value.ContractValue(value)

        fun resourceValue(value: CompositeValue) = Value.ContractValue(value)

        fun eventValue(value: CompositeValue) = Value.ContractValue(value)

        fun enumValue(value: CompositeValue) = Value.ContractValue(value)

        fun path(value: Path) = Value.PathValue(value)
        fun path(domain: PathDomain, identifier: String) = Value.PathValue(Path(domain, identifier))

        fun type(value: TypeEntry) = Value.TypeValue(value)
        fun type(value: Cadence.Kind) = type(TypeEntry(value))

        fun capability(value: Capability) = Value.CapabilityValue(value)
        fun capability(path: String, address: String, borrowType: Type) = capability(Capability(path, address, borrowType))
    }

    @Serializable
    enum class PathDomain(val value: String) {

        @SerialName("storage")
        STORAGE("storage"),

        @SerialName("private")
        PRIVATE("private"),

        @SerialName("public")
        PUBLIC("public")
    }

    @Serializable
    data class Path(val domain: PathDomain, val identifier: String)

    @Serializable
    data class TypeEntry(val staticType: Kind)

    //TODO: Handle more types
    @Serializable
    data class Kind (val kind: Type, val typeID : String?, val type: String?)

    @Serializable
    data class Capability(val path: String, val address: String, val borrowType: Type)

    @Serializable
    class DictionaryFieldEntry(val key: Cadence.Value, val value: Cadence.Value) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is DictionaryFieldEntry) return false
            return key == other.key && value == other.value
        }

        override fun hashCode(): Int {
            var result = key.hashCode()
            result = 31 * result + value.hashCode()
            return result
        }

        constructor(pair: Pair<Cadence.Value, Cadence.Value>) : this(pair.first, pair.second)
    }

    @Serializable
    open class CompositeAttribute(val name: String, val value: Cadence.Value) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is CompositeAttribute) return false
            return name == other.name && value == other.value
        }

        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + value.hashCode()
            return result
        }
    }

    @Serializable
    open class CompositeValue(val id: String, val fields: List<CompositeAttribute>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is CompositeValue) return false
            return id == other.id && fields == other.fields
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + fields.hashCode()
            return result
        }
    }
}

inline fun <reified T> Cadence.CompositeValue.getField(key: String): T? {
    return fields.getField<T>(key)
}

inline fun <reified T> List<Cadence.CompositeAttribute>.getField(key: String): T? {
    return find { it.name == key }?.value?.decode()
}