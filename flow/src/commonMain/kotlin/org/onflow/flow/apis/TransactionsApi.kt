package org.onflow.flow.apis

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay
import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionResult
import org.onflow.flow.models.TransactionStatus
import org.onflow.flow.models.TransactionExecution

internal class TransactionsApi(val baseUrl: String) : ApiBase() {

    private suspend fun requestTransactionResultById(
        transactionId: String,
        expand: Set<String>? = null,
        select: Set<String>? = null
    ): TransactionResult {
        val normalizedId = transactionId.removePrefix("0x")

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/transaction_results/$normalizedId") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    private suspend fun requestTransactionById(
        id: String,
        expand: Set<String>? = null,
        select: Set<String>? = null
    ): Transaction {
        val normalizedId = id.removePrefix("0x")

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        val result = client.get("$baseUrl/transactions/$normalizedId") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }

        return result.body()
    }

    private suspend fun requestSendTransaction(transaction: Transaction): Transaction {
        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"

        val response = client.post("$baseUrl/transactions") {
            headers {
                headers.forEach { header ->
                    append(header.key, header.value)
                }
            }
            setBody(transaction)
        }

        return try {
            response.body()
        } catch (e: Exception) {
            val errorText = response.bodyAsText()
            throw RuntimeException("Failed to send transaction: $errorText", e)
        }
    }

    internal suspend fun getTransactionResult(transactionId: String): TransactionResult {
        return requestTransactionResultById(transactionId.removePrefix("0x"))
    }

    internal suspend fun getTransaction(transactionId: String): Transaction {
        return requestTransactionById(transactionId.removePrefix("0x"))
    }

    internal suspend fun sendTransaction(request: Transaction): Transaction {
        return requestSendTransaction(request)
    }

    internal suspend fun waitForSeal(transactionId: String): TransactionResult {
        val normalizedId = transactionId.removePrefix("0x")
        var attempts = 0
        val maxAttempts = 60 // Increased to 60 attempts (up to 2 minutes)
        var lastError: Exception? = null

        while (attempts < maxAttempts) {
            try {
                val result = getTransactionResult(normalizedId)
                when (result.status ?: TransactionStatus.EMPTY) {
                    TransactionStatus.EXECUTED -> {
                        // Transaction is executed, return result
                        return result
                    }
                    TransactionStatus.SEALED -> {
                        // Transaction is sealed, return result
                        return result
                    }
                    TransactionStatus.EXPIRED -> throw RuntimeException("Transaction expired")
                    TransactionStatus.EMPTY, TransactionStatus.UNKNOWN, TransactionStatus.PENDING, TransactionStatus.FINALIZED -> {
                        // Treat empty/unknown/pending status as still processing, continue polling
                        attempts++
                        // Use exponential backoff with jitter for first few attempts, then stabilize
                        val delayMs = when {
                            attempts <= 5 -> 1000L // First 5 attempts: 1 second
                            attempts <= 15 -> 2000L // Next 10 attempts: 2 seconds  
                            else -> 3000L // Remaining attempts: 3 seconds
                        }
                        delay(delayMs)
                    }
                }
            } catch (e: Exception) {
                lastError = e
                attempts++
                

                // If we're getting consistent errors, increase delay to avoid hammering the server
                val errorDelayMs = when {
                    attempts <= 5 -> 2000L // 2 seconds for early failures
                    attempts <= 15 -> 5000L // 5 seconds for persistent failures
                    else -> 10000L // 10 seconds for repeated failures
                }
                delay(errorDelayMs)
            }
        }

        val timeoutMessage = if (lastError != null) {
            "Transaction not finalized after $maxAttempts attempts. Last error: ${lastError.message}"
        } else {
            "Transaction not finalized after $maxAttempts attempts"
        }
        throw RuntimeException(timeoutMessage)
    }
}
