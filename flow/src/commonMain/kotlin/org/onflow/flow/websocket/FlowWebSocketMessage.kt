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

// Block Events
@Serializable
data class BlockEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: BlockEventPayload,
    val block_status: String? = null
) : FlowWebSocketMessage()


@Serializable
data class BlockEventPayload(
    val header: BlockHeader,
    val payload: BlockDetails
)

@Serializable
data class BlockHeader(
    val id: String,
    @SerialName("parent_id") val parentId: String,
    val height: Long,
    val timestamp: String,
    @SerialName("parent_voter_signature") val parentVoterSignature: String
)

@Serializable
data class BlockDetails(
    @SerialName("collection_guarantees") val collectionGuarantees: List<CollectionGuarantee> = emptyList(),
    @SerialName("block_seals") val blockSeals: List<BlockSeal> = emptyList()
)

@Serializable
data class CollectionGuarantee(
    @SerialName("collection_id") val collectionId: String,
    @SerialName("signer_indices") val signerIndices: String,
    val signature: String
)

@Serializable
data class BlockSeal(
    @SerialName("block_id") val blockId: String,
    @SerialName("result_id") val resultId: String,
    @SerialName("final_state") val finalState: String,
    @SerialName("aggregated_approval_signatures") val aggregatedApprovalSignatures: List<ApprovalSignature> = emptyList()
)

@Serializable
data class ApprovalSignature(
    @SerialName("verifier_signatures") val verifierSignatures: List<String> = emptyList(),
    @SerialName("signer_ids") val signerIds: List<String> = emptyList()
)

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