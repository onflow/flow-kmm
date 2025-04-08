package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.models.Transaction
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.TransactionSignature
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
            println("Account key index: ${key.index}")
            
            // Get the latest block for reference block ID
            val latestBlock = api.getBlock()
            
            // Create a signer using the provided private key
            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
            val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = key.index.toInt()
            }

            val tx = Transaction(
                script = """
                    access(all) transaction {
                        prepare(signer: AuthAccount) {
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
                    keyIndex = key.index.toInt(),
                    sequenceNumber = key.sequenceNumber.toBigInteger()
                ),
                authorizers = listOf(cleanAccountAddress),
                payloadSignatures = emptyList(),
                envelopeSignatures = emptyList()
            )
            
            // Sign and send the transaction
            val signedTx = tx.sign(listOf(signer))
            println("Payload signatures: ${signedTx.payloadSignatures}")
            println("Envelope signatures: ${signedTx.envelopeSignatures}")
            val result = api.sendTransaction(signedTx)
            
            // Verify the transaction was sent successfully
            result.id?.isNotEmpty()?.let { assertTrue(it, "Transaction ID should not be empty") }
            println("Transaction sent successfully with ID: ${result.id}")
        }
    }
}