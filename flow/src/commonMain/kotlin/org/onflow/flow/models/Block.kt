package org.onflow.flow.models

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 
 *
 * @param header 
 * @param expandable 
 * @param payload 
 * @param executionResult 
 * @param links 
 */
@Serializable
data class Block (

    @SerialName(value = "header") @Required val header: BlockHeader,

    @SerialName(value = "_expandable") @Required val expandable: BlockExpandable,

    @SerialName(value = "payload") val payload: BlockPayload? = null,

    @SerialName(value = "execution_result") val executionResult: ExecutionResult? = null,

    @SerialName(value = "_links") val links: Links? = null

)

