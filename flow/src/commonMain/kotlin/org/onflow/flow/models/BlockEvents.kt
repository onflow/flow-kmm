package org.onflow.flow.models

import org.onflow.flow.models.Event
import org.onflow.flow.models.Links
import kotlinx.serialization.*

/**
 * 
 *
 * @param blockId A 32-byte unique identifier for an entity.
 * @param blockHeight 
 * @param blockTimestamp 
 * @param events 
 * @param links 
 */
@Serializable
data class BlockEvents (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "block_id") val blockId: String? = null,

    @SerialName(value = "block_height") val blockHeight: String? = null,

    @SerialName(value = "block_timestamp") val blockTimestamp: String? = null,

    @SerialName(value = "events") val events: List<Event>? = null,

    @SerialName(value = "_links") val links: Links? = null

)

