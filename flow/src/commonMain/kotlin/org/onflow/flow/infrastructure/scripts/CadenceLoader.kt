package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

/**
 * Interface for defining Cadence script paths
 */
interface CadenceLoaderProtocol {
    val directory: String
    val filename: String
}

/**
 * Base class for loading Cadence scripts from resources
 */
expect class CadenceLoader(chainId: ChainId) {
    /**
     * Load a Cadence script from resources and resolve contract addresses
     * @param path Path to the script in resources
     * @return The script content with resolved addresses
     */
    open fun loadScript(path: String): String
}

/**
 * Platform-specific implementation for loading resources
 */
internal expect fun loadResource(path: String): String

/**
 * Utility class for loading Cadence scripts from files
 */
class CadenceScriptLoader {
    companion object {
        private val loader = CadenceLoader(ChainId.Testnet)

        /**
         * Load a Cadence script from the resources
         * @param name Name of the Cadence file without extension
         * @param directory Directory containing the Cadence file
         * @return Content of the Cadence file
         * @throws Exception if file cannot be found or read
         */
        fun load(name: String, directory: String = ""): String {
            val resourcePath = buildResourcePath(name, directory)
            try {
                val script = loader.loadScript(resourcePath)
                return script
            } catch (e: Exception) {
                println("Error loading script from path: $resourcePath")
                throw e
            }
        }

        /**
         * Load a Cadence script using a CadenceLoaderProtocol
         * @param path CadenceLoaderProtocol implementation defining the script path
         * @return Content of the Cadence file
         * @throws Exception if file cannot be found or read
         */
        fun load(path: CadenceLoaderProtocol): String {
            return load(path.filename, path.directory)
        }

        private fun buildResourcePath(name: String, directory: String): String {
            val path = StringBuilder()
            // Start with the base scripts directory
            path.append("scripts/")
            // Add the directory if provided
            if (directory.isNotEmpty()) {
                path.append("$directory/")
            }
            // Add the filename
            path.append(name)
            val fullPath = path.toString()
            return fullPath
        }
    }
}