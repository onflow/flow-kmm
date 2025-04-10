package org.onflow.flow.infrastructure.scripts

/**
 * Interface for defining Cadence script paths
 */
interface CadenceLoaderProtocol {
    val directory: String
    val filename: String
}

/**
 * Platform-specific implementation for loading resources
 */
internal expect fun loadResource(path: String): String

/**
 * Utility class for loading Cadence scripts from files
 */
class CadenceLoader {
    companion object {
        private const val SUBDIRECTORY = "scripts"
        private const val FILE_EXTENSION = "cdc"

        /**
         * Load a Cadence script from the resources
         * @param name Name of the Cadence file without extension
         * @param directory Directory containing the Cadence file
         * @return Content of the Cadence file
         * @throws Exception if file cannot be found or read
         */
        fun load(name: String, directory: String = ""): String {
            val resourcePath = buildResourcePath(name, directory)
            return loadResource(resourcePath)
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
            val path = StringBuilder("/$SUBDIRECTORY")
            if (directory.isNotEmpty()) {
                path.append("/$directory")
            }
            path.append("/$name.$FILE_EXTENSION")
            return path.toString()
        }
    }
}