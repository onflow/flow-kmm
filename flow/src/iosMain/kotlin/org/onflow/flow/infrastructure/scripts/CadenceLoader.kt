package org.onflow.flow.infrastructure.scripts

import org.onflow.flow.ChainId

actual class CadenceLoader actual constructor(chainId: ChainId) {
    actual fun loadScript(path: String): String {
        return "Not yet implemented"
    }
}

internal actual fun loadResource(path: String): String {
    return "Not yet implemented"
} 