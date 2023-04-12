package org.onflow.flow.apis

import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onflow.flow.models.BlockEvents

internal class EventsApi(val baseUrl: String) : ApiBase() {

    private suspend fun request(
        type: String,
        startHeight: String? = null,
        endHeight: String? = null,
        blockIds: Set<String>? = null,
        select: Set<String>? = null
    ): BlockEvents {

        val queryParams = mutableMapOf<String, List<String>>()
        type.apply { queryParams["type"] = listOf("$type") }
        startHeight?.apply { queryParams["start_height"] = listOf("$startHeight") }
        endHeight?.apply { queryParams["end_height"] = listOf("$endHeight") }
        blockIds?.apply { queryParams["block_ids"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/events") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    internal suspend fun getEvents(
        type: String,
        startHeight: String? = null,
        endHeight: String? = null,
        blockIds: Set<String>? = null
    ): BlockEvents {

        require((startHeight != null) || (blockIds != null && blockIds.isNotEmpty())) {
            "Either a block height range, or blockIDs must be specified."
        }

        return if (startHeight != null) {
            request(type, startHeight, endHeight)
        } else {
            request(type, blockIds = blockIds)
        }
    }


}
