package org.onflow.flow.infrastructure

internal actual object ResourceLoader {
    actual fun loadResource(path: String): String? {
        val pathsToTry = listOf(
            path,
            "commonMain/$path"
        )

        for (tryPath in pathsToTry) {
            println("Trying to load from path: $tryPath")
            val inputStream = javaClass.classLoader.getResourceAsStream(tryPath)
            if (inputStream != null) {
                return inputStream.bufferedReader().use { it.readText() }
            }
        }
        return null
    }
}