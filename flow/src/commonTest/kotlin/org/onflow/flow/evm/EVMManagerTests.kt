package org.onflow.flow.evm

import kotlinx.coroutines.runBlocking
import org.onflow.flow.ChainId
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import org.onflow.flow.apis.TransactionsApi
import org.onflow.flow.models.hexToBytes
import kotlin.test.assertEquals

class EVMManagerTests {
    private val baseUrl = ChainId.Testnet.baseUrl
    private val transactionsApi = TransactionsApi(baseUrl)
    private val evmManager = EVMManager(ChainId.Testnet)

    @Test
    fun testCreateCOAAccount() {
        runBlocking {
            // Test account details
            val testAccountAddress = "0xc6de0d94160377cd"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")

            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = 0
            }

            val ex = assertFailsWith<RuntimeException> {
                // triggers the Cadence script; we *expect* it to abort
                val txId = evmManager.createCOAAccount(
                    proposer = FlowAddress(cleanAccountAddress),
                    payer = FlowAddress(cleanAccountAddress),
                    amount = 0.1,
                    signers = listOf(signer)
                )
                transactionsApi.waitForSeal(txId)   // will throw
            }

            assertTrue(
                ex.message?.contains("already stores an object") == true,
                "Error should mention that /storage/evm already stores an object"
            )
        }
    }

    @Test
    fun testGetEVMAddress() {
        runBlocking {
            val response = evmManager.getEVMAddress(FlowAddress.of("0xcfa16944c93058bf".hexToBytes()))
            println("EVM Address: $response")
            assertEquals("0000000000000000000000029e7fe89acde8be4a", response)
        }
    }

    @Test
    fun testGetChildAccountMetadata() {
        runBlocking {
            val metadata = evmManager.getChildAccountMetadata(FlowAddress.of("0xcfa16944c93058bf".hexToBytes()))
            // Verify the metadata structure
            metadata.forEach { (key, value) ->
                assertTrue(key.isNotEmpty())
                // Check that the metadata object has the expected fields
                assertTrue(value.name == null || value.name is String)
                assertTrue(value.description == null || value.description is String)
                assertTrue(value.thumbnail == null || value.thumbnail is EVMManager.Thumbnail)
                value.thumbnail?.let { thumbnail ->
                    assertTrue(thumbnail.url == null || thumbnail.url is String)
                }
            }
        }
    }
} 