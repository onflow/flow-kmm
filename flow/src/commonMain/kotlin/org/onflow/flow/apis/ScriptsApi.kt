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
import org.onflow.flow.models.ScriptsPostRequest
import org.onflow.flow.infrastructure.scripts.CadenceLoader
import org.onflow.flow.models.FlowAddress

internal class ScriptsApi(val baseUrl: String) : ApiBase() {

    private suspend fun request(
        scriptsPostRequest: ScriptsPostRequest,
        blockId: String? = null,
        blockHeight: String? = null
    ): String {

        val queryParams = mutableMapOf<String, List<String>>()
        blockId?.apply { queryParams["block_id"] = listOf("$blockId") }
        blockHeight?.apply { queryParams["block_height"] = listOf("$blockHeight") }

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
            return response.bodyAsText().replace("\"", "").decodeBase64String()
        }

        return response.bodyAsText()
    }

    internal suspend fun executeScript(
        script: String,
        arguments: List<Cadence.Value>? = null,
        blockId: String? = null,
        blockHeight: String? = null
    ): Cadence.Value {
        val request = ScriptsPostRequest(
            script.encodeBase64(),
            arguments?.map { it.encodeBase64() })
        val response = if (blockId != null) {
            request(request, blockId)
        } else if (blockHeight != null) {
            request(request, blockHeight = blockHeight)
        } else {
            request(request, blockHeight = "sealed")
        }

        return Cadence.Value.decodeFromJson(response)
    }

    internal suspend fun getEVMAddress(
        flowAddress: FlowAddress
    ): String? {
        val script = CadenceLoader.load("get_evm_address", "common/evm")
        val result = executeScript(
            script = script,
            arguments = listOf(Cadence.address(flowAddress.bytes.toString()))
        )
        return result.decode<Cadence.Value.StringValue>()?.value
    }
}
