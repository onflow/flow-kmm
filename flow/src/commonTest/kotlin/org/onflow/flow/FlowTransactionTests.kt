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
import org.onflow.flow.models.hexToBytes
import kotlin.test.Test
import kotlin.test.assertTrue

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)

//    @Test
//    fun testSignTestnet() {
//        runBlocking {
//            // Test account A details
//            val testAccountAddress = "0xc6de0d94160377cd"
//            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
//            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
//
//            // Get the account to verify it exists and get the key index
//            val account = api.getAccount(cleanAccountAddress)
//            val key = account.keys!!.first()
//
//            // Get the latest block for reference block ID
//            val latestBlock = api.getBlock()
//
//            // Create a signer using the provided private key
//            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
//            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
//                address = cleanAccountAddress
//                keyIndex = 0
//            }
//
//            // Create the transaction with all required fields
//            val tx = Transaction(
//                id = null, // This is optional
//                script = """
//                    access(all) transaction {
//                        prepare(signer: AuthAccount) {
//                            log(signer.address)
//                        }
//                    }
//                """.trimIndent(),
//                arguments = emptyList(),
//                referenceBlockId = latestBlock.header.id,
//                gasLimit = 1000.toBigInteger(),
//                payer = cleanAccountAddress,
//                proposalKey = ProposalKey(
//                    address = cleanAccountAddress,
//                    keyIndex = account.keys!!.first().index.toInt(),
//                    sequenceNumber = key.sequenceNumber.toBigInteger()
//                ),
//                authorizers = listOf(cleanAccountAddress),
//                payloadSignatures = emptyList(),
//                envelopeSignatures = emptyList(),
//                expandable = null, // This is optional
//                result = null, // This is optional
//                links = null // This is optional
//            )
//
//            // Sign and send the transaction
//            val signedTx = tx.sign(listOf(signer))
//
//            val result = api.sendTransaction(signedTx)
//
//            val seal = result.id?.let { api.waitForSeal(it) }
//
//            print(seal)
//
//            // Verify the transaction was sent successfully
//            result.id?.isNotEmpty()?.let { assertTrue(it, "Transaction ID should not be empty") }
//            println("Transaction sent successfully with ID: ${result.id}")
//        }
//    }

//    @Test
//    fun testCreateCOAAccount() {
//        runBlocking {
//            // Test account details
//            val testAccountAddress = "0xc6de0d94160377cd"
//            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
//            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
//
//            // Get the account to verify it exists and get the key index
//            val account = api.getAccount(cleanAccountAddress)
//            val key = account.keys!!.first()
//
//            println(account)
//            println(account.keys!!.first().signingAlgorithm)
//            println(account.keys!!.first().hashingAlgorithm)
//
//            // Get the latest block for reference block ID
//            val latestBlock = api.getBlock()
//
//            // Create a signer using the provided private key
//            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
//            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
//                address = cleanAccountAddress
//                keyIndex = 0 // Use 0 as the key index since we know it's the first key
//            }
//
//            // Create COA account with 0.1 Flow tokens
//            val transactionId = api.createCOAAccount(
//                proposer = FlowAddress(account.address),
//                payer = FlowAddress(account.address),
//                amount = 0.1,
//                signers = listOf(signer)
//            )
//
//            println(transactionId)
//
//            // Wait for the transaction to be sealed
//            val result = api.waitForSeal(transactionId)
//
//            println(result)
//
//            // Verify the transaction was successful
//            assertTrue(result.status == TransactionStatus.SEALED, "Transaction should be sealed")
//            assertTrue(result.errorMessage == null, "Transaction should not have errors")
//            println("COA account created successfully with transaction ID: $transactionId")
//        }
//    }
}