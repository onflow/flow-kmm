package org.onflow.flow.models


import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray
import org.onflow.flow.infrastructure.Base64ByteArraySerializer

/**
 * 
 *
 * @param `value` 
 */
@Serializable
data class ScriptsPostResponse (
    @Serializable(with = Base64ByteArraySerializer::class)
    val value: Base64ByteArray? = null
)

