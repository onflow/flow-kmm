package org.onflow.flow

interface ChainIdProvider {
    val baseUrl: String
    val description: String
}

sealed class ChainId: ChainIdProvider {
    object Mainnet: ChainId() {
        override val baseUrl: String = "https://rest-mainnet.onflow.org/v1"
        override val description: String = "Flow Mainnet"
    }

    object Testnet: ChainId() {
        override val baseUrl: String = "https://rest-testnet.onflow.org/v1"
        override val description: String = "Flow Testnet"
    }

    object Canary: ChainId() {
        override val baseUrl: String = "https://rest-canary.onflow.org/v1"
        override val description: String = "Flow Canary"
    }

    object Emulator: ChainId() {
        override val baseUrl: String = "http://localhost:8888/v1"
        override val description: String = "Flow Emulator"
    }

    data class Custom(
        override val baseUrl: String,
        override val description: String
        ): ChainId()
}