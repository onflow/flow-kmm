package org.onflow.flow.infrastructure

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

open class ApiBase {

    companion object {
        val client = HttpClient {
            install(HttpTimeout) {
                requestTimeoutMillis = 30000L // 30 seconds
                connectTimeoutMillis = 15000L // 15 seconds  
                socketTimeoutMillis = 30000L  // 30 seconds
            }
            
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 5)
                exponentialDelay()
            }

            install(Logging) {
                logger = Logger.DEFAULT
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
        }
    }

}
