package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 * 
 *
 * @param id A 32-byte unique identifier for an entity.
 * @param parentId A 32-byte unique identifier for an entity.
 * @param height 
 * @param timestamp 
 * @param parentVoterSignature A variable length signature.
 */
@Serializable
data class BlockHeader (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "id") @Required val id: kotlin.String,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "parent_id") @Required val parentId: kotlin.String,

    @SerialName(value = "height") @Required val height: kotlin.String,

    @SerialName(value = "timestamp") @Required val timestamp: kotlin.String,

    /* A variable length signature. */
    @SerialName(value = "parent_voter_signature") @Required val parentVoterSignature: Base64ByteArray

)

