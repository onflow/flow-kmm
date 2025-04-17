package org.onflow.flow.apis

import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.Block
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onflow.flow.models.BlockHeader

internal class BlocksApi(val baseUrl: String) : ApiBase() {

    private suspend fun requestBlocksByHeight(
        height: Set<String>? = null,
        startHeight: String? = null,
        endHeight: String? = null,
        expand: Set<String>? = null,
        select: Set<String>? = null
    ): List<Block> {

        val queryParams = mutableMapOf<String, List<String>>()
        height?.apply { queryParams["height"] = toMultiValue(this, "csv") }
        startHeight?.apply { queryParams["start_height"] = listOf("$startHeight") }
        endHeight?.apply { queryParams["end_height"] = listOf("$endHeight") }
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/blocks") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    private suspend fun requestBlocksById(
        id: String,
        expand: Set<String>? = null,
        select: Set<String>? = null
    ): List<Block> {

        val queryParams = mutableMapOf<String, List<String>>()
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }
        select?.apply { queryParams["select"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/blocks/$id") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    internal suspend fun getBlock(id: String? = null, blockHeight: String? = null, sealed: Boolean = true): Block {
        val expand = setOf("payload")
        return if (id != null) {
            requestBlocksById(id, expand).first()
        } else if (blockHeight != null) {
            requestBlocksByHeight(setOf(blockHeight), expand = expand).first()
        } else {
            val height = if (sealed) "sealed" else "final"
            requestBlocksByHeight(setOf(height), expand = expand).first()
        }
    }

    internal suspend fun getBlockHeader(
        id: String? = null,
        blockHeight: String? = null,
        sealed: Boolean = true
    ): BlockHeader {
        return getBlock(id, blockHeight, sealed).header
    }

}
