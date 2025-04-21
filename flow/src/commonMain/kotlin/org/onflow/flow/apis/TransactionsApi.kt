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

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/transaction_results/$transactionId") {
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

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        val result = client.get("$baseUrl/transactions/$id") {
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
        return requestTransactionResultById(transactionId)
    }

    internal suspend fun getTransaction(transactionId: String): Transaction {
        return requestTransactionById(transactionId)
    }

    internal suspend fun sendTransaction(request: Transaction): Transaction {
        return requestSendTransaction(request)
    }

    internal suspend fun waitForSeal(transactionId: String): TransactionResult {
        var attempts = 0
        val maxAttempts = 30 // 30 seconds timeout

        while (attempts < maxAttempts) {
            val result = getTransactionResult(transactionId)
            when (result.status ?: TransactionStatus.EMPTY) {
                TransactionStatus.SEALED -> {
                    if (result.errorMessage.isNotBlank() || result.execution == TransactionExecution.failure) {
                        throw RuntimeException("Transaction failed: ${result.errorMessage}")
                    }
                    return result
                }

                TransactionStatus.EXPIRED -> throw RuntimeException("Transaction expired")
                TransactionStatus.EMPTY, TransactionStatus.UNKNOWN -> {
                    // Treat empty/unknown status as pending
                    attempts++
                    delay(1000)
                }

                else -> {
                    attempts++
                    delay(1000)
                }
            }
        }

        throw RuntimeException("Transaction not sealed after $maxAttempts seconds")
    }

    private suspend fun resolveKeyIndex(address: FlowAddress, accountsApi: AccountsApi): Int {
        val account = accountsApi.getAccount(address.base16Value)
        return account.keys?.firstOrNull()?.index?.toInt()
            ?: throw IllegalStateException("No keys found for address $address")
    }
}
