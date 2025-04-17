package org.onflow.flow.infrastructure.scripts

import kotlinx.serialization.json.Json
import org.onflow.flow.ChainId

/**
 * Android implementation of ContractAddressRegister
 */
actual class ContractAddressRegister {
    
    /**
     * Contract addresses for each network
     */
    actual val addresses: MutableMap<ChainId, MutableMap<String, String>> = mutableMapOf()
    
    /**
     * Initialize with contract addresses from JSON
     */
    init {
        val stream = javaClass.classLoader?.getResourceAsStream("scripts/common/addresses.json")
        if (stream != null) {
            try {
                val jsonString = stream.bufferedReader().use { it.readText() }
                val jsonDict = Json.decodeFromString<Map<String, Map<String, String>>>(jsonString)

                for ((networkStr, contractAddresses) in jsonDict) {
                    val network = when (networkStr.lowercase()) {
                        "mainnet" -> ChainId.Mainnet
                        "testnet" -> ChainId.Testnet
                        else -> null
                    }

                    if (network != null) {
                        addresses[network] = contractAddresses.mapKeys { it.key.removePrefix("0x") }.toMutableMap()
                    } else {
                        println("Warning: Invalid network name: $networkStr")
                    }
                }
            } catch (e: Exception) {
                println("Error parsing addresses.json: ${e.message}")
            }
        } else {
            println("Could not load addresses.json")
        }
    }

    actual fun importAddresses(network: ChainId, dict: Map<String, String>) {
        addresses.getOrPut(network) { mutableMapOf() }.putAll(dict)
    }

    actual fun importAddresses(network: ChainId, json: String) {
        try {
            val dict = Json.decodeFromString<Map<String, String>>(json)
            importAddresses(network, dict)
        } catch (e: Exception) {
            println("Warning: Could not decode JSON string: ${e.message}")
        }
    }
    
    actual fun getAddress(contract: String, network: ChainId): String? {
        return addresses[network]?.get(contract)
    }
    
    actual fun getAddresses(network: ChainId): Map<String, String> {
        return addresses[network] ?: emptyMap()
    }
    
    actual fun contractExists(contract: String, network: ChainId): Boolean {
        return getAddress(contract, network) != null
    }
    
    actual fun getNetworks(): List<ChainId> {
        return addresses.keys.toList()
    }
    
    actual fun resolveImports(code: String, network: ChainId): String {
        var result = code
        getAddresses(network).forEach { (contract, address) ->
            result = result.replace("0x$contract", address)
        }
        return result
    }
}