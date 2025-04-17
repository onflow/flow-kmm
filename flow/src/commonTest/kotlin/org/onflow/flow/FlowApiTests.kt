package org.onflow.flow

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import org.onflow.flow.apis.ScriptsApi
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.scripts.CadenceScriptLoader
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FlowApiTests {

    private val api = FlowApi(ChainId.Testnet)
    private val format = Cadence.Type.jsonSerializer

    @Test
    fun testGetAccount() {
        runBlocking {
            val account = api.getAccount("0x328649a25184b171")
            println(format.encodeToString(account))
            assertEquals("328649a25184b171", account.address)
            assertTrue(true == account.keys?.isNotEmpty())
        }
    }

    @Test
    fun testGetBlock() {
        runBlocking {
            val block = api.getBlock()
            println(format.encodeToString(block))
            assertTrue(block.header.id.isNotEmpty())
        }
    }

    @Test
    fun testRunScript() {
        runBlocking {
            val response = api.executeScript("""
                access(all) fun main(name: String): String {
                    let greeting = "Hello, "
                    return greeting.concat(name)
                }
            """.trimIndent(),
                listOf(Cadence.string("Ryan"))
            )
            println(format.encodeToString(response))
            val result = response.decode<String>()
            assertTrue(result == "Hello, Ryan")
        }
    }

    @Test
    fun testGetEVMAddress() {
        runBlocking {
            val script = CadenceScriptLoader.load("get_addr", "common/evm")
            val response = api.executeScript(script, listOf(Cadence.address("0xcfa16944c93058bf")))
            val evmAddress = response.decode<String>()
            println("EVM Address: $evmAddress")
            assertEquals("0000000000000000000000029e7fe89acde8be4a", evmAddress)
        }
    }

    @Test
    fun testGetChildAccountMetadata() {
        runBlocking {
            val script = CadenceScriptLoader.load("get_child_account_meta", "common/evm")
            val response = api.executeScript(script, listOf(Cadence.address("0xcfa16944c93058bf")))
            val metadata = response.decode<Map<String, ScriptsApi.ChildAccountMetadata>>()
            // Verify the metadata structure
            metadata.forEach { (key, value) ->
                assertTrue(key.isNotEmpty())
                // Check that the metadata object has the expected fields
                assertTrue(value.name == null || value.name is String)
                assertTrue(value.description == null || value.description is String)
                assertTrue(value.thumbnail == null || value.thumbnail is ScriptsApi.Thumbnail)
                value.thumbnail?.let { thumbnail ->
                    assertTrue(thumbnail.url == null || thumbnail.url is String)
                }
            }
        }
    }
}