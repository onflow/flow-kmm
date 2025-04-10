package org.onflow.flow.infrastructure.scripts

import android.content.Context
import java.io.InputStreamReader

internal actual fun loadResource(path: String): String {
    val context = FlowContextProvider.getContext()
    return context.assets.open(path).use { inputStream ->
        InputStreamReader(inputStream).use { reader ->
            reader.readText()
        }
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