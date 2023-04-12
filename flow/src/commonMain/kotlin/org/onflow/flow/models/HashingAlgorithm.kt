package org.onflow.flow.models


import kotlinx.serialization.*

@Serializable
enum class HashingAlgorithm(val value: String) {

    @SerialName(value = "SHA2_256")
    SHA2_256("SHA2_256"),

    @SerialName(value = "SHA2_384")
    SHA2_384("SHA2_384"),

    @SerialName(value = "SHA3_256")
    SHA3_256("SHA3_256"),

    @SerialName(value = "SHA3_384")
    SHA3_384("SHA3_384"),

    @SerialName(value = "KMAC128_BLS_BLS12_381")
    KMAC128_BLS_BLS12_381("KMAC128_BLS_BLS12_381");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: Any?): String? = if (data is HashingAlgorithm) "$data" else null

        /**
         * Returns a valid [HashingAlgorithm] for [data], null otherwise.
         */
        fun decode(data: Any?): HashingAlgorithm? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

