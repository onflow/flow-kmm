package org.onflow.flow.cadence

import kotlinx.serialization.Serializable
import org.onflow.flow.FlowApi
import org.onflow.flow.ChainId
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.decode
import org.onflow.flow.infrastructure.scripts.CadenceScriptLoader
import org.onflow.flow.models.FlowAddress

@Serializable
data class ChildAccountThumbnail(
    val url: String? = null
)

@Serializable
data class ChildAccountMetadata(
    val name: String? = null,
    val description: String? = null,
    val address: String? = null,
    val thumbnail: ChildAccountThumbnail? = null
)

@Serializable
data class StakingNode(
    val id: Int,
    val nodeID: String,
    val tokensCommitted: Double,
    val tokensStaked: Double,
    val tokensUnstaking: Double,
    val tokensRewarded: Double,
    val tokensUnstaked: Double,
    val tokensRequestedToUnstake: Double
) {
    val stakingCount: Double
        get() = tokensCommitted + tokensStaked
}

suspend fun FlowApi.getChildAddresses(parent: FlowAddress): List<String> {
    val script = CadenceScriptLoader(requireChainId()).load("get_child_addresses", "common/child")
    val result = executeScript(
        script = script,
        arguments = listOf(Cadence.address(parent.base16Value))
    )
    return result.decode()
}

suspend fun FlowApi.getChildAccountMetadata(parent: FlowAddress): Map<String, ChildAccountMetadata> {
    val script = CadenceScriptLoader(requireChainId()).load("get_child_account_meta", "common/child")
    val result = executeScript(
        script = script,
        arguments = listOf(Cadence.address(parent.base16Value))
    )

    val decodedMapWithNulls = result.decode<Map<String, ChildAccountMetadata?>>()
    return decodedMapWithNulls
        .filterValues { it != null }
        .map { (key, value) ->
            key to value!!.copy(address = value.address ?: key)
        }
        .toMap()
}

suspend fun FlowApi.getTokenBalances(address: FlowAddress): Map<String, Double> {
    val script = CadenceScriptLoader(requireChainId()).load("get_token_balance_storage", "common/token")
    val result = executeScript(
        script = script,
        arguments = listOf(Cadence.address(address.base16Value))
    )
    return result.decode()
}

suspend fun FlowApi.getDelegatorInfo(address: FlowAddress): List<StakingNode>? {
    val script = CadenceScriptLoader(requireChainId()).load("get_delegator_info", "common/staking")
    val result = executeScript(
        script = script,
        arguments = listOf(Cadence.address(address.base16Value))
    )
    return result.decode()
}

private fun FlowApi.requireChainId(): ChainId =
    (chainId as? ChainId) ?: throw IllegalArgumentException("Cadence script loading requires ChainId")
