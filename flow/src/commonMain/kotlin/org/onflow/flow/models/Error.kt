package org.onflow.flow.models

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param code 
 * @param message 
 */
@Serializable
data class Error (

    @SerialName(value = "code") val code: Int? = null,

    @SerialName(value = "message") val message: String? = null

)

