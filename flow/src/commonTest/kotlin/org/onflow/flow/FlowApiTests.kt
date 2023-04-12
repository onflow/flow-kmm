package org.onflow.flow

import org.onflow.flow.cadence.TestStruct
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.toJsonElement
import kotlinx.serialization.Serializable
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FlowApiTests {

    private val api = FlowApi(ChainId.Testnet)
    private val format = Json { prettyPrint = true }

    @Test
    @Ignore
    fun testGetAccount() {
        runBlocking {
            val account = api.getAccount("0x328649a25184b171")
            println(format.encodeToString(account))
            assertEquals("328649a25184b171", account.address)
            assertTrue(true == account.keys?.isNotEmpty())
        }
    }

    @Test
    @Ignore
    fun testGetBlock() {
        runBlocking {
            val block = api.getBlock()
            println(format.encodeToString(block))
            assertTrue(block.header.id.isNotEmpty())
        }
    }

    @Test
    @Ignore
    fun testRunScript() {
        runBlocking {
            val response = api.executeScript("""
                pub fun main(name: String): String {
                    let greeting = "Hello, "
                    return greeting.concat(name)
                }
            """.trimIndent(), listOf(Cadence.string("Ryan")))
            println(format.encodeToString(response))
            val result = response.decode<String>()
            assertTrue(result == "Hello, Ryan")
        }
    }
}