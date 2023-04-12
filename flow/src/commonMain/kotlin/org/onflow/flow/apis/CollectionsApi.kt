package org.onflow.flow.apis

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.Collection

internal class CollectionsApi(val baseUrl: String) : ApiBase() {

    private suspend fun request(id: String, expand: Set<String>? = null): Collection {

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/collections/$id") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    /**
     * Gets a Collection by ID
     * Get a collection by provided collection ID.
     * @param id The collection ID.
     * @return Collection
     */
    internal suspend fun getCollection(id: String): Collection {
        val expand = setOf("transactions")
        return request(id, expand)
    }


}
