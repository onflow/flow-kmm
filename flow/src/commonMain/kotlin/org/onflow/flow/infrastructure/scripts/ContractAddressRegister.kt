package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

/**
 * Contract Address Register manages the mapping of contract names to their addresses
 * for different Flow networks (mainnet, testnet)
 */
expect class ContractAddressRegister {
    /**
     * Contract addresses for each network
     */
    val addresses: MutableMap<ChainId, MutableMap<String, String>>
    
    /**
     * Import addresses for a specific network from a dictionary
     */
    fun importAddresses(network: ChainId, dict: Map<String, String>)

    /**
     * Import addresses for a specific network from a JSON string
     */
    fun importAddresses(network: ChainId, json: String)
    
    /**
     * Get contract address for the specified network
     * @param contract Contract name with 0x prefix (e.g., "0xFlowToken")
     * @param network Network name ("mainnet" or "testnet")
     * @return Contract address if found, null otherwise
     */
    fun getAddress(contract: String, network: ChainId): String?
    
    /**
     * Get all contract addresses for a network
     * @param network Network name ("mainnet" or "testnet")
     * @return Map of contract names to addresses
     */
    fun getAddresses(network: ChainId): Map<String, String>
    
    /**
     * Check if a contract exists on a network
     * @param contract Contract name with 0x prefix
     * @param network Network name
     * @return True if contract exists on the network
     */
    fun contractExists(contract: String, network: ChainId): Boolean
    
    /**
     * Get all available networks
     * @return List of network names
     */
    fun getNetworks(): List<ChainId>
    
    /**
     * Replace 0x placeholders in Cadence code with actual addresses
     * @param code Cadence code with 0x placeholders
     * @param network Network to use for address resolution
     * @return Code with resolved addresses
     */
    fun resolveImports(code: String, network: ChainId): String
} 