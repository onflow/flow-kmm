package org.onflow.flow.websocket

import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertFalse

@Ignore
class FlowWebSocketClientTest {

    private suspend fun createClientAndConnect(): FlowWebSocketClient {
        val client = HttpClient {
            install(WebSockets)
        }
        val wsClient = FlowWebSocketClient(client)
        wsClient.connect(FlowWebSocketClient.MAINNET_WS_URL)
        return wsClient
    }

    @Test
    fun testSubscribeToBlocks() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: blocks")

            subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.BLOCKS.value,
                arguments = mapOf("block_status" to "finalized")
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.BLOCKS.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received block event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.BLOCKS.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToBlockDigests() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: block_digests")

            subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.BLOCK_DIGESTS.value,
                arguments = mapOf("block_status" to "sealed")
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.BLOCK_DIGESTS.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received block digest event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.BLOCK_DIGESTS.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToBlockHeaders() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: block_headers")

            subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.BLOCK_HEADERS.value,
                arguments = mapOf("block_status" to "sealed")
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.BLOCK_HEADERS.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received block header event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.BLOCK_HEADERS.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToEvents() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: events")

            val eventTypes = JsonArray(
                listOf(
                    JsonPrimitive("flow.AccountKeyAdded"),
                    JsonPrimitive("flow.AccountKeyRemoved")
                )
            )

            subscription = wsClient.subscribe(
                topic = FlowWebSocketTopic.EVENTS.value,
                arguments = mapOf(
                    "event_types" to eventTypes,
                    "start_block_id" to JsonPrimitive("44774d980c75d9380caaf4c65a2ee6c4bde9a1e6da6aa858fe2dc5e4a7aff773"),
                    "heartbeat_interval" to JsonPrimitive("5"),
                )
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.EVENTS.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.EVENTS.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToAccountStatuses() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: account_statuses")

            subscription = wsClient.subscribe(
                topic = FlowWebSocketTopic.ACCOUNT_STATUSES.value,
                arguments = mapOf(
                    "event_types" to JsonArray(
                        listOf(
                            JsonPrimitive("flow.AccountKeyAdded"),
                            JsonPrimitive("flow.AccountKeyRemoved")
                        )
                    ),
                    "start_block_height" to JsonPrimitive("111437778"),
                    "heartbeat_interval" to JsonPrimitive("10")
                )
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.ACCOUNT_STATUSES.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received account status event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.ACCOUNT_STATUSES.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToTransactionStatuses() = runTest {
        val wsClient = createClientAndConnect()
        var subscription: FlowWebSocketClient.SubscriptionResult? = null

        try {
            println("Connected successfully: transaction_statuses")

            subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.TRANSACTION_STATUSES.value,
                arguments = mapOf("tx_id" to "fe3784095bc194dca02e4b14e7e6a1e0519d10b7bc907453e5b5dc276259a106")
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    subscription.events
                        .filter { it.topic == FlowWebSocketTopic.TRANSACTION_STATUSES.value }
                        .take(1)
                        .toList()
                }
            }

            assertEquals(1, responses.size)
            val response = responses.first()
            println("Received transaction status event: $response")
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.TRANSACTION_STATUSES.value, response.topic)

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }

    @Test
    fun testListSubscriptions() = runTest {
        val wsClient = createClientAndConnect()

        // First list should be empty
        val initialList = withContext(Dispatchers.Default.limitedParallelism(1)) {
            withTimeout(10_000) {
                println("Requesting initial list of subscriptions")
                val list = wsClient.listSubscriptions()
                println("Received initial list: $list")
                list
            }
        }
        assertEquals(0, initialList.size, "Initial list should be empty")

        // Create a subscription
        val subscription = wsClient.subscribeWithStrings(
            topic = FlowWebSocketTopic.BLOCKS.value,
            arguments = mapOf("block_status" to "sealed")
        )
        try {
            // Let server register the subscription
            delay(10_000)

            // List should now contain subscription
            val listed = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    val list = wsClient.listSubscriptions()
                    println("Received updated list: $list")
                    list
                }
            }

            val match = listed.find { it.subscriptionId == subscription.subscriptionId }

            assertNotNull(match, "Should find our subscription in the list")
            assertEquals(FlowWebSocketTopic.BLOCKS.value, match.topic, "Topic should match")
            assertEquals(mapOf("block_status" to "sealed"), match.arguments, "Arguments should match")

            // Unsubscribe and verify it's removed
            wsClient.unsubscribe(subscription.subscriptionId)
            delay(10_000)

            val finalList = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(10_000) {
                    val list = wsClient.listSubscriptions()
                    list
                }
            }
            assertFalse(finalList.any { it.subscriptionId == subscription.subscriptionId }, "Subscription should be removed from list")

        } finally {
            subscription?.let { wsClient.unsubscribe(it.subscriptionId) }
            wsClient.close()
        }
    }
}
