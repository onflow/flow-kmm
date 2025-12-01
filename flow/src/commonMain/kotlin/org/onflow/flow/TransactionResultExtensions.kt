package org.onflow.flow

import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.getField
import org.onflow.flow.models.Event
import org.onflow.flow.models.TransactionResult
import org.onflow.flow.models.TransactionStatus

private const val ACCOUNT_CREATED_EVENT_TYPE = "flow.AccountCreated"
private const val ACCOUNT_CREATED_FIELD_NAME = "address"

/**
 * Find the first event of a given type.
 */
fun TransactionResult.findEvent(type: String): Event? =
    events.firstOrNull { it.type == type }

/**
 * Decode a field from an event payload (Cadence.EventValue) by name.
 */
inline fun <reified T> Event.getField(name: String): T? {
    val eventValue = payload as? Cadence.Value.EventValue ?: return null
    return eventValue.value.getField<T>(name)
}

/**
 * Return the created account address (hex string) from a transaction result if present.
 */
fun TransactionResult.getCreatedAddress(): String? =
    findEvent(ACCOUNT_CREATED_EVENT_TYPE)?.getField<String>(ACCOUNT_CREATED_FIELD_NAME)

/**
 * Convenience: fetch transaction result and return created address if present.
 */
suspend fun FlowApi.getCreatedAccountAddress(txId: String): String? =
    getTransactionResult(txId).getCreatedAddress()

/**
 * Wait until transaction is at least EXECUTED, then try to read created account address.
 * Uses waitForSeal to guarantee a sealed result before reading events.
 */
suspend fun FlowApi.waitForCreatedAccountAddress(
    txId: String
): String? {
    val sealed = waitForSeal(txId)
    return sealed.getCreatedAddress()
}
