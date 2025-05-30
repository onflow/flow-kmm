package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.TransactionBuilder
import org.onflow.flow.models.TransactionStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.onflow.flow.models.payloadMessage
import kotlin.test.assertNotNull

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)

    /**
     * Test multi-signer transaction where proposer ≠ payer (gas sponsored scenario)
     * 
     * Flow: Proposer signs payload, Payer signs envelope
     */
    @Test
    fun testGasSponsoredTransaction() = runBlocking {
        // ===== SETUP =====
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"

        // Get on-chain account information
        val proposerAccount = api.getAccount(proposerAddress)
        val payerAccount = api.getAccount(payerAddress)
        val proposerKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        val payerKey = payerAccount.keys!!.first { it.index.toInt() == 0 }

        // Create signers with on-chain algorithms
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, proposerKey.signingAlgorithm),
            proposerKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val payerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, payerKey.signingAlgorithm),
            payerKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val transaction = TransactionBuilder(
            script = """
                transaction(msg: String) {
                    prepare(proposer: auth(Storage) &Account) {
                        log("Proposer: ".concat(proposer.address.toString()))
                        log("Message: ".concat(msg))
                    }
                }
            """.trimIndent(),
            arguments = listOf(Cadence.string("Hello, Testnet!"))
        )
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== SIGNING =====
        val signedTransaction = transaction.sign(listOf(proposerSigner, payerSigner))

        // ===== SUBMISSION AND VERIFICATION =====
        val result = api.sendTransaction(signedTransaction)
        assertNotNull(result.id, "Transaction ID should not be null")
        
        val seal = api.waitForSeal(result.id!!)
        val finalResult = api.getTransactionResult(result.id!!)
        
        assertEquals(TransactionStatus.SEALED, finalResult.status)
        println("✅ Gas sponsored transaction sealed successfully")
    }

    /**
     * Test single-signer transaction where proposer = payer = authorizer
     */
    @Test
    fun testSingleSignerTransaction() = runBlocking {
        // ===== SETUP =====
        val accountAddress = "c6de0d94160377cd"
        val privateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

        // Get on-chain account information
        val account = api.getAccount(accountAddress)
        assertNotNull(account, "Account should exist")
        val accountKey = account.keys!!.first { it.index.toInt() == 0 }

        // Create signer with on-chain algorithms
        val signer = Crypto.getSigner(
            Crypto.decodePrivateKey(privateKey, accountKey.signingAlgorithm),
            accountKey.hashingAlgorithm
        ).apply {
            address = accountAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val transaction = TransactionBuilder(
            script = """
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Hello, World!")
                    }
                }
            """.trimIndent()
        )
            .withProposalKey(accountAddress, 0, accountKey.sequenceNumber.toBigInteger())
            .withPayer(accountAddress)
            .withAuthorizers(listOf(accountAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== SIGNING =====
        val signedTransaction = transaction.sign(listOf(signer))

        // ===== SUBMISSION AND VERIFICATION =====
        val result = api.sendTransaction(signedTransaction)
        assertNotNull(result.id, "Transaction ID should not be null")
        
        val seal = api.waitForSeal(result.id!!)
        val finalResult = api.getTransactionResult(result.id!!)
        
        assertEquals(TransactionStatus.SEALED, finalResult.status)
        println("✅ Single signer transaction sealed successfully")
    }

    /**
     * Test that proposer account can sign transactions independently
     */
    @Test
    fun testProposerSoloTransaction() = runBlocking {
        // ===== SETUP =====
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

        // Get on-chain account information
        val account = api.getAccount(proposerAddress)
        val accountKey = account.keys!!.first { it.index.toInt() == 0 }

        // Create signer with on-chain algorithms
        val signer = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, accountKey.signingAlgorithm),
            accountKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val transaction = TransactionBuilder(
            script = """
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Proposer solo test")
                    }
                }
            """.trimIndent()
        )
            .withProposalKey(proposerAddress, 0, accountKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== SIGNING =====
        val signedTransaction = transaction.sign(listOf(signer))

        // ===== SUBMISSION AND VERIFICATION =====
        val result = api.sendTransaction(signedTransaction)
        assertNotNull(result.id, "Transaction ID should not be null")
        
        val seal = api.waitForSeal(result.id!!)
        val finalResult = api.getTransactionResult(result.id!!)
        
        assertEquals(TransactionStatus.SEALED, finalResult.status)
        println("✅ Proposer solo transaction sealed successfully")
    }

    /**
     * Test that payer account can sign transactions independently
     */
    @Test
    fun testPayerSoloTransaction() = runBlocking {
        // ===== SETUP =====
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"

        // Get on-chain account information
        val account = api.getAccount(payerAddress)
        val accountKey = account.keys!!.first { it.index.toInt() == 0 }

        // Create signer with on-chain algorithms
        val signer = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, accountKey.signingAlgorithm),
            accountKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val transaction = TransactionBuilder(
            script = """
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Payer solo test")
                    }
                }
            """.trimIndent()
        )
            .withProposalKey(payerAddress, 0, accountKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(payerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== SIGNING =====
        val signedTransaction = transaction.sign(listOf(signer))

        // ===== SUBMISSION AND VERIFICATION =====
        val result = api.sendTransaction(signedTransaction)
        assertNotNull(result.id, "Transaction ID should not be null")
        
        val seal = api.waitForSeal(result.id!!)
        val finalResult = api.getTransactionResult(result.id!!)
        
        assertEquals(TransactionStatus.SEALED, finalResult.status)
        println("✅ Payer solo transaction sealed successfully")
    }

    /**
     * Test manual step-by-step signature addition (JVM SDK style)
     * 
     * This test demonstrates the step-by-step approach used by the Flow JVM SDK
     */
    @Test
    fun testManualStepByStepSigning() = runBlocking {
        // ===== SETUP =====
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"

        // Get on-chain account information
        val proposerAccount = api.getAccount(proposerAddress)
        val payerAccount = api.getAccount(payerAddress)
        val proposerKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        val payerKey = payerAccount.keys!!.first { it.index.toInt() == 0 }

        // Create signers with on-chain algorithms
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, proposerKey.signingAlgorithm),
            proposerKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val payerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, payerKey.signingAlgorithm),
            payerKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val unsignedTransaction = TransactionBuilder(
            script = """
                transaction(msg: String) {
                    prepare(proposer: auth(Storage) &Account) {
                        log("Manual signing: ".concat(msg))
                    }
                }
            """.trimIndent(),
            arguments = listOf(Cadence.string("Hello!"))
        )
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== STEP-BY-STEP SIGNING =====
        // Step 1: Add payload signature (proposer signs payload)
        val transactionWithPayloadSig = unsignedTransaction.addPayloadSignature(
            proposerAddress, 0, proposerSigner
        )
        
        // Step 2: Add envelope signature (payer signs envelope)
        val fullySignedTransaction = transactionWithPayloadSig.addEnvelopeSignature(
            payerAddress, 0, payerSigner
        )

        // ===== SUBMISSION AND VERIFICATION =====
        val result = api.sendTransaction(fullySignedTransaction)
        assertNotNull(result.id, "Transaction ID should not be null")
        
        val seal = api.waitForSeal(result.id!!)
        val finalResult = api.getTransactionResult(result.id!!)
        
        assertEquals(TransactionStatus.SEALED, finalResult.status)
        println("✅ Manual step-by-step transaction sealed successfully")
    }

    /**
     * Test payload message debugging and comparison
     * 
     * This test compares payload messages between single-signer and multi-signer scenarios
     */
    @Test
    fun testPayloadMessageComparison() = runBlocking {
        // ===== SETUP =====
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        val payerAddress = "10711015c370a95c"

        // Get on-chain account information
        val proposerAccount = api.getAccount(proposerAddress)
        val proposerKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }

        // Create signer with on-chain algorithms
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, proposerKey.signingAlgorithm),
            proposerKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val commonScript = """
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Payload comparison test")
                }
            }
        """.trimIndent()

        // Single-signer transaction (proposer = payer)
        val singleSignerTransaction = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // Multi-signer transaction (proposer ≠ payer)
        val multiSignerTransaction = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        // ===== PAYLOAD MESSAGE COMPARISON =====
        val singleSignerPayload = singleSignerTransaction.payloadMessage()
        val multiSignerPayload = multiSignerTransaction.payloadMessage()

        // Verify payloads are different (due to different payer)
        assertTrue(
            !singleSignerPayload.contentEquals(multiSignerPayload),
            "Payload messages should differ when payer is different"
        )

        // ===== SIGNATURE VERIFICATION =====
        val singleSignerSignature = proposerSigner.sign(singleSignerPayload)
        val multiSignerSignature = proposerSigner.sign(multiSignerPayload)

        // Verify signatures are different (due to different payloads)
        assertTrue(
            !singleSignerSignature.contentEquals(multiSignerSignature),
            "Signatures should differ when payload is different"
        )

        println("✅ Payload message comparison test passed")
    }
}