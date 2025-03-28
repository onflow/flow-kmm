package org.onflow.flow

interface ChainIdProvider {
    val id: String
    val baseUrl: String
    val description: String
}

sealed class ChainId: ChainIdProvider {
    object Mainnet: ChainId() {
        override val id: String = "flow-mainnet"
        override val baseUrl: String = "https://rest-mainnet.onflow.org/v1"
        override val description: String = "Flow Mainnet"
    }

    object Testnet: ChainId() {
        override val id: String = "flow-testnet"
        override val baseUrl: String = "https://rest-testnet.onflow.org/v1"
        override val description: String = "Flow Testnet"
    }

    object Canary: ChainId() {
        override val id: String = "flow-canarynet"
        override val baseUrl: String = "https://rest-canary.onflow.org/v1"
        override val description: String = "Flow Canary"
    }

    object Emulator: ChainId() {
        override val id: String = "flow-emulator"
        override val baseUrl: String = "http://localhost:8888/v1"
        override val description: String = "Flow Emulator"
    }

    data class Custom(
        override val id: String = "custom",
        override val baseUrl: String,
        override val description: String
        ): ChainId()

    companion object {
        fun fromString(chainId: String): ChainId? {
            return when (chainId) {
                "mainnet" -> Mainnet
                "testnet" -> Testnet
                "canary" -> Canary
                "emulator" -> Emulator
                else -> null
            }
        }
    }
}