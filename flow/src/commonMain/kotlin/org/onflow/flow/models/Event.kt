package org.onflow.flow.models
import org.onflow.flow.infrastructure.Cadence
import kotlinx.serialization.*
import org.onflow.flow.infrastructure.SafeStringSerializer

/**
 * 
 *
 * @param type The qualified event type.
 * @param transactionId A 32-byte unique identifier for an entity.
 * @param transactionIndex 
 * @param eventIndex 
 * @param payload 
 */
@Serializable
data class Event (
    /* The qualified event type. */
    @SerialName(value = "type") @Required val type: kotlin.String,

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "transaction_id") @Required val transactionId: kotlin.String,

    @SerialName(value = "transaction_index") 
    @Serializable(with = SafeStringSerializer::class)
    @Required val transactionIndex: kotlin.String,

    @SerialName(value = "event_index") 
    @Serializable(with = SafeStringSerializer::class)
    @Required val eventIndex: kotlin.String,

    @Serializable(CadenceBase64Serializer::class)
    @SerialName(value = "payload") @Required val payload: Cadence.Value
)

