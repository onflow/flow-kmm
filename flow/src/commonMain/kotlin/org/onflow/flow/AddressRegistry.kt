package org.onflow.flow

import kotlinx.serialization.json.Json
import org.onflow.flow.models.FlowAddress

class AddressRegistry {

    companion object {
        const val FUNGIBLE_TOKEN = "0xFUNGIBLETOKEN"
        const val FLOW_TOKEN = "0xFLOWTOKEN"
        const val FLOW_FEES = "0xFLOWFEES"
        const val FLOW_TABLE_STAKING = "0xFLOWTABLESTAKING"
        const val LOCKED_TOKENS = "0xLOCKEDTOKENS"
        const val STAKING_PROXY = "0xSTAKINGPROXY"
        const val NON_FUNGIBLE_TOKEN = "0xNONFUNGIBLETOKEN"
        const val NFT_STOREFRONT = "0xNFTSTOREFRONT"
        const val TOKEN_FORWARDING = "0xTOKENFORWARDING"
        const val EVM = "0xEVM"
    }

    private val SCRIPT_TOKEN_MAP: MutableMap<String, MutableMap<String, FlowAddress>> = mutableMapOf()

    var defaultChainId = ChainId.Mainnet

    init {
        registerDefaults()
    }

    fun processScript(script: String, chainId: ChainIdProvider = defaultChainId, addresses: Map<String, FlowAddress> = mapOf()): String {
        var ret = script
        SCRIPT_TOKEN_MAP[chainId.id]?.forEach {
            ret = ret.replace(it.key, it.value.formatted)
        }
        addresses.forEach {
            ret = ret.replace(it.key, it.value.formatted)
        }
        return ret
    }

    fun addressOf(contract: String, chainId: ChainIdProvider = defaultChainId): FlowAddress? = SCRIPT_TOKEN_MAP[chainId.id]?.get(contract)

    fun register(contract: String, address: FlowAddress, chainId: ChainIdProvider = defaultChainId): AddressRegistry {
        if (SCRIPT_TOKEN_MAP[chainId.id] == null) {
            SCRIPT_TOKEN_MAP[chainId.id] = mutableMapOf()
        }
        SCRIPT_TOKEN_MAP[chainId.id]?.set(contract, address)
        return this
    }

    fun register(jsonString: String): AddressRegistry {
        val model = Json.decodeFromString<MutableMap<String, MutableMap<String, String>>>(jsonString)
        model.forEach { chain ->
            ChainId.fromString(chain.key)?.let { chainId ->
                chain.value.forEach {
                    register(it.key, FlowAddress(it.value), chainId)
                }
            }
        }
        return this
    }
    fun deregister(contract: String, chainId: ChainIdProvider): AddressRegistry {
        SCRIPT_TOKEN_MAP[chainId.id]?.remove(contract)
        return this
    }

    fun clear(): AddressRegistry {
        SCRIPT_TOKEN_MAP.clear()
        return this
    }

    fun registerDefaults(): AddressRegistry {
        mapOf(
            ChainId.Emulator to mutableMapOf(
                FUNGIBLE_TOKEN to FlowAddress("0xee82856bf20e2aa6"),
                FLOW_TOKEN to FlowAddress("0x0ae53cb6e3f42a79"),
                FLOW_FEES to FlowAddress("0xe5a8b7f23e8b548f")
            ),
            ChainId.Testnet to mutableMapOf(
                FUNGIBLE_TOKEN to FlowAddress("0x9a0766d93b6608b7"),
                FLOW_TOKEN to FlowAddress("0x7e60df042a9c0868"),
                FLOW_FEES to FlowAddress("0x912d5440f7e3769e"),
                FLOW_TABLE_STAKING to FlowAddress("0x9eca2b38b18b5dfe"),
                LOCKED_TOKENS to FlowAddress("0x95e019a17d0e23d7"),
                STAKING_PROXY to FlowAddress("0x7aad92e5a0715d21"),
                NON_FUNGIBLE_TOKEN to FlowAddress("0x631e88ae7f1d7c20"),
                NFT_STOREFRONT to FlowAddress("0x94b06cfca1d8a476"),
                EVM to FlowAddress("0x8c5303eaa26202d6")
            ),
            ChainId.Mainnet to mutableMapOf(
                FUNGIBLE_TOKEN to FlowAddress("0xf233dcee88fe0abe"),
                FLOW_TOKEN to FlowAddress("0x1654653399040a61"),
                FLOW_FEES to FlowAddress("0xf919ee77447b7497"),
                FLOW_TABLE_STAKING to FlowAddress("0x8624b52f9ddcd04a"),
                LOCKED_TOKENS to FlowAddress("0x8d0e87b65159ae63"),
                STAKING_PROXY to FlowAddress("0x62430cf28c26d095"),
                NON_FUNGIBLE_TOKEN to FlowAddress("0x1d7e57aa55817448"),
                NFT_STOREFRONT to FlowAddress("0x4eb8a10cb9f87357"),
                TOKEN_FORWARDING to FlowAddress("0xe544175ee0461c4b"),
                EVM to FlowAddress("0xe467b9dd11fa00df")
            ),
        ).forEach { chain ->
            chain.value.forEach {
                register(it.key, it.value, chain.key)
            }
        }
        return this
    }
}
