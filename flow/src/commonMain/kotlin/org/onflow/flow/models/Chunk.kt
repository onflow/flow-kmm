package org.onflow.flow.models

import org.onflow.flow.infrastructure.Base64ByteArray
import kotlinx.serialization.*

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

    @SerialName(value = "start_state") @Required val startState: Base64ByteArray,

    @SerialName(value = "end_state") @Required val endState: Base64ByteArray,

    @SerialName(value = "event_collection") @Required val eventCollection: Base64ByteArray,

    @SerialName(value = "index") @Required val index: kotlin.String,

    @SerialName(value = "number_of_transactions") @Required val numberOfTransactions: kotlin.String,

    @SerialName(value = "total_computation_used") @Required val totalComputationUsed: kotlin.String

)

