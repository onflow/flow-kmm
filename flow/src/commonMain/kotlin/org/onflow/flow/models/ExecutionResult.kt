package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param id A 32-byte unique identifier for an entity.
 * @param blockId A 32-byte unique identifier for an entity.
 * @param events 
 * @param previousResultId A 32-byte unique identifier for an entity.
 * @param chunks 
 * @param links 
 */
@Serializable
data class ExecutionResult (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "id") @Required val id: String,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "block_id") @Required val blockId: String,

    @SerialName(value = "events") @Required val events: List<Event>,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "previous_result_id") val previousResultId: String? = null,

    @SerialName(value = "chunks") val chunks: List<Chunk>? = null,

    @SerialName(value = "_links") val links: Links? = null

)

