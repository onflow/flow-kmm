package org.onflow.flow.infrastructure.scripts

import java.io.InputStreamReader

internal actual fun loadResource(path: String): String {
    val resourcePath = "scripts/$path.cdc"
    val inputStream = javaClass.classLoader?.getResourceAsStream(resourcePath)
        ?: throw RuntimeException("Resource not found: $resourcePath")
    
    return InputStreamReader(inputStream).use { reader ->
        reader.readText()
    }
}

interface ContextProvider {
    fun getContext(): Context
}

object FlowContextProvider {
    private var contextProvider: ContextProvider? = null

    fun initialize(provider: ContextProvider) {
        contextProvider = provider
    }

    fun getContext(): Context {
        return contextProvider?.getContext() 
            ?: throw IllegalStateException("ContextProvider not initialized. Call FlowContextProvider.initialize() first.")
    }
} 