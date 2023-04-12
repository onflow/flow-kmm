package org.onflow.flow.models


import kotlinx.serialization.*

/**
 * 
 *
 * Values: `final`,`sealed`
 */
@Serializable
enum class BlockHeightOneOf(val value: String) {

    @SerialName(value = "final")
    `final`("final"),

    @SerialName(value = "sealed")
    `sealed`("sealed");

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
        fun encode(data: Any?): String? = if (data is BlockHeightOneOf) "$data" else null

        /**
         * Returns a valid [BlockHeightOneOf] for [data], null otherwise.
         */
        fun decode(data: Any?): BlockHeightOneOf? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

