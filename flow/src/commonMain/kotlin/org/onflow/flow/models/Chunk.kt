package org.onflow.flow.models

import org.onflow.flow.infrastructure.Base64ByteArray
import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArraySerializer

/**
 * 
 *
 * @param blockId A 32-byte unique identifier for an entity.
 * @param collectionIndex 
 * @param startState 
 * @param endState 
 * @param eventCollection 
 * @param index 
 * @param numberOfTransactions 
 * @param totalComputationUsed 
 */
@Serializable
data class Chunk (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "block_id") @Required val blockId: kotlin.String,

    @SerialName(value = "collection_index") @Required val collectionIndex: kotlin.String,

    @Required
    @SerialName(value = "start_state")
    @Serializable(with = Base64ByteArraySerializer::class)
    val startState: Base64ByteArray,

    @Required
    @SerialName(value = "end_state")
    @Serializable(with = Base64ByteArraySerializer::class)
    val endState: Base64ByteArray,

    @Required
    @SerialName(value = "event_collection")
    @Serializable(with = Base64ByteArraySerializer::class)
    val eventCollection: Base64ByteArray,

    @SerialName(value = "index") @Required val index: kotlin.String,

    @SerialName(value = "number_of_transactions") @Required val numberOfTransactions: kotlin.String,

    @SerialName(value = "total_computation_used") @Required val totalComputationUsed: kotlin.String

)

