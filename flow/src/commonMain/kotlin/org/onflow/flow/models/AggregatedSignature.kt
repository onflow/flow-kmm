package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray
import org.onflow.flow.infrastructure.Base64ByteArraySerializer

/**
 * 
 *
 * @param verifierSignatures 
 * @param signerIds 
 */
@Serializable
data class AggregatedSignature (

    @Required
    @SerialName(value = "verifier_signatures")
    val verifierSignatures: List< @Serializable(with = Base64ByteArraySerializer::class) Base64ByteArray>,

    @SerialName(value = "signer_ids") @Required val signerIds: List<String>

)

