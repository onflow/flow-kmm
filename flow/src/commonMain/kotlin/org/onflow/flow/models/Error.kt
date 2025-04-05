package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param code 
 * @param message 
 */
@Serializable
class Error(
    @SerialName("code") val code: Int? = null,
    @SerialName("message") override val message: String? = null
) : Exception(message)


