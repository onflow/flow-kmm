package org.onflow.flow.models


import kotlinx.serialization.*


@Serializable
enum class SigningAlgorithm(val value: String, val cadenceIndex: Int, val curve: String) {

    @SerialName(value = "ECDSA_P256")
    ECDSA_P256("ECDSA_P256", 1, "P-256"),

    @SerialName(value = "ECDSA_secp256k1")
    ECDSA_secp256k1("ECDSA_secp256k1", 2, "secp256k1");

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
        fun encode(data: Any?): String? = if (data is SigningAlgorithm) "$data" else null

        /**
         * Returns a valid [SigningAlgorithm] for [data], null otherwise.
         */
        fun decode(data: Any?): SigningAlgorithm? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

