package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * Represents the status of a block in the Flow blockchain.
 *
 * @property value The string value of the block status
 */
@Serializable
enum class BlockStatus(val value: String) {
    @SerialName("final")
    FINAL("final"),

    @SerialName("sealed")
    SEALED("sealed");

    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: Any?): String? = if (data is BlockStatus) "$data" else null

        /**
         * Returns a valid [BlockStatus] for [data], null otherwise.
         */
        fun decode(data: Any?): BlockStatus? = data?.let {
            val normalizedData = "$it".lowercase()
            values().firstOrNull { value ->
                it == value || normalizedData == "$value".lowercase()
            }
        }
    }
} 