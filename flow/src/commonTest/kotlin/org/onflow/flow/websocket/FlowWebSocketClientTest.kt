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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

        try {
            println("Connected successfully: blocks")

            val subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.BLOCKS.value,
                arguments = mapOf("block_status" to "sealed")
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
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToBlockDigests() = runTest {
        val wsClient = createClientAndConnect()

        try {
            println("Connected successfully: block_digests")

            val subscription = wsClient.subscribeWithStrings(
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
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToBlockHeaders() = runTest {
        val wsClient = createClientAndConnect()

        try {
            println("Connected successfully: block_headers")

            val subscription = wsClient.subscribeWithStrings(
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
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToEvents() = runTest {
        val wsClient = createClientAndConnect()

        try {
            println("Connected successfully: events")

            val eventTypes = JsonArray(
                listOf(
                    JsonPrimitive("flow.AccountKeyAdded"),
                    JsonPrimitive("flow.AccountKeyRemoved")
                )
            )

            val subscription = wsClient.subscribe(
                topic = FlowWebSocketTopic.EVENTS.value,
                arguments = mapOf(
                    "event_types" to eventTypes
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
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToAccountStatuses() = runTest {
        val wsClient = createClientAndConnect()

        try {
            println("Connected successfully: account_statuses")

            val subscription = wsClient.subscribe(
                topic = FlowWebSocketTopic.ACCOUNT_STATUSES.value,
                arguments = mapOf(
                    "event_types" to JsonArray(
                        listOf(
                            JsonPrimitive("flow.AccountKeyAdded"),
                            JsonPrimitive("flow.AccountKeyRemoved")
                        )
                    ),
                    "start_block_height" to JsonPrimitive("106219488"),
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
            wsClient.close()
        }
    }

    @Test
    fun testSubscribeToTransactionStatuses() = runTest {
        val wsClient = createClientAndConnect()

        try {
            println("Connected successfully: transaction_statuses")

            val subscription = wsClient.subscribeWithStrings(
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
            wsClient.close()
        }
    }


    @Test
    fun testListSubscriptions() = runTest {
        val client = HttpClient {
            install(WebSockets)
        }
        val wsClient = FlowWebSocketClient(client)

        try {
            wsClient.connect(FlowWebSocketClient.MAINNET_WS_URL)

            val subscription = wsClient.subscribeWithStrings(
                topic = FlowWebSocketTopic.BLOCKS.value,
                arguments = mapOf("block_status" to "sealed")
            )

            // Wait a moment for the subscription to register
            delay(1000)

            val listed = wsClient.listSubscriptions()
            val match = listed.find { it.subscriptionId == subscription.subscriptionId }

            assertNotNull(match)
            assertEquals(FlowWebSocketTopic.BLOCKS.value, match.topic)

        } finally {
            wsClient.close()
            client.close()
        }
    }
}