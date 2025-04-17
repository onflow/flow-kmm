package org.onflow.flow.infrastructure

internal expect object ResourceLoader {
    fun loadResource(path: String): String?
}