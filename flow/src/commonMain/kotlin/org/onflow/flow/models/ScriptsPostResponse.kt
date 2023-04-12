package org.onflow.flow.models


import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 * 
 *
 * @param `value` 
 */
@Serializable
data class ScriptsPostResponse (
    val value: Base64ByteArray? = null
)

