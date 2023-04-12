package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param blockId A 32-byte unique identifier for an entity.
 * @param resultId A 32-byte unique identifier for an entity.
 * @param finalState The root hash of the state tree.
 * @param aggregatedApprovalSignatures 
 */
@Serializable
data class BlockSeal (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "block_id") @Required val blockId: String,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "result_id") @Required val resultId: String,

    /* The root hash of the state tree. */
    @SerialName(value = "final_state") @Required val finalState: String,

    @SerialName(value = "aggregated_approval_signatures") @Required val aggregatedApprovalSignatures: List<AggregatedSignature>

)

