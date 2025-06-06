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
    private val baseUrl = ChainId.Mainnet.baseUrl
    private val transactionsApi = TransactionsApi(baseUrl)
    private val evmManager = EVMManager(ChainId.Mainnet)

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
            val response = evmManager.getEVMAddress(FlowAddress.of("0xe8264050e6f51923".hexToBytes()))
            println("EVM Address: $response")
            assertEquals("00000000000000000000000213e14ccecdc48acc", response)
        }
    }

    @Test
    fun testGetChildAccountMetadata() {
        runBlocking {
            val metadata = evmManager.getChildAccountMetadata(FlowAddress.of("0xe8264050e6f51923".hexToBytes()))
            println("Metadata: $metadata")

            // Ensure the metadata map is not empty
            assertTrue(metadata.isNotEmpty(), "Metadata map should not be empty")

            data class ExpectedMetadata(
                val name: String?,
                val description: String?,
                val address: String,
                val thumbnailUrl: String
            )

            // Expected addresses and their metadata
            val expectedData = mapOf(
                "0x73290be70dc6b89e" to ExpectedMetadata(
                    name = "Dapper Wallet",
                    description = "Dapper Custodial Wallet",
                    address = "0x73290be70dc6b89e",
                    thumbnailUrl = "https://accounts.meetdapper.com/static/img/dapper/dapper.png"
                ),
                "0x8e5a02ccc537163f" to ExpectedMetadata(
                    name = "Dapper Wallet",
                    description = "Dapper Custodial Wallet",
                    address = "0x8e5a02ccc537163f",
                    thumbnailUrl = "https://accounts.meetdapper.com/static/img/dapper/dapper.png"
                )
            )

            assertEquals(expectedData.size, metadata.size, "Metadata map should contain exactly ${expectedData.size} entries")

            expectedData.forEach { (expectedAddressKey, expectedMeta) ->
                val accountMetadata = metadata[expectedAddressKey]
                assertTrue(accountMetadata != null, "Metadata should exist for address $expectedAddressKey")

                accountMetadata?.let {
                    // Check name and description
                    assertEquals(expectedMeta.name, it.name, "Name should match for $expectedAddressKey")
                    assertEquals(expectedMeta.description, it.description, "Description should match for $expectedAddressKey")

                    // Check address field is now populated
                    assertEquals(expectedMeta.address, it.address, "Address field should match map key for $expectedAddressKey")

                    // Check thumbnail
                    assertTrue(it.thumbnail != null, "Thumbnail should exist for $expectedAddressKey")
                    it.thumbnail?.let { thumbnail ->
                        assertEquals(expectedMeta.thumbnailUrl, thumbnail.url, "Thumbnail URL should match for $expectedAddressKey")
                    }
                }
            }
        }
    }
}
