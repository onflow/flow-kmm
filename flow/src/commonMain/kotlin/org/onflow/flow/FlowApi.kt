package org.onflow.flow

import org.onflow.flow.apis.AccountsApi
import org.onflow.flow.apis.BlocksApi
import org.onflow.flow.apis.CollectionsApi
import org.onflow.flow.apis.EventsApi
import org.onflow.flow.apis.ExecutionResultsApi
import org.onflow.flow.apis.ScriptsApi
import org.onflow.flow.apis.TransactionsApi
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.Account
import org.onflow.flow.models.Block
import org.onflow.flow.models.BlockEvents
import org.onflow.flow.models.BlockHeader
import org.onflow.flow.models.BlockStatus
import org.onflow.flow.models.Collection
import org.onflow.flow.models.ExecutionResult
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionResult

class FlowApi(val chainId: ChainIdProvider) {

    private val baseUrl = chainId.baseUrl
    private val accountsApi = AccountsApi(baseUrl)
    private val blocksApi = BlocksApi(baseUrl)
    private val collectionsApi = CollectionsApi(baseUrl)
    private val eventsApi = EventsApi(baseUrl)
    private val executionResultsApi = ExecutionResultsApi(baseUrl)
    private val scriptsApi = ScriptsApi(baseUrl)
    private val transactionsApi = TransactionsApi(baseUrl)

    suspend fun getAccount(address: String, blockHeight: String? = null, blockStatus: BlockStatus = BlockStatus.FINAL): Account {
        return accountsApi.getAccount(address, blockHeight, blockStatus)
    }

    suspend fun getBlock(id: String? = null, blockHeight: String? = null, blockStatus: BlockStatus = BlockStatus.FINAL): Block {
        return blocksApi.getBlock(id, blockHeight, blockStatus)
    }

    suspend fun getBlockHeader(
        id: String? = null,
        blockHeight: String? = null,
        blockStatus: BlockStatus = BlockStatus.FINAL
    ): BlockHeader {
        return blocksApi.getBlockHeader(id, blockHeight, blockStatus)
    }

    suspend fun getCollection(id: String): Collection {
        return collectionsApi.getCollection(id)
    }

    suspend fun getEvents(
        type: String,
        startHeight: String? = null,
        endHeight: String? = null,
        blockIds: Set<String>? = null
    ): BlockEvents {
        return eventsApi.getEvents(type, startHeight, endHeight, blockIds)
    }

    suspend fun getExecutionResult(id: String): ExecutionResult {
        return executionResultsApi.getExecutionResult(id)
    }

    suspend fun getExecutionResults(blockId: Set<String>): List<ExecutionResult> {
        return executionResultsApi.getExecutionResults(blockId)
    }

    suspend fun executeScript(
        script: String,
        arguments: List<Cadence.Value>? = null,
        blockId: String? = null,
        blockHeight: String? = null
    ): Cadence.Value {
        return scriptsApi.executeScript(script, arguments, blockId, blockHeight)
    }

    suspend fun getTransactionResult(transactionId: String): TransactionResult {
        return transactionsApi.getTransactionResult(transactionId)
    }

    suspend fun getTransaction(transactionId: String): Transaction {
        return transactionsApi.getTransaction(transactionId)
    }

    suspend fun sendTransaction(request: Transaction): Transaction {
        return transactionsApi.sendTransaction(request)
    }

    suspend fun waitForSeal(transactionId: String): TransactionResult {
        return transactionsApi.waitForSeal(transactionId)
    }
}