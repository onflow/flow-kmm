package org.onflow.flow.apis

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onflow.flow.infrastructure.ApiBase
import org.onflow.flow.infrastructure.toMultiValue
import org.onflow.flow.models.Account
import org.onflow.flow.models.BlockStatus

internal class AccountsApi(val baseUrl: String) : ApiBase() {

    private suspend fun request(
        address: String,
        blockHeight: String? = null,
        expand: Set<String>? = null
    ): Account {

        val queryParams = mutableMapOf<String, List<String>>()
        blockHeight?.apply { queryParams["block_height"] = listOf("$blockHeight") }
        expand?.apply { queryParams["expand"] = toMultiValue(this, "csv") }

        return client.get("$baseUrl/accounts/$address") {
            queryParams.forEach { queryParam ->
                queryParam.value.forEach { value ->
                    parameter(queryParam.key, value)
                }
            }
        }.body()
    }

    /**
     * Get an Account By Address
     * Get an account data by provided address in latest block with specified status or by provided block height.
     * @param address The address of the account.
     * @param blockHeight The block height to query for the account details. If not provided, uses the latest block with specified status.
     * @param blockStatus The status of the block to query (FINAL or SEALED). Defaults to FINAL.
     * @return Account
     */
    internal suspend fun getAccount(address: String, blockHeight: String? = null, blockStatus: BlockStatus = BlockStatus.FINAL): Account {
        val expand = setOf("contracts", "keys")
        return if (blockHeight != null) {
            request(address, blockHeight, expand)
        } else {
            request(address, blockStatus.value, expand)
        }
    }

}
