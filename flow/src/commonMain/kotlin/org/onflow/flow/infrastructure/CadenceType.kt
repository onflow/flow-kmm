package org.onflow.flow.infrastructure

// simple types
const val TYPE_ANY = "Any"
const val TYPE_ANYSTRUCT = "AnyStruct"
const val TYPE_ANYRESOURCE = "AnyResource"
const val TYPE_TYPE = "Type"
const val TYPE_VOID = "Void"
const val TYPE_NEVER = "Never"
const val TYPE_BOOLEAN = "Bool"
const val TYPE_STRING = "String"
const val TYPE_CHARACTER = "Character"
const val TYPE_BYTES = "Bytes"
const val TYPE_NUMBER = "Number"
const val TYPE_SIGNEDNUMBER = "SignedNumber"
const val TYPE_INTEGER = "Integer"
const val TYPE_SIGNEDINTEGER = "SignedInteger"
const val TYPE_FIXEDPOINT = "FixedPoint"
const val TYPE_SIGNEDFIXEDPOINT = "SignedFixedPoint"
const val TYPE_INT = "Int"
const val TYPE_UINT = "UInt"
const val TYPE_INT8 = "Int8"
const val TYPE_UINT8 = "UInt8"
const val TYPE_INT16 = "Int16"
const val TYPE_UINT16 = "UInt16"
const val TYPE_INT32 = "Int32"
const val TYPE_UINT32 = "UInt32"
const val TYPE_INT64 = "Int64"
const val TYPE_UINT64 = "UInt64"
const val TYPE_INT128 = "Int128"
const val TYPE_UINT128 = "UInt128"
const val TYPE_INT256 = "Int256"
const val TYPE_UINT256 = "UInt256"
const val TYPE_WORD8 = "Word8"
const val TYPE_WORD16 = "Word16"
const val TYPE_WORD32 = "Word32"
const val TYPE_WORD64 = "Word64"
const val TYPE_FIX64 = "Fix64"
const val TYPE_UFIX64 = "UFix64"
const val TYPE_ARRAY = "Array"
const val TYPE_ADDRESS = "Address"
const val TYPE_PATH = "Path"
const val TYPE_CAPABILITYPATH = "CapabilityPath"
const val TYPE_STORAGEPATH = "StoragePath"
const val TYPE_PUBLICPATH = "PublicPath"
const val TYPE_PRIVATEPATH = "PrivatePath"
const val TYPE_AUTHACCOUNT = "AuthAccount"
const val TYPE_PUBLICACCOUNT = "PublicAccount"
const val TYPE_AUTHACCOUNT_KEYS = "AuthAccount.Keys"
const val TYPE_PUBLICACCOUNT_KEYS = "PublicAccount.Keys"
const val TYPE_AUTHACCOUNT_CONTRACTS = "AuthAccount.Contracts"
const val TYPE_PUBLICACCOUNT_CONTRACTS = "PublicAccount.Contracts"
const val TYPE_DEPLOYEDCONTRACT = "DeployedContract"
const val TYPE_ACCOUNTKEY = "AccountKey"
const val TYPE_BLOCK = "Block"

// complex type
const val TYPE_OPTIONAL = "Optional"
const val TYPE_DICTIONARY = "Dictionary"
const val TYPE_VARIABLE_SIZED_ARRAY = "VariableSizedArray"
const val TYPE_CONSTANT_SIZED_ARRAY = "ConstantSizedArray"
const val TYPE_CAPABILITY = "Capability"
const val TYPE_ENUM = "Enum"
const val TYPE_FUNCTION = "Function"
const val TYPE_REFERENCE = "Reference"
const val TYPE_RESTRICTION = "Restriction"

// composite types
const val TYPE_STRUCT = "Struct"
const val TYPE_RESOURCE = "Resource"
const val TYPE_EVENT = "Event"
const val TYPE_CONTRACT = "Contract"
const val TYPE_STRUCT_INTERFACE = "StructInterface"
const val TYPE_RESOURCE_INTERFACE = "ResourceInterface"
const val TYPE_CONTRACT_INTERFACE = "ContractInterface"

fun Cadence.Value.getTypeName(): String {
    return when (this) {
        is Cadence.Value.VoidValue -> TYPE_VOID
        is Cadence.Value.OptionalValue -> TYPE_OPTIONAL
        is Cadence.Value.BooleanValue -> TYPE_BOOLEAN
        is Cadence.Value.StringValue -> TYPE_STRING
        is Cadence.Value.AddressValue -> TYPE_ADDRESS
        is Cadence.Value.IntValue -> TYPE_INT
        is Cadence.Value.UIntValue -> TYPE_UINT
        is Cadence.Value.Int8Value -> TYPE_INT8
        is Cadence.Value.UInt8Value -> TYPE_UINT8
        is Cadence.Value.Int16Value -> TYPE_INT16
        is Cadence.Value.UInt16Value -> TYPE_UINT16
        is Cadence.Value.Int32Value -> TYPE_INT32
        is Cadence.Value.UInt32Value -> TYPE_UINT32
        is Cadence.Value.Int64Value -> TYPE_INT64
        is Cadence.Value.UInt64Value -> TYPE_UINT64
        is Cadence.Value.Int128Value -> TYPE_INT128
        is Cadence.Value.UInt128Value -> TYPE_UINT128
        is Cadence.Value.Int256Value -> TYPE_INT256
        is Cadence.Value.UInt256Value -> TYPE_UINT256
        is Cadence.Value.Fix64Value -> TYPE_FIX64
        is Cadence.Value.UFix64Value -> TYPE_UFIX64
        is Cadence.Value.Word8Value -> TYPE_WORD8
        is Cadence.Value.Word16Value -> TYPE_WORD16
        is Cadence.Value.Word32Value -> TYPE_WORD32
        is Cadence.Value.Word64Value -> TYPE_WORD64
        is Cadence.Value.ArrayValue -> TYPE_ARRAY
        is Cadence.Value.DictionaryValue -> TYPE_DICTIONARY
        is Cadence.Value.ContractValue -> TYPE_CONTRACT
        is Cadence.Value.EventValue -> TYPE_EVENT
        is Cadence.Value.ResourceValue -> TYPE_RESOURCE
        is Cadence.Value.EnumValue -> TYPE_ENUM
        is Cadence.Value.StructValue -> TYPE_STRUCT
        is Cadence.Value.PathValue -> TYPE_PATH
        is Cadence.Value.TypeValue -> TYPE_TYPE
        is Cadence.Value.CapabilityValue -> TYPE_CAPABILITY
        else -> "Unknown"
    }
}