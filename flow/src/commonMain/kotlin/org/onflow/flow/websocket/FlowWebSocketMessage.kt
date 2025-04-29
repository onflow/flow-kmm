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
    val arguments: Map<String, JsonElement>? = null
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

// --- Block Event ---
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

// --- Block Digests Event ---

@Serializable
data class BlockDigestEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: BlockDigestPayload,
    @SerialName("block_status")
    val blockStatus: String? = null
) : FlowWebSocketMessage()

@Serializable
data class BlockDigestPayload(
    @SerialName("block_id")
    val blockId: String,
    @SerialName("final_state")
    val finalState: String,
    val collections: List<BlockDigestCollection> = emptyList()
)

@Serializable
data class BlockDigestCollection(
    @SerialName("collection_id")
    val collectionId: String
)

// --- Block Headers Event ---

@Serializable
data class BlockHeaderEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: BlockHeaderPayload,
) : FlowWebSocketMessage()

@Serializable
data class BlockHeaderPayload(
    val headers: List<BlockHeaderInfo> = emptyList()
)

@Serializable
data class BlockHeaderInfo(
    @SerialName("block_id") val blockId: String,
    @SerialName("parent_id") val parentId: String,
    val height: Long,
    val timestamp: String,
    @SerialName("parent_voter_signature") val parentVoterSignature: String
)

// --- Events Event ---

@Serializable
data class EventsEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: EventsPayload
) : FlowWebSocketMessage()

@Serializable
data class EventsPayload(
    val events: List<FlowEvent> = emptyList()
)

@Serializable
data class FlowEvent(
    val type: String,
    @SerialName("transaction_id") val transactionId: String,
    @SerialName("transaction_index") val transactionIndex: Int,
    @SerialName("event_index") val eventIndex: Int,
    val payload: JsonElement,
    @SerialName("block_id") val blockId: String,
    @SerialName("block_height") val blockHeight: Long,
    @SerialName("block_timestamp") val blockTimestamp: String
)

// --- Account Status Event ---

@Serializable
data class AccountStatusEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: AccountStatusPayload
) : FlowWebSocketMessage()

@Serializable
data class AccountStatusPayload(
    val address: String,
    val balance: String,
    val code: List<String> = emptyList(),
    val keys: List<AccountPublicKey> = emptyList(),
    val contracts: Map<String, String> = emptyMap(),
    @SerialName("account_created") val accountCreated: Boolean,
    @SerialName("block_id") val blockId: String,
    @SerialName("block_height") val blockHeight: Long,
    @SerialName("block_timestamp") val blockTimestamp: String
)

@Serializable
data class AccountPublicKey(
    val index: Int,
    @SerialName("public_key") val publicKey: String,
    @SerialName("sign_algo") val signAlgo: Int,
    @SerialName("hash_algo") val hashAlgo: Int,
    val weight: Int,
    @SerialName("sequence_number") val sequenceNumber: Int,
    @SerialName("revoked") val revoked: Boolean
)

// --- Transaction Status Event ---

@Serializable
data class TransactionStatusEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: TransactionStatusPayload
) : FlowWebSocketMessage()

@Serializable
data class TransactionStatusPayload(
    @SerialName("transaction_id") val transactionId: String,
    val status: TransactionStatus,
    @SerialName("block_id") val blockId: String,
    @SerialName("block_height") val blockHeight: Long,
    @SerialName("block_timestamp") val blockTimestamp: String
)

@Serializable
enum class TransactionStatus {
    @SerialName("UNKNOWN")
    UNKNOWN,

    @SerialName("PENDING")
    PENDING,

    @SerialName("FINALIZED")
    FINALIZED,

    @SerialName("EXECUTED")
    EXECUTED,

    @SerialName("SEALED")
    SEALED,

    @SerialName("EXPIRED")
    EXPIRED
}

// --- Send Transaction Status Event ---

@Serializable
data class SendTransactionStatusEventResponse(
    @SerialName("subscription_id")
    override val subscriptionId: String,
    val topic: String?,
    val payload: SendTransactionStatusPayload
) : FlowWebSocketMessage()

@Serializable
data class SendTransactionStatusPayload(
    @SerialName("transaction_id") val transactionId: String,
    val status: SendTransactionStatus,
    @SerialName("block_id") val blockId: String? = null,
    @SerialName("block_height") val blockHeight: Long? = null,
    @SerialName("block_timestamp") val blockTimestamp: String? = null
)

@Serializable
enum class SendTransactionStatus {
    @SerialName("UNKNOWN")
    UNKNOWN,

    @SerialName("PENDING")
    PENDING,

    @SerialName("FINALIZED")
    FINALIZED,

    @SerialName("EXECUTED")
    EXECUTED,

    @SerialName("SEALED")
    SEALED,

    @SerialName("EXPIRED")
    EXPIRED,

    @SerialName("REJECTED")
    REJECTED
}

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