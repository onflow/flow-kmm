package org.onflow.flow

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.BlockStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertNotNull
import kotlin.test.assertFailsWith

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
    fun testGetAccountWithBlockStatus() {
        runBlocking {
            // Test with FINAL status (default)
            val finalAccount = api.getAccount("0x328649a25184b171", blockStatus = BlockStatus.FINAL)
            assertNotNull(finalAccount)
            assertEquals("328649a25184b171", finalAccount.address)

            // Test with SEALED status
            val sealedAccount = api.getAccount("0x328649a25184b171", blockStatus = BlockStatus.SEALED)
            assertNotNull(sealedAccount)
            assertEquals("328649a25184b171", sealedAccount.address)
        }
    }

    @Test
    fun testGetAccountWithBlockHeight() {
        runBlocking {
            // First get a block to use its height
            val block = api.getBlock()
            val blockHeight = block.header.height

            // Test getting account at specific block height
            val account = api.getAccount("0x328649a25184b171", blockHeight = blockHeight)
            assertNotNull(account)
            assertEquals("328649a25184b171", account.address)
        }
    }

    @Test
    fun testGetAccountWithInvalidAddress() {
        runBlocking {
            assertFailsWith<Exception> {
                api.getAccount("invalid_address")
            }
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
    fun testGetBlockWithStatus() {
        runBlocking {
            // Test with FINAL status (default)
            val finalBlock = api.getBlock(blockStatus = BlockStatus.FINAL)
            assertNotNull(finalBlock)
            assertTrue(finalBlock.header.id.isNotEmpty())

            // Test with SEALED status
            val sealedBlock = api.getBlock(blockStatus = BlockStatus.SEALED)
            assertNotNull(sealedBlock)
            assertTrue(sealedBlock.header.id.isNotEmpty())
        }
    }

    @Test
    fun testGetBlockWithHeight() {
        runBlocking {
            // First get a block to use its height
            val initialBlock = api.getBlock()
            val blockHeight = initialBlock.header.height

            // Test getting block at specific height
            val block = api.getBlock(blockHeight = blockHeight)
            assertNotNull(block)
            assertEquals(blockHeight, block.header.height)
        }
    }

    @Test
    fun testGetBlockWithId() {
        runBlocking {
            // First get a block to use its ID
            val initialBlock = api.getBlock()
            val blockId = initialBlock.header.id

            // Test getting block by ID
            val block = api.getBlock(id = blockId)
            assertNotNull(block)
            assertEquals(blockId, block.header.id)
        }
    }

    @Test
    fun testGetBlockWithInvalidId() {
        runBlocking {
            assertFailsWith<Exception> {
                api.getBlock(id = "invalid_block_id")
            }
        }
    }

    @Test
    fun testGetBlockHeader() {
        runBlocking {
            // Test with default FINAL status
            val finalHeader = api.getBlockHeader()
            assertNotNull(finalHeader)
            assertTrue(finalHeader.id.isNotEmpty())

            // Test with SEALED status
            val sealedHeader = api.getBlockHeader(blockStatus = BlockStatus.SEALED)
            assertNotNull(sealedHeader)
            assertTrue(sealedHeader.id.isNotEmpty())

            // Test with specific block height
            val block = api.getBlock()
            val blockHeight = block.header.height
            val headerByHeight = api.getBlockHeader(blockHeight = blockHeight)
            assertNotNull(headerByHeight)
            assertEquals(blockHeight, headerByHeight.height)

            // Test with specific block ID
            val blockId = block.header.id
            val headerById = api.getBlockHeader(id = blockId)
            assertNotNull(headerById)
            assertEquals(blockId, headerById.id)
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
}