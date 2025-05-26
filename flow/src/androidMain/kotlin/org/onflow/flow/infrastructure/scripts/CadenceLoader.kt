package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId
import org.onflow.flow.infrastructure.ResourceLoader

/**
 * Android implementation of CadenceLoader
 */
actual class CadenceLoader actual constructor(
    private val chainId: ChainId
) {
    private val addressRegister = ContractAddressRegister()

    /**
     * Load a Cadence script from resources and resolve contract addresses
     * @param path Path to the script in resources
     * @return The script content with resolved addresses
     */
    actual fun loadScript(path: String): String {
        val rawScript = loadResource(path)
        return addressRegister.resolveImports(rawScript, chainId)
    }
}

/**
 * Android implementation of resource loading
 */
internal actual fun loadResource(path: String): String {
    val content = ResourceLoader.loadResource("$path.cdc")
    return content ?: throw RuntimeException("Resource not found: $path")
}
