package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.TransactionBuilder
import org.onflow.flow.models.TransactionStatus
import org.onflow.flow.models.TransactionSignature
import org.onflow.flow.models.createSigningRLP
import org.onflow.flow.models.createSigningRLPJVMStyle
import org.onflow.flow.models.envelopeMessage
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

    /**
     * Debug test to understand signature verification issues
     */
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testSignatureVerificationDebug() = runBlocking {
        // ===== SETUP =====
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"

        // Get on-chain account information
        val proposerAccount = api.getAccount(proposerAddress)
        val proposerKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }

        println("SIGNATURE DEBUG:")
        println("On-chain key details:")
        println("Public key: ${proposerKey.publicKey}")
        println("Signing algorithm: ${proposerKey.signingAlgorithm}")
        println("Hashing algorithm: ${proposerKey.hashingAlgorithm}")
        println("Weight: ${proposerKey.weight}")
        println("Revoked: ${proposerKey.revoked}")

        // Create signer and verify key derivation
        val privateKeyDecoded = Crypto.decodePrivateKey(proposerPrivateKey, proposerKey.signingAlgorithm)
        val derivedPublicKey = privateKeyDecoded.publicKey
        
        println("Derived public key: ${derivedPublicKey.key}")
        // Fix: Compare hex strings properly by removing 0x prefix
        val onChainHex = proposerKey.publicKey.removePrefix("0x")
        val derivedHex = derivedPublicKey.hex
        println("Keys match: ${onChainHex.equals(derivedHex, ignoreCase = true)}")

        val proposerSigner = Crypto.getSigner(privateKeyDecoded, proposerKey.hashingAlgorithm).apply {
            address = proposerAddress
            keyIndex = 0
        }

        val latestBlock = api.getBlockHeader()

        // ===== TRANSACTION BUILDING =====
        val transaction = TransactionBuilder(
            script = """
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Signature debug test")
                    }
                }
            """.trimIndent()
        )
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        println("Transaction details:")
        println("Script: ${transaction.script}")
        println("Reference block: ${transaction.referenceBlockId}")
        println("Gas limit: ${transaction.gasLimit}")
        println("Proposer: ${transaction.proposalKey.address}")
        println("Payer: ${transaction.payer}")
        println("Authorizers: ${transaction.authorizers}")

        // ===== PAYLOAD MESSAGE ANALYSIS =====
        val payloadMessage = transaction.payloadMessage()
        println("Payload message (${payloadMessage.size} bytes): ${payloadMessage.toHexString()}")

        // Test different RLP creation methods
        val currentRLP = transaction.createSigningRLP(includePayloadSignatures = false)
        val jvmStyleRLP = transaction.createSigningRLPJVMStyle(includePayloadSignatures = false)
        
        println("Current RLP: ${currentRLP.toHexString()}")
        println("JVM Style RLP: ${jvmStyleRLP.toHexString()}")
        println("RLP methods match: ${currentRLP.contentEquals(jvmStyleRLP)}")

        // Test what addPayloadSignature actually signs vs what we're manually signing
        val rawRLPData = transaction.createSigningRLPJVMStyle(includePayloadSignatures = false)
        val signAsTransactionResult = proposerSigner.signAsTransaction(rawRLPData)
        val manualSignResult = proposerSigner.sign(payloadMessage)
        
        println("Raw RLP data: ${rawRLPData.toHexString()}")
        println("SignAsTransaction result: ${signAsTransactionResult.toHexString()}")
        println("Manual sign result: ${manualSignResult.toHexString()}")
        println("Signing methods match: ${signAsTransactionResult.contentEquals(manualSignResult)}")

        // Test if this matches what our addPayloadSignature method would create
        val addedSigTx = transaction.addPayloadSignature(proposerAddress, 0, proposerSigner)
        println("AddPayloadSignature result: ${addedSigTx.payloadSignatures.first().signature}")
        println("Manual vs AddPayloadSignature match: ${manualSignResult.toHexString() == addedSigTx.payloadSignatures.first().signature}")

        println("✅ Signature debug test completed")
    }

    /**
     * Debug test to verify multi-signer signing process
     */
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testMultiSignerDebug() = runBlocking {
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
                transaction {
                    prepare(signer: auth(Storage) &Account) {
                        log("Multi-signer debug test")
                    }
                }
            """.trimIndent()
        )
            .withProposalKey(proposerAddress, 0, proposerKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latestBlock.id)
            .build()

        println("MULTI-SIGNER DEBUG:")
        println("Initial transaction payload signatures: ${transaction.payloadSignatures.size}")
        println("Initial transaction envelope signatures: ${transaction.envelopeSignatures.size}")

        // Step 1: Test payload signing manually (corrected approach)
        val payloadMessageToSign = transaction.payloadMessage()
        val proposerPayloadSig = proposerSigner.sign(payloadMessageToSign)  // Fix: Use corrected approach
        
        println("Payload message to sign: ${payloadMessageToSign.toHexString()}")
        println("Proposer payload signature: ${proposerPayloadSig.toHexString()}")
        
        // Add the payload signature
        val txWithPayloadSig = transaction.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = proposerAddress,
                    keyIndex = 0,
                    signature = proposerPayloadSig.toHexString()
                )
            )
        )
        
        println("Transaction after adding payload sig - payloadSignatures: ${txWithPayloadSig.payloadSignatures.size}")

        // Step 2: Test envelope signing manually (corrected approach)
        val envelopeMessageToSign = txWithPayloadSig.envelopeMessage()
        val payerEnvelopeSig = payerSigner.sign(envelopeMessageToSign)  // Fix: Use corrected approach
        
        println("Envelope message to sign: ${envelopeMessageToSign.toHexString()}")
        println("Payer envelope signature: ${payerEnvelopeSig.toHexString()}")

        // Test automatic signing vs manual signing
        val autoSignedTransaction = transaction.sign(listOf(proposerSigner, payerSigner))
        
        println("Auto-signed transaction - payloadSignatures: ${autoSignedTransaction.payloadSignatures.size}")
        println("Auto-signed transaction - envelopeSignatures: ${autoSignedTransaction.envelopeSignatures.size}")
        
        if (autoSignedTransaction.payloadSignatures.isNotEmpty()) {
            println("Auto payload signature: ${autoSignedTransaction.payloadSignatures[0].signature}")
        }
        if (autoSignedTransaction.envelopeSignatures.isNotEmpty()) {
            println("Auto envelope signature: ${autoSignedTransaction.envelopeSignatures[0].signature}")
        }

        // Compare signatures
        val manualPayloadSig = proposerPayloadSig.toHexString()
        val autoPayloadSig = if (autoSignedTransaction.payloadSignatures.isNotEmpty()) 
            autoSignedTransaction.payloadSignatures[0].signature else "NONE"
        
        val manualEnvelopeSig = payerEnvelopeSig.toHexString()
        val autoEnvelopeSig = if (autoSignedTransaction.envelopeSignatures.isNotEmpty()) 
            autoSignedTransaction.envelopeSignatures[0].signature else "NONE"

        println("Manual vs Auto payload signature match: ${manualPayloadSig == autoPayloadSig}")
        println("Manual vs Auto envelope signature match: ${manualEnvelopeSig == autoEnvelopeSig}")

        // The key test: Do both payload messages for signing match?
        val manualPayloadMessage = transaction.payloadMessage()
        val autoPayloadMessage = transaction.payloadMessage()  // These should be identical
        
        println("Manual vs Auto payload message match: ${manualPayloadMessage.contentEquals(autoPayloadMessage)}")

        // CRITICAL TEST: Try submitting the manual transaction
        println("Testing manual transaction submission...")
        val manualTransaction = txWithPayloadSig.copy(
            envelopeSignatures = listOf(
                TransactionSignature(
                    address = payerAddress,
                    keyIndex = 0,
                    signature = payerEnvelopeSig.toHexString()
                )
            )
        )
        
        try {
            val manualResult = api.sendTransaction(manualTransaction)
            println("Manual transaction submitted successfully: ${manualResult.id}")
            
            val manualSeal = api.waitForSeal(manualResult.id!!)
            println("Manual transaction sealed successfully!")
            
        } catch (e: Exception) {
            println("Manual transaction failed: ${e.message}")
        }
        
        // TEST: Try submitting the automatic transaction
        println("Testing automatic transaction submission...")
        try {
            val autoResult = api.sendTransaction(autoSignedTransaction)
            println("Auto transaction submitted successfully: ${autoResult.id}")
            
            val autoSeal = api.waitForSeal(autoResult.id!!)
            println("Auto transaction sealed successfully!")
            
        } catch (e: Exception) {
            println("Auto transaction failed: ${e.message}")
        }
        
        println("✅ Multi-signer debug test completed")
    }
}