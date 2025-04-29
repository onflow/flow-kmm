package org.onflow.flow.websocket

import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FlowWebSocketClientTest {
    @Test
    fun testSubscribeToBlocks() = runTest {
        val client = HttpClient {
            install(WebSockets)
        }

        val wsClient = FlowWebSocketClient(client)

        try {
            wsClient.connect(FlowWebSocketClient.MAINNET_WS_URL) // Using testnet for tests

            println("Connected successfully")

            val flow = wsClient.subscribe(
                topic = FlowWebSocketTopic.BLOCKS.value,
                arguments = mapOf(
                    "block_status" to "sealed"
                )
            )

            val responses = withContext(Dispatchers.Default.limitedParallelism(1)) {
                withTimeout(30_000) {
                    wsClient.subscribe(
                        topic = FlowWebSocketTopic.BLOCKS.value,
                        arguments = mapOf(
                            "block_status" to "sealed"
                        )
                    ).take(1).toList()
                }
            }

            if (responses.isEmpty()) {
                println("No responses received.")
            } else {
                println("Received block event: ${responses.first()}")
                assertEquals(1, responses.size)
                val response = responses.first()
                assertNotNull(response.payload)
                assertEquals(FlowWebSocketTopic.BLOCKS.value, response.topic)
            }
        } finally {
            wsClient.close()
            client.close()
        }
    }

    @Test
    fun testSubscribeToEvents() = runTest {
        val client = HttpClient {
            install(WebSockets)
        }

        val wsClient = FlowWebSocketClient(client)

        try {
            wsClient.connect(FlowWebSocketClient.MAINNET_WS_URL)

            // Subscribe to A.1654653399040a61.FlowToken.TokensDeposited events
            val responses = wsClient.subscribe(
                topic = FlowWebSocketTopic.EVENTS.value,
                arguments = mapOf(
                    "type" to "A.1654653399040a61.FlowToken.TokensDeposited"
                )
            ).take(1).toList() // Only take first event for testing

            // Verify we received a response
            assertEquals(1, responses.size)
            val response = responses.first()
            assertNotNull(response.payload)
            assertEquals(FlowWebSocketTopic.EVENTS.value, response.topic)

        } finally {
            wsClient.close()
            client.close()
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

            // Create a subscription first
            wsClient.subscribe(
                topic = FlowWebSocketTopic.BLOCKS.value,
                subscriptionId = "test-subscription",
                arguments = mapOf("block_status" to "sealed", "start_block_id" to "83a8229cbe552f9b10160163394986dc7d99790ad3fedf7db4153d7d7863a3fa")
            )

            // List subscriptions
            val subscriptions = wsClient.listSubscriptions()

            // Verify the subscription exists
            val subscription = subscriptions.find { it.subscriptionId == "test-subscription" }
            assertNotNull(subscription)
            assertEquals(FlowWebSocketTopic.BLOCKS.value, subscription.topic)

        } finally {
            wsClient.close()
            client.close()
        }
    }
}