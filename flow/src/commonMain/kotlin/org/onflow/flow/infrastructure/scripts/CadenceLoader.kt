package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

/**
 * Implement this interface to refer to a Cadence file by (directory, filename)
 * instead of two plain strings.
 */
interface CadenceLoaderProtocol {
    val directory: String
    val filename: String
}

/**
 * Expect/actual loader provided by each platform (JVM, Android, JS, …).
 * It replaces `import 0x…` addresses with chain-specific contracts.
 */
expect class CadenceLoader(chainId: ChainId) {
    /**
     * Reads the file at [path] from the JAR / APK resources and injects the
     * correct contract addresses for the given [chainId].
     */
    fun loadScript(path: String): String
}

/** Platform-specific resource reader used by the platform `CadenceLoader`. */
internal expect fun loadResource(path: String): String

/**
 * Loads Cadence scripts for a **single** Flow network.
 *
 * Create **one instance per network** and reuse it:
 *
 * ```kotlin
 * val mainnet = CadenceScriptLoader(ChainId.Mainnet)
 * val testnet = CadenceScriptLoader(ChainId.Testnet)
 *
 * val code = mainnet.load("get_total_supply.cdc", "fungibleToken")
 * ```
 */
class CadenceScriptLoader(chainId: ChainId) {

    private val loader = CadenceLoader(chainId)

    /** Load `resources/scripts[/directory]/name` (file name **without** .cdc). */
    fun load(name: String, directory: String = ""): String =
        loader.loadScript(buildResourcePath(name, directory))

    /** Overload that accepts a strongly-typed [CadenceLoaderProtocol]. */
    fun load(path: CadenceLoaderProtocol): String =
        load(path.filename, path.directory)

    private fun buildResourcePath(name: String, directory: String): String =
        buildString {
            append("scripts/")
            if (directory.isNotEmpty()) append("$directory/")
            append(name)
        }
}

