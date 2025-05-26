package org.onflow.flow.websocket

enum class FlowWebSocketTopic(val value: String) {
    BLOCK_DIGESTS("block_digests"),
    BLOCK_HEADERS("block_headers"),
    BLOCKS("blocks"),
    EVENTS("events"),
    ACCOUNT_STATUSES("account_statuses"),
    TRANSACTION_STATUSES("transaction_statuses"),
    SEND_AND_GET_TRANSACTION_STATUSES("send_and_get_transaction_statuses");

    companion object {
        fun fromString(value: String): FlowWebSocketTopic? =
            values().find { it.value == value }
    }
} 