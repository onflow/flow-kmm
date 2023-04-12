package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param index Index of the public key.
 * @param publicKey Hex encoded public key.
 * @param signingAlgorithm 
 * @param hashingAlgorithm 
 * @param sequenceNumber Current account sequence number.
 * @param weight Weight of the key.
 * @param revoked Flag indicating whether the key is active or not.
 */
@Serializable
data class AccountPublicKey (

    /* Index of the public key. */
    @SerialName(value = "index") @Required val index: String,

    /* Hex encoded public key. */
    @SerialName(value = "public_key") @Required val publicKey: String,

    @SerialName(value = "signing_algorithm") @Required val signingAlgorithm: SigningAlgorithm,

    @SerialName(value = "hashing_algorithm") @Required val hashingAlgorithm: HashingAlgorithm,

    /* Current account sequence number. */
    @SerialName(value = "sequence_number") @Required val sequenceNumber: String,

    /* Weight of the key. */
    @SerialName(value = "weight") @Required val weight: String,

    /* Flag indicating whether the key is active or not. */
    @SerialName(value = "revoked") @Required val revoked: Boolean

)

