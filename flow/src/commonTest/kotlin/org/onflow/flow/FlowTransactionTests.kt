package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.models.Transaction
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.models.FlowAddress
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.TransactionStatus
import kotlin.test.Test
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

            print(seal)

            // Verify the transaction was sent successfully
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
            val expectedPubKey = "d487802b66e5c0498ead1c3f576b718949a3500218e97a6a4a62bf69a8b0019789639bc7acaca63f5889c1e7251c19066abb09fcd6b273e394a8ac4ee1a3372f"


            // Get the account to verify it exists and get the key index
            val account = api.getAccount(cleanAccountAddress)
            val key = account.keys!!.first()

            println(account)
            println(account.keys!!.first().signingAlgorithm)
            println(account.keys!!.first().hashingAlgorithm)

            // Get the latest block for reference block ID
            val latestBlock = api.getBlock()

            // Create a signer using the provided private key
            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)

            val derivedPubKey = Crypto.derivePublicKey(privateKey).hex

            println("Derived:  $derivedPubKey")
            println("Expected: $expectedPubKey")


            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA2_256).apply {
                address = cleanAccountAddress
                keyIndex = 0 // Use 0 as the key index since we know it's the first key
            }

            // Create COA account with 0.1 Flow tokens
            val transactionId = api.createCOAAccount(
                proposer = FlowAddress(account.address),
                payer = FlowAddress(account.address),
                amount = 0.1,
                signers = listOf(signer)
            )

            println(transactionId)

            println("Key index: ${signer.keyIndex}")
            println("Address: ${signer.address}")

            // Wait for the transaction to be sealed
            val result = api.waitForSeal(transactionId)

            println(result)

            // Verify the transaction was successful
            assertTrue(result.status == TransactionStatus.SEALED, "Transaction should be sealed")
            assertTrue(result.errorMessage == null, "Transaction should not have errors")
            println("COA account created successfully with transaction ID: $transactionId")
        }
    }
}