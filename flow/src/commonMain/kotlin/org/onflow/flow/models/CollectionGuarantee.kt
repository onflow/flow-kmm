package org.onflow.flow.models


import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 * 
 *
 * @param collectionId A 32-byte unique identifier for an entity.
 * @param signerIds 
 * @param signature A variable length signature.
 */
@Serializable
data class CollectionGuarantee (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "collection_id") @Required val collectionId: String,

    @SerialName(value = "signer_ids") val signerIds: List<String>? = null,

    /* A variable length signature. */
    @SerialName(value = "signature") @Required val signature: Base64ByteArray

)

