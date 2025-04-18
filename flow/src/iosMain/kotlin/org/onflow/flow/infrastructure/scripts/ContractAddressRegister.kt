package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

actual class ContractAddressRegister {
    actual val addresses: MutableMap<ChainId, MutableMap<String, String>> = mutableMapOf()

    actual fun importAddresses(network: ChainId, dict: Map<String, String>) {
    }

    actual fun importAddresses(network: ChainId, json: String) {
    }

    actual fun getAddress(contract: String, network: ChainId): String? {
        return null
    }

    actual fun getAddresses(network: ChainId): Map<String, String> {
        return emptyMap()
    }

    actual fun contractExists(contract: String, network: ChainId): Boolean {
        return false
    }

    actual fun getNetworks(): List<ChainId> {
        return emptyList()
    }

    actual fun resolveImports(code: String, network: ChainId): String {
        return code
    }
} 