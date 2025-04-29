package org.onflow.flow.websocket

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
sealed class FlowWebSocketMessage {
    abstract val subscriptionId: String?
}

@Serializable
data class FlowWebSocketRequest(
    @SerialName("subscription_id")
    override val subscriptionId: String? = null,
    val action: String,
    val topic: String? = null,
    val arguments: Map<String, String>? = null
) : FlowWebSocketMessage()

@Serializable
data class FlowWebSocketResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String? = null,
    val action: String? = null,
    val topic: String? = null,
    val payload: JsonElement? = null,
    val error: FlowWebSocketError? = null
) : FlowWebSocketMessage()

@Serializable
data class FlowWebSocketError(
    val code: Int,
    val message: String
)

@Serializable
data class FlowWebSocketSubscriptionList(
    val subscriptions: List<FlowWebSocketSubscription>
)

@Serializable
data class FlowWebSocketSubscription(
    @SerialName("subscription_id")
    val subscriptionId: String,
    val topic: String,
    val arguments: Map<String, String>
) 