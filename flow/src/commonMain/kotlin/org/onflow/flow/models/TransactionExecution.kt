package org.onflow.flow.models


import kotlinx.serialization.*

/**
 * This value indicates whether the transaction execution succeded or not, this value should be checked when determining transaction success.
 *
 * Values: pending,success,failure
 */
@Serializable
enum class TransactionExecution(val value: String) {

    @SerialName(value = "Pending")
    pending("Pending"),

    @SerialName(value = "Success")
    success("Success"),

    @SerialName(value = "Failure")
    failure("Failure");

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
        fun encode(data: Any?): String? = if (data is TransactionExecution) "$data" else null

        /**
         * Returns a valid [TransactionExecution] for [data], null otherwise.
         */
        fun decode(data: Any?): TransactionExecution? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

