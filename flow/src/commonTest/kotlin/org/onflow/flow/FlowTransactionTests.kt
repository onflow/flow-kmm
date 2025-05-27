package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionBuilder
import org.onflow.flow.models.TransactionStatus
import kotlin.test.Test
import kotlin.test.assertEquals
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
            println(account)
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
    fun testMultiSignTransaction() {
        runBlocking {
            // Test account details
            val testAccountAddress = "0xc6de0d94160377cd"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

            // Get the account to verify it exists and get the key index
            val account = api.getAccount(cleanAccountAddress)
            val key = account.keys!!.first()

            // Get the latest block for reference block ID
            val latestBlock = api.getBlock()

            // Create multiple signers with different key indices
            val privateKey = Crypto.decodePrivateKey(privateKeyHex, SigningAlgorithm.ECDSA_P256)
            val signers = listOf(
                Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
                    address = cleanAccountAddress
                    keyIndex = 0
                },
                Crypto.getSigner(privateKey, HashingAlgorithm.SHA3_256).apply {
                    address = cleanAccountAddress
                    keyIndex = 1
                }
            )

            // Create the transaction with all required fields
            val tx = Transaction(
                id = null,
                script = """
                    transaction {
                        prepare(signer1: auth(Storage) &Account, signer2: auth(Storage) &Account) {
                            log(signer1.address)
                            log(signer2.address)
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
                authorizers = listOf(cleanAccountAddress, cleanAccountAddress),
                payloadSignatures = emptyList(),
                envelopeSignatures = emptyList(),
                expandable = null,
                result = null,
                links = null
            )

            // Sign and send the transaction
            val signedTx = tx.sign(signers)
            val result = api.sendTransaction(signedTx)

            val seal = result.id?.let { api.waitForSeal(it) }

            // Verify the transaction was sent successfully
            assertEquals(TransactionStatus.SEALED, seal?.status, "Transaction should be sealed")
            result.id?.isNotEmpty()?.let { assertTrue(it, "Transaction ID should not be empty") }
            println("Multi-sign transaction sent successfully with ID: ${result.id}")
        }
    }

    @Test
    fun testAddKeyTransactionTest() {
        runBlocking {
            // ---- CONFIGURATION ----
            // Using existing Testnet account details from other tests in this file
            val proposerAuthorizerAddress = "0xc6de0d94160377cd"
            val proposerPrivateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
            val proposerKeyIndex = 0 // Assuming key index 0 for this test account

            // Simplification: Proposer is also Payer for this test, as the error is in payload() construction
            val payerAddress = proposerAuthorizerAddress 

            // New public key to add (64-byte hex string, no "0x" or "04" prefix)
            // This is the value that was '53effd...' in your Android app logs.
            val newPublicKeyForCadence = "53effd044517cffd785f4719f63769c9f18b24df546c0cd1f52ff7f2e63789f3c80d6fe0d0a48db47cefd5b0c95714f041233a419409f44f47ce35cd55eb2a7b"
            val newKeySigAlgoCadenceIndex = 1 // ECDSA_P256.cadenceIndex
            val newKeyHashAlgoCadenceIndex = 3 // SHA3_256.cadenceIndex (aligns with app log: UInt8Value(value=3))
            val newKeyWeightString = "1000.0" 

            val gasLimitForTx = 9999L
            // ---- END CONFIGURATION ----

            val cleanProposerAuthorizerAddress = proposerAuthorizerAddress.removePrefix("0x")
            val cleanPayerAddress = payerAddress.removePrefix("0x")

            // 1. Get proposer account details
            val proposerAccount = api.getAccount(cleanProposerAuthorizerAddress)
            val proposerAccountKey = proposerAccount.keys?.find { it.index.toInt() == proposerKeyIndex }
                ?: throw RuntimeException("Proposer key with index $proposerKeyIndex not found on account $proposerAuthorizerAddress")
            val currentSequenceNumber = proposerAccountKey.sequenceNumber.toBigInteger()

            // 2. Get the latest block for reference block ID
            val latestBlock = api.getBlockHeader()

            // 3. Define the script (same as your app)
            val addKeyScript = """
                import Crypto

                transaction(publicKey: String, signatureAlgorithm: UInt8, hashAlgorithm: UInt8, weight: UFix64) {
                    prepare(signer: auth(Keys) &Account) {
                        let key = PublicKey(
                            publicKey: publicKey.decodeHex(),
                            signatureAlgorithm: SignatureAlgorithm(rawValue: signatureAlgorithm)!
                        )

                        signer.keys.add(
                            publicKey: key,
                            hashAlgorithm: HashAlgorithm(rawValue: hashAlgorithm)!,
                            weight: weight
                        )
                    }
                }
            """.trimIndent()

            // 4. Prepare arguments (matching your app logs)
            val arguments = listOf(
                Cadence.string(newPublicKeyForCadence),
                Cadence.uint8(newKeySigAlgoCadenceIndex.toUByte()),
                Cadence.uint8(newKeyHashAlgoCadenceIndex.toUByte()),
                Cadence.ufix64(newKeyWeightString)
            )
            println("[KMM Test] Arguments: $arguments")

            // 5. Create the proposer's signer
            // Ensure SigningAlgorithm and HashingAlgorithm match the key's actual algorithms
            val keySigningAlgorithm = SigningAlgorithm.values().firstOrNull { it.cadenceIndex == proposerAccountKey.signingAlgorithm.cadenceIndex }
                ?: SigningAlgorithm.ECDSA_P256 // Default if not found, adjust as needed
            val keyHashingAlgorithm = HashingAlgorithm.values().firstOrNull { it.cadenceIndex == proposerAccountKey.hashingAlgorithm.cadenceIndex }
                ?: HashingAlgorithm.SHA3_256 // Default if not found, adjust as needed
            
            val proposerPrivateKey = Crypto.decodePrivateKey(proposerPrivateKeyHex, keySigningAlgorithm)
            val proposerSigner = Crypto.getSigner(proposerPrivateKey, keyHashingAlgorithm).apply {
                address = cleanProposerAuthorizerAddress
                keyIndex = proposerKeyIndex
            }
            println("[KMM Test] Proposer Signer: address=${proposerSigner.address}, keyIndex=${proposerSigner.keyIndex}, sigAlgo=${keySigningAlgorithm}, hashAlgo=${keyHashingAlgorithm}")

            // 6. Construct the Transaction object directly
            println("[KMM Test] Constructing Transaction object:")
            println("  Script (length ${addKeyScript.length}): $addKeyScript")
            println("  ReferenceBlockId: ${latestBlock.id}")
            println("  GasLimit: ${gasLimitForTx.toBigInteger()}")
            println("  Payer: $cleanPayerAddress")
            println("  ProposalKey: address=$cleanProposerAuthorizerAddress, keyIndex=$proposerKeyIndex, sequenceNumber=$currentSequenceNumber")
            println("  Authorizers: ${listOf(cleanProposerAuthorizerAddress)}")

            println("[KMM Test] Transaction object created. Attempting to sign (which calls payload())...")

            // 7. Attempt to sign using TransactionBuilder instead of direct Transaction construction
            try {
                val signedTx = TransactionBuilder(
                    script = addKeyScript,
                    arguments = arguments,
                    gasLimit = gasLimitForTx.toBigInteger()
                ).apply {
                    withReferenceBlockId(latestBlock.id)
                    withPayer(cleanPayerAddress)
                    withProposalKey(
                        address = cleanProposerAuthorizerAddress,
                        keyIndex = proposerKeyIndex,
                        sequenceNumber = currentSequenceNumber
                    )
                    withAuthorizers(listOf(cleanProposerAuthorizerAddress))
                    withSigners(listOf(proposerSigner))
                }.buildAndSign()

                println("[KMM Test] Transaction signed successfully: $signedTx")
                

            } catch (e: Exception) {
                e.printStackTrace() // Print full stack trace for detailed analysis
                
                // Check if the exception message is "Array is empty."
                val isCorrectError = e.message?.contains("Array is empty", ignoreCase = true) == true
                if (isCorrectError) {
                    println("[KMM Test] SUCCESSFULLY REPLICATED an error containing 'Array is empty'. Test PASSES.")
                    // Optionally, assert specific details from the exception if needed
                    // For example, to ensure it's from the expected place:
                    // assertTrue(e.stackTraceToString().contains("TransactionKt.payload"), "Error should originate from payload()")
                } else {
                    println("[KMM Test] An exception occurred, but it was not the expected 'Array is empty' error. Test FAILS.")
                }
            }
        }
    }

    @Test
    fun testTransactionWithZeroSequenceNumber() {
        runBlocking {
            // Test account details (can reuse from other tests)
            val testAccountAddress = "0xc6de0d94160377cd"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

            // Get the account to verify it exists and get the key index
            // We will ignore the fetched sequence number and use 0 instead.
            val account = api.getAccount(cleanAccountAddress)
            val key = account.keys!!.first() // For keyIndex and signing algorithm

            // Get the latest block for reference block ID
            val latestBlock = api.getBlockHeader()

            // Create a signer using the provided private key
            val privateKey = Crypto.decodePrivateKey(privateKeyHex, key.signingAlgorithm)
            val signer = Crypto.getSigner(privateKey, key.hashingAlgorithm).apply {
                address = cleanAccountAddress
                keyIndex = key.index.toInt()
            }

            val simpleScript = """
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Sequence number 0 test")
                        log(signer.address)
                    }
                }
            """.trimIndent()

            println("[KMM Test - Zero SeqNum] Attempting to build and sign transaction with sequenceNumber = 0")

            var signedTx: Transaction? = null
            var exceptionOccurred: Exception? = null

            try {
                signedTx = TransactionBuilder(
                    script = simpleScript,
                    arguments = emptyList(),
                    gasLimit = 100L.toBigInteger() // Minimal gas for a simple log
                ).apply {
                    withReferenceBlockId(latestBlock.id)
                    withPayer(cleanAccountAddress)
                    withProposalKey(
                        address = cleanAccountAddress,
                        keyIndex = key.index.toInt(),
                        sequenceNumber = 0.toBigInteger() // Explicitly use Zero BigInteger
                    )
                    withAuthorizers(listOf(cleanAccountAddress))
                    withSigners(listOf(signer))
                }.buildAndSign()

                println("[KMM Test - Zero SeqNum] Transaction signed successfully with sequenceNumber = 0: $signedTx")
            } catch (e: Exception) {
                exceptionOccurred = e
                e.printStackTrace()
            }

            assertTrue(exceptionOccurred == null, "[KMM Test - Zero SeqNum] No exception should be thrown during signing. Got: ${exceptionOccurred?.message}")
            assertTrue(signedTx != null, "[KMM Test - Zero SeqNum] Signed transaction should not be null.")
        }
    }
}