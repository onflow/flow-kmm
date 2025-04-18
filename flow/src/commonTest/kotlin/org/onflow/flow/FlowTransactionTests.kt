package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)

    @Test
    fun testSignTestnet() {
        runBlocking {
            // Test account A details
            val testAccountAddress = "0xc6de0d94160377cd"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

            // Get the account to verify it exists and get the key index
            val account = api.getAccount(cleanAccountAddress)
            val key = account.keys!!.first()

            // Get the latest block for reference block ID
            val latestBlock = api.getBlock()

            // Create a signer using the provided private key
            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = 0
            }

            // Create the transaction with all required fields
            val tx = Transaction(
                id = null,
                script = """
                    transaction {
                        prepare(signer: auth(Storage) &Account) {
                            log(signer.address)
                        }
                    }
                """.trimIndent(),
                arguments = emptyList(),
                referenceBlockId = latestBlock.header.id,
                gasLimit = 1000.toBigInteger(),
                payer = cleanAccountAddress,
                proposalKey = ProposalKey(
                    address = cleanAccountAddress,
                    keyIndex = account.keys!!.first().index.toInt(),
                    sequenceNumber = key.sequenceNumber.toBigInteger()
                ),
                authorizers = listOf(cleanAccountAddress),
                payloadSignatures = emptyList(),
                envelopeSignatures = emptyList(),
                expandable = null, // This is optional
                result = null, // This is optional
                links = null // This is optional
            )

            // Sign and send the transaction
            val signedTx = tx.sign(listOf(signer))
            val result = api.sendTransaction(signedTx)

            val seal = result.id?.let { api.waitForSeal(it) }

            // Verify the transaction was sent successfully
            assertEquals(TransactionStatus.SEALED, seal?.status, "Transaction should be sealed")
            result.id?.isNotEmpty()?.let { assertTrue(it, "Transaction ID should not be empty") }
            println("Transaction sent successfully with ID: ${result.id}")
        }
    }

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
                val txId = api.createCOAAccount(
                    proposer = FlowAddress(cleanAccountAddress),
                    payer    = FlowAddress(cleanAccountAddress),
                    amount   = 0.1,
                    signers  = listOf(signer)
                )
                api.waitForSeal(txId)   // will throw
            }

            assertTrue(
                ex.message?.contains("already stores an object") == true,
                "Error should mention that /storage/evm already stores an object"
            )
        }
    }
}