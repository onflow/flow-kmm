package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * This value indicates the state of the transaction execution. Only sealed and expired are final and immutable states.
 *
 * Values: pending,finalized,executed,`sealed`,expired
 */
@Serializable
enum class TransactionStatus(val value: String) {

    @SerialName(value = "")
    EMPTY(""),

    @SerialName(value = "Unknown")
    UNKNOWN("Unknown"),

    @SerialName(value = "Pending")
    PENDING("Pending"),

    @SerialName(value = "Finalized")
    FINALIZED("Finalized"),

    @SerialName(value = "Executed")
    EXECUTED("Executed"),

    @SerialName(value = "Sealed")
    SEALED("Sealed"),

    @SerialName(value = "Expired")
    EXPIRED("Expired");

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
        fun encode(data: Any?): String? = if (data is TransactionStatus) "$data" else null

        /**
         * Returns a valid [TransactionStatus] for [data], null otherwise.
         */
        fun decode(data: Any?): TransactionStatus? = data?.let {
            println("Hello!")
            val normalizedData = "$it".lowercase()
            if (normalizedData.isBlank()) {
                UNKNOWN
            } else {
                values().firstOrNull { value ->
                    it == value || normalizedData == "$value".lowercase()
                }
            }
        }
    }
}



