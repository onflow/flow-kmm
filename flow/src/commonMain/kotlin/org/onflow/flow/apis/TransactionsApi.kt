package org.onflow.flow.apis
import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.delay
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

    internal suspend fun createCOAAccount(
        proposer: FlowAddress,
        payer: FlowAddress,
        amount: Double = 0.0,
        signers: List<Signer>
    ): String {
        val script = CadenceScriptLoader.load("create_coa", "common/evm")
        val amountArg = Cadence.ufix64(amount)

        val blocksApi = BlocksApi(baseUrl)
        val accountsApi = AccountsApi(baseUrl)

        val latestBlock = blocksApi.getBlock()

        val proposerAccount = accountsApi.getAccount(proposer.base16Value)
        val payerAccount = accountsApi.getAccount(payer.base16Value)

        // Get first key for each address (assumes it's index 0, or single key setup)
        val proposerKey = proposerAccount.keys!!.firstOrNull { it.index == "0" }
            ?: throw IllegalArgumentException("Proposer has no key at index 0")
        val payerKey = payerAccount.keys!!.firstOrNull { it.index == "0" }
            ?: throw IllegalArgumentException("Payer has no key at index 0")

        // Set keyIndex based on address match (we assume keyIndex=0 here — may change if multi-key)
        signers.forEach { signer ->

            val account = accountsApi.getAccount(signer.address)
            println("On-chain public keys: ${account.keys?.map { it.index to it.publicKey }}")
            println("Signer: ${signer.address} keyIndex=${signer.keyIndex}")

            when (signer.address.lowercase()) {
                proposer.base16Value.lowercase() -> signer.keyIndex = 0
                payer.base16Value.lowercase() -> signer.keyIndex = 0
                else -> throw IllegalArgumentException("Unexpected signer: ${signer.address}")
            }
        }

        val transaction = Transaction(
            script = script,
            arguments = listOf(amountArg),
            referenceBlockId = latestBlock.header.id,
            gasLimit = 9999.toBigInteger(),
            payer = payer.base16Value,
            proposalKey = ProposalKey(
                address = proposer.base16Value,
                keyIndex = 0,
                sequenceNumber = proposerKey.sequenceNumber.toBigInteger()
            ),
            authorizers = listOf(proposer.base16Value),
            payloadSignatures = emptyList(),
            envelopeSignatures = emptyList()
        )

        // Sign payload with proposer only
        val proposerSigner = signers.first { it.address.equals(proposer.base16Value, ignoreCase = true) }
        val payloadSigned = transaction.signPayload(listOf(proposerSigner))

        // Sign envelope with both proposer and payer
        val envelopeSigners = signers.filter {
            it.address.equals(proposer.base16Value, ignoreCase = true) ||
                    it.address.equals(payer.base16Value, ignoreCase = true)
        }
        val envelopeSigned = payloadSigned.signEnvelope(envelopeSigners)

        val payloadSigs = envelopeSigned.payloadSignatures.map { it.address to it.keyIndex }
        val envelopeSigs = envelopeSigned.envelopeSignatures.map { it.address to it.keyIndex }
        println("Payload sigs: $payloadSigs")
        println("Envelope sigs: $envelopeSigs")

        val allSigs = payloadSigs + envelopeSigs
        val duplicates = allSigs.groupBy { it }.filter { it.value.size > 1 }
        println("Duplicates: $duplicates")

        val result = sendTransaction(envelopeSigned)

        return result.id ?: throw RuntimeException("Transaction ID is null")
    }

}
