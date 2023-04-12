package org.onflow.flow.models


import kotlinx.serialization.*
/**
 * 
 *
 * @param self 
 */
@Serializable
data class Links (
    @SerialName(value = "_self") val self: String? = null
)

