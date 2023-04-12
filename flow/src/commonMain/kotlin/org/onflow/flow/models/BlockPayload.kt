package org.onflow.flow.models
import kotlinx.serialization.*

/**
 * 
 *
 * @param collectionGuarantees 
 * @param blockSeals 
 */
@Serializable
data class BlockPayload (

    @SerialName(value = "collection_guarantees") @Required val collectionGuarantees: List<CollectionGuarantee>,

    @SerialName(value = "block_seals") @Required val blockSeals: List<BlockSeal>

)

