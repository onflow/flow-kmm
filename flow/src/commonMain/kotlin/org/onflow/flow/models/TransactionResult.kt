package org.onflow.flow.models
import kotlinx.serialization.*
import org.onflow.flow.infrastructure.SafeStringSerializer
import org.onflow.flow.infrastructure.SafeTransactionExecutionSerializer

/**
 * 
 *
 * @param blockId A 32-byte unique identifier for an entity.
 * @param status 
 * @param statusCode 
 * @param errorMessage Provided transaction error in case the transaction wasn't successful.
 * @param computationUsed 
 * @param events 
 * @param execution 
 * @param links 
 */
@Serializable
data class TransactionResult (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "block_id") @Required val blockId: String,

    @SerialName(value = "status") val status: TransactionStatus? = TransactionStatus.UNKNOWN,

    @SerialName(value = "status_code") @Required val statusCode: Int,

    /* Provided transaction error in case the transaction wasn't successful. */
    @SerialName(value = "error_message") @Required val errorMessage: String,

    @SerialName(value = "computation_used") 
    @Serializable(with = SafeStringSerializer::class)
    @Required val computationUsed: String,

    @SerialName(value = "events") @Required val events: List<Event>,

    @SerialName(value = "execution") 
    @Serializable(with = SafeTransactionExecutionSerializer::class)
    val execution: TransactionExecution? = null,

    @SerialName(value = "_links") val links: Links? = null

)

