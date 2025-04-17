package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

actual class CadenceLoader actual constructor(chainId: ChainId) {
    actual fun loadScript(path: String): String {
        // Dummy implementation that returns an empty string
        return ""
    }
}

internal actual fun loadResource(path: String): String {
    // Dummy implementation that returns an empty string
    return ""
} 