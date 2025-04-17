package org.onflow.flow.apis
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay
import org.onflow.flow.ChainId
import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionResult
import org.onflow.flow.models.TransactionStatus
import org.onflow.flow.infrastructure.scripts.CadenceScriptLoader
import org.onflow.flow.models.Signer

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
        while (true) {
            val result = getTransactionResult(transactionId)
            if (result.status == TransactionStatus.SEALED) {
                return result
            }
            delay(1000)
        }
    }

    internal suspend fun createCOAAccount(
        chainId: ChainId,
        proposer: FlowAddress,
        payer: FlowAddress,
        amount: Double = 0.0,
        signers: List<Signer>
    ): String {
        val script = CadenceScriptLoader.load("create_coa", "common/evm")
        val amountArg = Cadence.ufix64(amount)
        
        val latestBlock = BlocksApi(baseUrl).getBlock()
        
        val transaction = Transaction(
            script = script,
            arguments = listOf(amountArg),
            referenceBlockId = latestBlock.header.id,
            gasLimit = 1000.toBigInteger(),
            payer = payer.bytes.toString(),
            proposalKey = ProposalKey(
                address = proposer.bytes.toString(),
                keyIndex = 0,
                sequenceNumber = BigInteger.ZERO
            ),
            authorizers = listOf(proposer.bytes.toString())
        )

        val signedTransaction = transaction.sign(signers)
        val result = sendTransaction(signedTransaction)
        return result.id ?: throw RuntimeException("Transaction ID is null")
    }
}
