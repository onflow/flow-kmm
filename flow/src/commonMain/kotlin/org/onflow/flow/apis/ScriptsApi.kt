package org.onflow.flow.apis
import org.onflow.flow.infrastructure.*
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.decodeBase64String
import io.ktor.util.encodeBase64
import kotlinx.serialization.json.Json
import org.onflow.flow.models.ScriptsPostRequest
import org.onflow.flow.models.BlockStatus
import org.onflow.flow.models.ScriptsErrorResponse

class ScriptsApi(val baseUrl: String) : ApiBase() {

    private suspend fun request(
        scriptsPostRequest: ScriptsPostRequest,
        blockId: String? = null,
        blockHeight: String? = null,
        blockStatus: BlockStatus? = null
    ): Pair<HttpStatusCode, String> {

        val queryParams = mutableMapOf<String, List<String>>()
        blockId?.apply { queryParams["block_id"] = listOf("$blockId") }
        blockHeight?.apply { queryParams["block_height"] = listOf("$blockHeight") }
        blockStatus?.apply { queryParams["block_status"] = listOf("$blockStatus") }

        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"

        val response = client.post("$baseUrl/scripts") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
            headers {
                headers.forEach { header ->
                    append(header.key, header.value)
                }
            }
            setBody(scriptsPostRequest)
        }

        if (response.status == HttpStatusCode.OK) {
            return Pair(response.status, response.bodyAsText().replace("\"", "").decodeBase64String())
        }

        return Pair(response.status, response.bodyAsText())
    }

    internal suspend fun executeScript(
        script: String,
        arguments: List<Cadence.Value>? = null,
        blockId: String? = null,
        blockHeight: String? = null,
        blockStatus: BlockStatus = BlockStatus.FINAL
    ): Cadence.Value {
        val request = ScriptsPostRequest(
            script.encodeBase64(),
            arguments?.map { it.encodeBase64() })
        val response = if (blockId != null) {
            request(request, blockId = blockId, blockStatus = blockStatus)
        } else if (blockHeight != null) {
            request(request, blockHeight = blockHeight, blockStatus = blockStatus)
        } else {
            request(request, blockStatus = blockStatus)
        }

        if (response.first != HttpStatusCode.OK) {
            ScriptsErrorResponse.serializer()
            val error = Json.decodeFromString(ScriptsErrorResponse.serializer(), response.second)
            throw Exception(error.message)
        }

        return Cadence.Value.decodeFromJson(response.second)
    }
}
