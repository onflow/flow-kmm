package org.onflow.flow.websocket

import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.encodedPath
import io.ktor.http.fullPath
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

class FlowWebSocketClient(
    private val client: HttpClient,
    private val json: Json = Json { ignoreUnknownKeys = true }
) {
    private var webSocketSession: DefaultWebSocketSession? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val subscriptions = mutableMapOf<String, Channel<FlowWebSocketResponse>>()
    private val listSubscriptionsChannel = Channel<FlowWebSocketResponse>(Channel.UNLIMITED)

    private var connectionJob: Job? = null

    suspend fun connect(url: String) {
        val uri = Url(url)

        connectionJob = scope.launch {
            client.webSocket(
                method = HttpMethod.Get,
                host = uri.host,
                port = uri.port.takeIf { it != -1 } ?: if (uri.protocol.name == "wss") 443 else 80,
                path = uri.fullPath,
                request = {
                    url {
                        protocol = if (uri.protocol.name == "wss") URLProtocol.WSS else URLProtocol.WS
                        host = uri.host
                        port = uri.port.takeIf { it != -1 } ?: if (uri.protocol.name == "wss") 443 else 80
                        encodedPath = uri.encodedPath
                    }
                }
            ) {
                webSocketSession = this

                try {
                    processIncomingMessages()
                } catch (e: Exception) {
                    println("Error processing incoming messages: $e")
                } finally {
                    subscriptions.values.forEach { it.close() }
                    subscriptions.clear()
                }
            }
        }

        // Wait for session to be assigned
        while (webSocketSession == null) {
            delay(10)
        }
    }

    private fun deserializeTopicPayload(topic: String, payload: JsonElement): JsonElement {
        return when (topic) {
            "blocks" -> json.encodeToJsonElement(BlockEventPayload.serializer(), json.decodeFromJsonElement(BlockEventPayload.serializer(), payload))
            "block_digests" -> json.encodeToJsonElement(BlockDigestPayload.serializer(), json.decodeFromJsonElement(BlockDigestPayload.serializer(), payload))
            "block_headers" -> json.encodeToJsonElement(BlockHeaderPayload.serializer(), json.decodeFromJsonElement(BlockHeaderPayload.serializer(), payload))
            "events" -> json.encodeToJsonElement(EventsPayload.serializer(), json.decodeFromJsonElement(EventsPayload.serializer(), payload))
            "account_statuses" -> json.encodeToJsonElement(AccountStatusPayload.serializer(), json.decodeFromJsonElement(AccountStatusPayload.serializer(), payload))
            "transaction_statuses" -> json.encodeToJsonElement(TransactionStatusPayload.serializer(), json.decodeFromJsonElement(TransactionStatusPayload.serializer(), payload))
            "send_transaction_statuses" -> json.encodeToJsonElement(SendTransactionStatusPayload.serializer(), json.decodeFromJsonElement(SendTransactionStatusPayload.serializer(), payload))
            else -> payload // 🔥 fallback: if unknown topic, keep raw
        }
    }

    private suspend fun DefaultWebSocketSession.processIncomingMessages() {
        try {
            for (frame in incoming) {
                withContext(NonCancellable) {
                    when (frame) {
                        is Frame.Text -> {
                            val rawText = frame.readText()
                            println("Raw incoming message: $rawText")
                            try {
                                val baseResponse = json.decodeFromString<FlowWebSocketResponse>(rawText)

                                // Handle list_subscriptions response
                                if (baseResponse.action == "list_subscriptions") {
                                    if (!listSubscriptionsChannel.isClosedForSend) {
                                        // Create a new response with the raw payload
                                        val responseWithPayload = baseResponse.copy(
                                            payload = json.parseToJsonElement(rawText)
                                        )
                                        listSubscriptionsChannel.send(responseWithPayload)
                                    }
                                    return@withContext
                                }

                                println(baseResponse)
                                val id = baseResponse.subscriptionId

                                if (id != null) {
                                    val wrappedResponse = if (baseResponse.topic != null && baseResponse.payload != null) {
                                        try {
                                            val decodedPayload = deserializeTopicPayload(baseResponse.topic, baseResponse.payload)
                                            println(decodedPayload)
                                            baseResponse.copy(payload = decodedPayload)
                                        } catch (e: Exception) {
                                            println("Failed to decode payload for topic ${baseResponse.topic}: $e")
                                            baseResponse
                                        }
                                    } else {
                                        baseResponse
                                    }

                                    subscriptions[id]?.let { channel ->
                                        if (!channel.isClosedForSend) {
                                            channel.send(wrappedResponse)
                                        } else {
                                            println("Channel for $id is already closed, dropping message")
                                        }
                                    }
                                } else {
                                    println("Received a message without subscription_id, ignoring.")
                                }
                            } catch (e: Exception) {
                                println("Failed to parse incoming WebSocket frame: $e")
                            }
                        }
                        else -> {
                            // ignore other frames
                        }
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    data class SubscriptionResult(
        val subscriptionId: String,
        val events: Flow<FlowWebSocketResponse>
    )

    // Primary overload for callers who want to use raw JsonElement-based arguments
    suspend fun subscribe(
        topic: String,
        arguments: Map<String, JsonElement>? = null
    ): SubscriptionResult {
        val actualSubscriptionId = generateSubscriptionId()

        val channel = Channel<FlowWebSocketResponse>(Channel.BUFFERED)
        subscriptions[actualSubscriptionId] = channel

        sendMessage(
            FlowWebSocketRequest(
                subscriptionId = actualSubscriptionId,
                action = "subscribe",
                topic = topic,
                arguments = arguments
            )
        )

        println("Sent subscription request: $actualSubscriptionId")

        return SubscriptionResult(
            subscriptionId = actualSubscriptionId,
            events = channel.consumeAsFlow()
        )
    }

    // Convenience overload for simple String-to-String maps
    // Convenience wrapper for Map<String, String>
    suspend fun subscribeWithStrings(
        topic: String,
        arguments: Map<String, String>? = null
    ): SubscriptionResult = subscribe(
        topic = topic,
        arguments = arguments?.mapValues { JsonPrimitive(it.value) }
    )

    suspend fun unsubscribe(subscriptionId: String) {
        val request = FlowWebSocketRequest(
            subscriptionId = subscriptionId,
            action = "unsubscribe"
        )
        sendMessage(request)
        subscriptions.remove(subscriptionId)?.close()
    }

    suspend fun listSubscriptions(): List<FlowWebSocketSubscription> {
        sendMessage(
            FlowWebSocketRequest(
                action = "list_subscriptions"
            )
        )

        // Wait for the list response (or timeout)
        val response = withTimeout(10_000) {
            listSubscriptionsChannel.receive()
        }

        if (response.error != null) {
            throw IllegalStateException("Failed to list subscriptions: ${response.error.message}")
        }

        // Handle null payload
        if (response.payload == null) {
            return emptyList()
        }

        try {
            // Parse the payload into FlowWebSocketSubscriptionList
            val subscriptionList = json.decodeFromJsonElement(
                FlowWebSocketSubscriptionList.serializer(),
                response.payload
            )
            return subscriptionList.subscriptions
        } catch (e: Exception) {
            println("Failed to parse subscription list: $e")
            return emptyList()
        }
    }

    private suspend fun sendMessage(message: FlowWebSocketMessage) {
        val session = webSocketSession ?: throw IllegalStateException("Not connected")
        val text = json.encodeToString(FlowWebSocketMessage.serializer(), message)
        session.send(Frame.Text(text))
    }

    private fun generateSubscriptionId(): String {
        val randomPart = (0..9999).random().toString().padStart(4, '0')
        val timestamp = kotlin.time.TimeSource.Monotonic.markNow().elapsedNow().inWholeMilliseconds
        return "sub${timestamp}$randomPart".take(20)
    }

    suspend fun close() {
        scope.cancel()
        webSocketSession?.close()
        subscriptions.values.forEach { it.close() }
        subscriptions.clear()
        listSubscriptionsChannel.close()
    }

    companion object {
        const val MAINNET_WS_URL = "wss://rest-mainnet.onflow.org/v1/ws"
        const val TESTNET_WS_URL = "wss://rest-testnet.onflow.org/v1/ws"
    }
} 