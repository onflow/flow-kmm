package org.onflow.flow.apis
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.ExecutionResult

internal class ExecutionResultsApi(val baseUrl: String) : ApiBase() {

    private suspend fun requestResults(blockId: Set<String>): List<ExecutionResult> {

        val queryParams = mutableMapOf<String, List<String>>()
        blockId.apply { queryParams["block_id"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/execution_results") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    private suspend fun requestResult(id: String): ExecutionResult {
        return client.get("$baseUrl/execution_results/$id").body()
    }

    internal suspend fun getExecutionResult(id: String): ExecutionResult {
        return requestResult(id)
    }

    internal suspend fun getExecutionResults(blockId: Set<String>): List<ExecutionResult> {
        return requestResults(blockId)
    }


}
