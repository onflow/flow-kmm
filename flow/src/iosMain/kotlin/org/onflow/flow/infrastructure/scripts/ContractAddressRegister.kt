package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

actual class ContractAddressRegister {
    actual val addresses: MutableMap<ChainId, MutableMap<String, String>> = mutableMapOf()

    actual fun importAddresses(network: ChainId, dict: Map<String, String>) {
        // Dummy implementation - do nothing
    }

    actual fun importAddresses(network: ChainId, json: String) {
        // Dummy implementation - do nothing
    }

    actual fun getAddress(contract: String, network: ChainId): String? {
        // Dummy implementation - return null
        return null
    }

    actual fun getAddresses(network: ChainId): Map<String, String> {
        // Dummy implementation - return empty map
        return emptyMap()
    }

    actual fun contractExists(contract: String, network: ChainId): Boolean {
        // Dummy implementation - return false
        return false
    }

    actual fun getNetworks(): List<ChainId> {
        // Dummy implementation - return empty list
        return emptyList()
    }

    actual fun resolveImports(code: String, network: ChainId): String {
        // Dummy implementation - return input code as is
        return code
    }
} 