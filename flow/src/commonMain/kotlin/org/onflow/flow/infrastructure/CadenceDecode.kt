package org.onflow.flow.infrastructure

import com.ionspin.kotlin.bignum.integer.BigInteger
//import com.ionspin.kotlin.bignum.serialization.kotlinx.biginteger.BigIntegerHumanReadableSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.*
import kotlin.time.Duration

fun List<Cadence.Value>.decodeToAny(): List<Any?> {
    return map { it.decodeToAny() }
}

fun List<Cadence.Value>.encodeBase64(): List<String> {
    return map { it.encodeBase64() }
}

inline fun <reified T> List<Cadence.Value>.decode(): List<T> {
    return map { it.decode() }
}

fun String.addHexPrefix(): String {
    return if (startsWith("0x")) this else "0x$this"
}

fun String.removeHexPrefix(): String {
    return if (startsWith("0x")) this.removePrefix("0x") else this
}

fun Any?.toJsonElement(): JsonElement = when (this) {
    null -> JsonNull
    is JsonElement -> this
    is Number -> JsonPrimitive(this)
    is Boolean -> JsonPrimitive(this)
    is String -> JsonPrimitive(this)
    is Array<*> -> JsonArray(map { it.toJsonElement() })
    is List<*> -> JsonArray(map { it.toJsonElement() })
    is Map<*, *> -> JsonObject(map { it.key.toString() to it.value.toJsonElement() }.toMap())
    is Char -> Json.encodeToJsonElement(Char.serializer(), this)
    is Byte -> Json.encodeToJsonElement(Byte.serializer(), this)
    is Short -> Json.encodeToJsonElement(Short.serializer(), this)
    is Long -> Json.encodeToJsonElement(Long.serializer(), this)
    is Float -> Json.encodeToJsonElement(Float.serializer(), this)
    is Duration -> Json.encodeToJsonElement(Duration.serializer(), this)
    is Unit -> Json.encodeToJsonElement(Unit.serializer(), this)
    is UInt -> Json.encodeToJsonElement(UInt.serializer(), this)
    is UByte -> Json.encodeToJsonElement(UByte.serializer(), this)
    is ULong -> Json.encodeToJsonElement(ULong.serializer(), this)
    is UShort -> Json.encodeToJsonElement(UShort.serializer(), this)
//    is BigInteger -> Json.encodeToJsonElement(BigIntegerHumanReadableSerializer, this)

    is Cadence.Path -> Json.encodeToJsonElement(Cadence.Path.serializer(), this)
    is Cadence.Capability -> Json.encodeToJsonElement(Cadence.Capability.serializer(), this)
    is Cadence.TypeEntry -> Json.encodeToJsonElement(Cadence.TypeEntry.serializer(), this)

    //TODO: Improve me
    else -> JsonNull
//    else -> Json.encodeToJsonElement(serializer(this::class.createType()), this)
}

fun Cadence.CompositeValue.toMap(): Map<String, Any?> {
    return this.fields.associate {
        it.name to it.value.decodeToAny()
    }
}

//fun <T : Any> toMap(obj: T): Map<String, Any?> {
//    return (obj::class as KClass<T>).memberProperties.associate { prop ->
//        prop.name to prop.get(obj)?.let { value ->
//            if (value::class.isData) {
//                toMap(value)
//            } else {
//                value
//            }
//        }
//    }
//}