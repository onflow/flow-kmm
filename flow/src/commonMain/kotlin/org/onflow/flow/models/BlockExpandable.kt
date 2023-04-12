package org.onflow.flow.models

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param payload 
 * @param executionResult 
 */
@Serializable
data class BlockExpandable (

    @SerialName(value = "payload") val payload: String? = null,

    @SerialName(value = "execution_result") val executionResult: String? = null

)

