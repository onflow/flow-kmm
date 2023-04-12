package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 * 
 *
 * @param verifierSignatures 
 * @param signerIds 
 */
@Serializable
data class AggregatedSignature (

    @SerialName(value = "verifier_signatures") @Required val verifierSignatures: List<Base64ByteArray>,

    @SerialName(value = "signer_ids") @Required val signerIds: List<String>

)

