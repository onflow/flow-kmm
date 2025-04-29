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

class FlowWebSocketClient(
    private val client: HttpClient,
    private val json: Json = Json { ignoreUnknownKeys = true }
) {
    private var webSocketSession: DefaultWebSocketSession? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val subscriptions = mutableMapOf<String, Channel<FlowWebSocketResponse>>()

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

    private suspend fun DefaultWebSocketSession.processIncomingMessages() {
        try {
            for (frame in incoming) {
                when (frame) {
                    is Frame.Text -> {
                        val rawText = frame.readText()
                        println("Raw incoming message: $rawText")
                        try {
                            val response = json.decodeFromString<FlowWebSocketResponse>(rawText)
                            response.subscriptionId?.let { id ->
                                subscriptions[id]?.send(response)
                            }
                        } catch (e: Exception) {
                            println("Failed to parse frame: $e")
                        }
                    }
                    else -> {} // ignore
                }
            }
        } catch (e: Exception) {
            // Handle connection errors
            throw e
        }
    }

    suspend fun subscribe(
        topic: String,
        subscriptionId: String? = null,
        arguments: Map<String, String>? = null
    ): Flow<FlowWebSocketResponse> {
        val request = FlowWebSocketRequest(
            subscriptionId = subscriptionId,
            action = "subscribe",
            topic = topic,
            arguments = arguments
        )

        val channel = Channel<FlowWebSocketResponse>(Channel.BUFFERED)
        val actualSubscriptionId = subscriptionId ?: generateSubscriptionId()
        subscriptions[actualSubscriptionId] = channel


        sendMessage(request)

        println("Sent message")

        return flow {
            try {
                for (message in channel) {
                    emit(message)
                }
            } catch (e: CancellationException) {
                // Flow cancelled normally, no problem
                println("Flow for subscription $actualSubscriptionId cancelled.")
            } finally {
                unsubscribe(actualSubscriptionId)
            }
        }
    }

    suspend fun unsubscribe(subscriptionId: String) {
        val request = FlowWebSocketRequest(
            subscriptionId = subscriptionId,
            action = "unsubscribe"
        )
        sendMessage(request)
        subscriptions.remove(subscriptionId)?.close()
    }

    suspend fun listSubscriptions(): List<FlowWebSocketSubscription> {
        val request = FlowWebSocketRequest(action = "list_subscriptions")
        sendMessage(request)
        // The response will come through the normal message processing
        return emptyList() // In reality, you'd want to wait for the response
    }

    private suspend fun sendMessage(message: FlowWebSocketMessage) {
        val session = webSocketSession ?: throw IllegalStateException("Not connected")
        val text = json.encodeToString(FlowWebSocketMessage.serializer(), message)
        session.send(Frame.Text(text))
    }

    private fun generateSubscriptionId(): String {
        val randomPart = (0..9999).random().toString().padStart(4, '0')
        return "sub${System.currentTimeMillis()}$randomPart".take(20)
    }

    suspend fun close() {
        scope.cancel()
        webSocketSession?.close()
        subscriptions.values.forEach { it.close() }
        subscriptions.clear()
    }

    companion object {
        const val MAINNET_WS_URL = "wss://rest-mainnet.onflow.org/v1/ws"
        const val TESTNET_WS_URL = "wss://rest-testnet.onflow.org/v1/ws"
    }
} 