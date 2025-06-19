package org.onflow.flow.websocket

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import org.onflow.flow.models.Event
import org.onflow.flow.models.TransactionResult

/**
 * Base interface for WebSocket messages to avoid sealed class ASM transformation issues
 */
interface FlowWebSocketMessage {
    val subscriptionId: String?
}

@Serializable
data class FlowWebSocketRequest(
    @SerialName("subscription_id")
    override val subscriptionId: String? = null,
    val action: String,
    val topic: String? = null,
    val arguments: Map<String, JsonElement>? = null
) : FlowWebSocketMessage

@Serializable
data class FlowWebSocketResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String? = null,
    val action: String? = null,
    val topic: String? = null,
    val payload: JsonElement? = null,
    val error: FlowWebSocketError? = null
) : FlowWebSocketMessage

@Serializable
data class BlockEventPayload(
    val header: org.onflow.flow.models.BlockHeader,
    val payload: BlockDetails
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

// --- Block Digests Event ---

@Serializable
data class BlockDigestPayload(
    @SerialName("block_id")
    val blockId: String,
    @SerialName("final_state")
    val finalState: String? = null,
    val collections: List<BlockDigestCollection> = emptyList()
)

@Serializable
data class BlockDigestCollection(
    @SerialName("collection_id")
    val collectionId: String
)

// --- Block Headers Event ---

@Serializable
data class BlockHeaderPayload(
    @SerialName("id") val id: String,
    @SerialName("parent_id") val parentId: String,
    val height: Long,
    val timestamp: String,
    @SerialName("parent_voter_signature") val parentVoterSignature: String
) {
//    fun toBlockHeader(): org.onflow.flow.models.BlockHeader {
//        return org.onflow.flow.models.BlockHeader(
//            id = id,
//            parentId = parentId,
//            height = height.toString(),
//            timestamp = timestamp,
//            parentVoterSignature = org.onflow.flow.infrastructure.Base64ByteArray(parentVoterSignature.toByteArray())
//        )
//    }
}

// --- Events Event ---

@Serializable
data class EventsPayload(
    @SerialName("block_id") val blockId: String,
    @SerialName("block_height") val blockHeight: Long,
    @SerialName("block_timestamp") val blockTimestamp: String,
    val events: List<Event> = emptyList()
)

// --- Account Status Event ---

@Serializable
data class AccountStatusPayload(
    @SerialName("block_id") val blockId: String,
    @SerialName("height") val blockHeight: Long,
    @SerialName("message_index") val messageIndex: Long,
    @SerialName("account_events") val accountEvents: Map<String, List<Event>> = emptyMap()
)

// --- Transaction Status Event ---

@Serializable
data class TransactionStatusPayload(
    @SerialName("transaction_result") val transactionResult: TransactionResult,
    @SerialName("message_index") val messageIndex: Long,
)

// --- Send Transaction Status Event ---

@Serializable
data class SendTransactionStatusPayload(
    @SerialName("transaction_result") val transactionResult: TransactionResult,
    @SerialName("message_index") val messageIndex: Long,
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