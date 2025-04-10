package org.onflow.flow.infrastructure.scripts

import java.io.InputStreamReader

internal actual fun loadResource(path: String): String {
    val resourcePath = "scripts/$path.cdc"
    val inputStream = CadenceLoader::class.java.classLoader?.getResourceAsStream(resourcePath)
        ?: throw RuntimeException("Resource not found: $resourcePath")
    
    return InputStreamReader(inputStream).use { reader ->
        reader.readText()
    }
}

