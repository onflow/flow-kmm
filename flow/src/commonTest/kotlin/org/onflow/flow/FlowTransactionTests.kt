package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import io.ktor.util.hex
import kotlinx.coroutines.runBlocking
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionBuilder
import org.onflow.flow.models.TransactionStatus
import org.onflow.flow.rlp.paddingZeroLeft
import org.onflow.flow.rlp.toRLP
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.onflow.flow.models.AccountPublicKey
import org.onflow.flow.models.envelopeMessage
import org.onflow.flow.models.payload
import org.onflow.flow.models.payloadMessage
import org.onflow.flow.rlp.encode
import kotlin.test.assertNotNull

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)


    /**
     * Proposer (user) ≠ Payer (gas station) -– end-to-end happy path.
     *
     * 1.  User signs the payload with her key.
     * 2.  Gas station signs the envelope with its key.
     * 3.  Submit and wait for SEAL.
     *
     * Preconditions
     * ─────────────
     * • Both accounts already exist on Testnet.
     * • Each key used here has   weight ≥ 1000,
     *   signingAlgorithm ECDSA_P256, hashingAlgorithm SHA3_256
     *   (adapt the code if your on-chain settings differ).
     */
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testGasSponsoredTransaction() = runBlocking {
        /*───────────────────────────────────────────────────────*
         * 1.  CONFIGURATION – accounts, keys, and script
         *───────────────────────────────────────────────────────*/
        val proposer = object {
            val addressHex    = "c6de0d94160377cd"
            val privateKeyHex = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
            val keyIndex      = 0
        }
        val payer = object {
            val addressHex    = "10711015c370a95c"
            val privateKeyHex = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"
            val keyIndex      = 0
        }

        /*───────────────────────────────────────────────────────*
         * 2.  RESOLVE on-chain keys and latest block
         *───────────────────────────────────────────────────────*/
        val proposerAccount = api.getAccount(proposer.addressHex)
        val payerAccount    = api.getAccount(payer.addressHex)

        val propKey = proposerAccount.keys!!.first { it.index.toInt() == proposer.keyIndex }
        val payKey  = payerAccount   .keys!!.first { it.index.toInt() == payer.keyIndex }

        println("🔍 Proposer key on-chain: sigAlgo=${propKey.signingAlgorithm}, hashAlgo=${propKey.hashingAlgorithm}")
        println("🔍 Payer key on-chain: sigAlgo=${payKey.signingAlgorithm}, hashAlgo=${payKey.hashingAlgorithm}")

        /*───────────────────────────────────────────────────────*
         * 3.  Build signers with the exact on-chain algorithms (like single-signer test)
         *───────────────────────────────────────────────────────*/
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposer.privateKeyHex, propKey.signingAlgorithm),
            propKey.hashingAlgorithm
        ).apply {
            address = proposer.addressHex
            keyIndex = proposer.keyIndex
        }
        
        val payerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(payer.privateKeyHex, payKey.signingAlgorithm),
            payKey.hashingAlgorithm
        ).apply {
            address = payer.addressHex
            keyIndex = payer.keyIndex
        }

        val latest = api.getBlockHeader()

        /*───────────────────────────────────────────────────────*
         * 4.  Build transaction using TransactionBuilder (like single-signer test)
         *───────────────────────────────────────────────────────*/
        val tx = TransactionBuilder("""
            transaction(msg: String) {
                prepare(p: auth(Storage) &Account) {
                    log("Proposer ".concat(p.address.toString()))
                    log("Message  ".concat(msg))
                }
            }
        """.trimIndent(), listOf(Cadence.string("Hello, Testnet!")))
            .withProposalKey(proposer.addressHex, proposer.keyIndex, propKey.sequenceNumber.toBigInteger())
            .withPayer(payer.addressHex)
            .withAuthorizers(listOf(proposer.addressHex))
            .withReferenceBlockId(latest.id)
            .build()
        
        println("🔍 MULTI-SIGNER DEBUG:")
        val payloadMsg = tx.payloadMessage()
        println("🔍 Multi-signer PAYLOAD MESSAGE (hex): ${payloadMsg.toHexString()}")
        println("🔍 Multi-signer PAYLOAD MESSAGE length: ${payloadMsg.size} bytes")
        
        // Use the unified sign() method like the working single-signer test
        val signedTx = tx.sign(listOf(proposerSigner, payerSigner))
        
        println("🔍 After signing: payloadSignatures.size = ${signedTx.payloadSignatures.size}, envelopeSignatures.size = ${signedTx.envelopeSignatures.size}")
        
        val envelopeMsg = signedTx.envelopeMessage() 
        println("🔍 Multi-signer ENVELOPE MESSAGE (hex): ${envelopeMsg.toHexString()}")
        println("🔍 Multi-signer ENVELOPE MESSAGE length: ${envelopeMsg.size} bytes")

        /*───────────────────────────────────────────────────────*
         * 5.  Submit and verify SEAL
         *───────────────────────────────────────────────────────*/
        val result = api.sendTransaction(signedTx)
        println("🔍 Multi-signer transaction submitted: ${result.id}")

        val seal = result.id?.let { api.waitForSeal(it) }
        
        val txResult = result.id?.let { api.getTransactionResult(it) }
        if (txResult != null) {
            println("🔍 Multi-signer transaction status: ${txResult.status}")
        }

        if (txResult != null) {
            assertEquals(TransactionStatus.SEALED, txResult.status)
            println("✅ Multi-signer gas sponsored transaction sealed!")
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testBasicSingleSignerTransaction() = runBlocking {
        val accountAddress = "c6de0d94160377cd"
        val account = api.getAccount(accountAddress)
        assertNotNull(account)
        
        // Use the correct private key for this account (same as proposer in gas sponsored test)
        val signerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        val privateKey = Crypto.decodePrivateKey(signerPrivateKey, SigningAlgorithm.ECDSA_P256)
        val signer = Crypto.getSigner(privateKey, HashingAlgorithm.SHA2_256).apply {
            address = accountAddress
            keyIndex = 0
        }
        
        // Get the current sequence number
        val currentSequenceNumber = account.keys?.firstOrNull()?.sequenceNumber?.toBigInteger() ?: throw RuntimeException("No keys")

        val latest  = api.getBlockHeader()

        val tx = TransactionBuilder("""
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Hello, World!")
                }
            }
        """.trimIndent())
            .withProposalKey(accountAddress, 0, currentSequenceNumber)
            .withPayer(accountAddress)
            .withAuthorizers(listOf(accountAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        println("🔍 SINGLE-SIGNER DEBUG:")
        val payloadMsg = tx.payloadMessage()
        println("🔍 Single-signer PAYLOAD MESSAGE (hex): ${payloadMsg.toHexString()}")
        println("🔍 Single-signer PAYLOAD MESSAGE length: ${payloadMsg.size} bytes")
        
        val signedTx = tx.sign(listOf(signer))
        
        println("🔍 After signing: payloadSignatures.size = ${signedTx.payloadSignatures.size}, envelopeSignatures.size = ${signedTx.envelopeSignatures.size}")
        
        val envelopeMsg = signedTx.envelopeMessage() 
        println("🔍 Single-signer ENVELOPE MESSAGE (hex): ${envelopeMsg.toHexString()}")
        println("🔍 Single-signer ENVELOPE MESSAGE length: ${envelopeMsg.size} bytes")
        
        val result = api.sendTransaction(signedTx)
        println("🔍 Single-signer transaction submitted: ${result.id}")

        val seal  = result.id?.let { api.waitForSeal(it) }
        
        val txResult = result.id?.let { api.getTransactionResult(it) }
        if (txResult != null) {
            println("🔍 Single-signer transaction status: ${txResult.status}")
        }

        if (txResult != null) {
            assertTrue(txResult.status == TransactionStatus.PENDING || txResult.status == TransactionStatus.FINALIZED || txResult.status == TransactionStatus.EXECUTED || txResult.status == TransactionStatus.SEALED)
        }


    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testProposerCanSignAlone() = runBlocking {
        // Test that the proposer account can sign a transaction by itself
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        
        val account = api.getAccount(proposerAddress)
        val accountKey = account.keys!!.first { it.index.toInt() == 0 }
        
        val signer = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, accountKey.signingAlgorithm),
            accountKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        val tx = TransactionBuilder("""
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Proposer solo test")
                }
            }
        """.trimIndent())
            .withProposalKey(proposerAddress, 0, accountKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        val signedTx = tx.sign(listOf(signer))
        println("🔍 Proposer solo: payloadSignatures.size = ${signedTx.payloadSignatures.size}, envelopeSignatures.size = ${signedTx.envelopeSignatures.size}")
        
        val result = api.sendTransaction(signedTx)
        println("🔍 Proposer solo transaction submitted: ${result.id}")
        
        val seal = result.id?.let { api.waitForSeal(it) }
        if (seal != null) {
            println("🔍 Proposer solo transaction sealed: ${seal.status}")
            assertEquals(TransactionStatus.SEALED, seal.status)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testPayerCanSignAlone() = runBlocking {
        // Test that the payer account can sign a transaction by itself
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"
        
        val account = api.getAccount(payerAddress)
        val accountKey = account.keys!!.first { it.index.toInt() == 0 }
        
        val signer = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, accountKey.signingAlgorithm),
            accountKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        val tx = TransactionBuilder("""
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Payer solo test")
                }
            }
        """.trimIndent())
            .withProposalKey(payerAddress, 0, accountKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(payerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        val signedTx = tx.sign(listOf(signer))
        println("🔍 Payer solo: payloadSignatures.size = ${signedTx.payloadSignatures.size}, envelopeSignatures.size = ${signedTx.envelopeSignatures.size}")
        
        val result = api.sendTransaction(signedTx)
        println("🔍 Payer solo transaction submitted: ${result.id}")
        
        val seal = result.id?.let { api.waitForSeal(it) }
        if (seal != null) {
            println("🔍 Payer solo transaction sealed: ${seal.status}")
            assertEquals(TransactionStatus.SEALED, seal.status)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testManualStepByStepMultiSigner() = runBlocking {
        // Test the JVM SDK approach: step by step signature addition
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"
        
        val proposerAccount = api.getAccount(proposerAddress)
        val payerAccount = api.getAccount(payerAddress)
        
        val propKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        val payKey = payerAccount.keys!!.first { it.index.toInt() == 0 }
        
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, propKey.signingAlgorithm),
            propKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val payerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, payKey.signingAlgorithm),
            payKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        // Step 1: Create unsigned transaction
        val unsignedTx = TransactionBuilder("""
            transaction(msg: String) {
                prepare(p: auth(Storage) &Account) {
                    log("Manual step by step: ".concat(msg))
                }
            }
        """.trimIndent(), listOf(Cadence.string("Hello!")))
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        println("🔍 MANUAL STEP-BY-STEP DEBUG:")
        println("🔍 Unsigned tx: payloadSignatures.size = ${unsignedTx.payloadSignatures.size}, envelopeSignatures.size = ${unsignedTx.envelopeSignatures.size}")
        
        // Step 2: Add payload signature (proposer signs payload)
        val withPayloadSig = unsignedTx.addPayloadSignature(proposerAddress, 0, proposerSigner)
        println("🔍 After payload sig: payloadSignatures.size = ${withPayloadSig.payloadSignatures.size}, envelopeSignatures.size = ${withPayloadSig.envelopeSignatures.size}")
        
        // Step 3: Add envelope signature (payer signs envelope)
        val fullySignedTx = withPayloadSig.addEnvelopeSignature(payerAddress, 0, payerSigner)
        println("🔍 After envelope sig: payloadSignatures.size = ${fullySignedTx.payloadSignatures.size}, envelopeSignatures.size = ${fullySignedTx.envelopeSignatures.size}")
        
        // Step 4: Submit
        val result = api.sendTransaction(fullySignedTx)
        println("🔍 Manual step-by-step transaction submitted: ${result.id}")
        
        val seal = result.id?.let { api.waitForSeal(it) }
        if (seal != null) {
            println("🔍 Manual step-by-step transaction sealed: ${seal.status}")
            assertEquals(TransactionStatus.SEALED, seal.status)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testRLPEncodingComparison() = runBlocking {
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        
        val payerAddress = "10711015c370a95c"
        val payerPrivateKey = "38ebd09b83e221e406b176044a65350333b3a5280ed3f67227bd80d55ac91a0f"
        
        val proposerAccount = api.getAccount(proposerAddress)
        val payerAccount = api.getAccount(payerAddress)
        
        val propKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        val payKey = payerAccount.keys!!.first { it.index.toInt() == 0 }
        
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, propKey.signingAlgorithm),
            propKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val payerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(payerPrivateKey, payKey.signingAlgorithm),
            payKey.hashingAlgorithm
        ).apply {
            address = payerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        // Create the exact same transaction structure as the JVM SDK example
        val tx = TransactionBuilder("""
            transaction(msg: String) {
                prepare(p: auth(Storage) &Account) {
                    log("RLP comparison: ".concat(msg))
                }
            }
        """.trimIndent(), listOf(Cadence.string("Hello!")))
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        println("🔍 RLP ENCODING COMPARISON:")
        println("🔍 Transaction:")
        println("🔍   Proposer: $proposerAddress (also authorizer)")
        println("🔍   Payer: $payerAddress")
        println("🔍   Reference Block: ${latest.id}")
        println("🔍   Script: ${tx.script}")
        println("🔍   Arguments: ${tx.arguments}")
        
        // Debug the payload RLP structure
        val payload = tx.payload()
        println("🔍 PAYLOAD STRUCTURE:")
        payload.forEachIndexed { index, rlpType ->
            when (index) {
                0 -> println("🔍   [0] Script: ${tx.script}")
                1 -> println("🔍   [1] Arguments: ${tx.arguments}")
                2 -> println("🔍   [2] Reference Block ID: ${tx.referenceBlockId}")
                3 -> println("🔍   [3] Gas Limit: ${tx.gasLimit}")
                4 -> println("🔍   [4] Proposer Address: ${tx.proposalKey.address}")
                5 -> println("🔍   [5] Proposer Key Index: ${tx.proposalKey.keyIndex}")
                6 -> println("🔍   [6] Proposer Sequence Number: ${tx.proposalKey.sequenceNumber}")
                7 -> println("🔍   [7] Payer Address: ${tx.payer}")
                8 -> println("🔍   [8] Authorizers: ${tx.authorizers}")
            }
        }
        
        // Show RLP encoding at each step
        val payloadRLP = org.onflow.flow.rlp.RLPList(payload)
        val payloadEncoded = payloadRLP.encode()
        println("🔍 PAYLOAD RLP encoded (${payloadEncoded.size} bytes): ${payloadEncoded.toHexString()}")
        
        val payloadMessage = tx.payloadMessage()
        println("🔍 PAYLOAD MESSAGE with domain tag (${payloadMessage.size} bytes): ${payloadMessage.toHexString()}")
        
        // Add payload signature manually and show intermediate state
        val payloadWithSig = tx.addPayloadSignature(proposerAddress, 0, proposerSigner)
        println("🔍 After adding payload signature:")
        payloadWithSig.payloadSignatures.forEach { sig ->
            println("🔍   - Address: ${sig.address}, KeyIndex: ${sig.keyIndex}, Signature: ${sig.signature}")
        }
        
        // Show envelope structure
        println("🔍 ENVELOPE STRUCTURE:")
        val envelopeComponents = listOf(
            org.onflow.flow.rlp.RLPList(payload),
            org.onflow.flow.rlp.RLPList(
                payloadWithSig.payloadSignatures.map {
                    listOf(
                        io.ktor.util.hex(it.address).paddingZeroLeft().toRLP(),
                        it.keyIndex.toRLP(),
                        io.ktor.util.hex(it.signature).toRLP()
                    ).toRLP()
                }
            )
        )
        
        val envelopeRLP = org.onflow.flow.rlp.RLPList(envelopeComponents)
        val envelopeEncoded = envelopeRLP.encode()
        println("🔍 ENVELOPE RLP encoded (${envelopeEncoded.size} bytes): ${envelopeEncoded.toHexString()}")
        
        val envelopeMessage = payloadWithSig.envelopeMessage()
        println("🔍 ENVELOPE MESSAGE with domain tag (${envelopeMessage.size} bytes): ${envelopeMessage.toHexString()}")
        
        // Compare with single-signer case (should work)
        println("🔍 SINGLE-SIGNER COMPARISON:")
        val singleSignerTx = TransactionBuilder("""
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Single signer test")
                }
            }
        """.trimIndent())
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        val singlePayloadMessage = singleSignerTx.payloadMessage()
        println("🔍 Single-signer PAYLOAD MESSAGE (${singlePayloadMessage.size} bytes): ${singlePayloadMessage.toHexString()}")
        
        val singleSignedTx = singleSignerTx.sign(listOf(proposerSigner))
        val singleEnvelopeMessage = singleSignedTx.envelopeMessage()
        println("🔍 Single-signer ENVELOPE MESSAGE (${singleEnvelopeMessage.size} bytes): ${singleEnvelopeMessage.toHexString()}")
        
        // Compare the patterns
        println("🔍 COMPARISON SUMMARY:")
        println("🔍 Multi-signer payload length: ${payloadMessage.size}")
        println("🔍 Single-signer payload length: ${singlePayloadMessage.size}")
        println("🔍 Multi-signer envelope length: ${envelopeMessage.size}")
        println("🔍 Single-signer envelope length: ${singleEnvelopeMessage.size}")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testPayloadMessageDebug() = runBlocking {
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        
        val payerAddress = "10711015c370a95c"
        
        val proposerAccount = api.getAccount(proposerAddress)
        val propKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, propKey.signingAlgorithm),
            propKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        // Use IDENTICAL transaction content - only difference is payer address
        val commonScript = """
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Payload test")
                }
            }
        """.trimIndent()
        
        // Case 1: Single-signer (working) - proposer = payer
        val singleSignerTx = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)  // Same as proposer
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        // Case 2: Multi-signer (failing) - proposer ≠ payer
        val multiSignerTx = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)  // Different from proposer
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        println("🔍 PAYLOAD MESSAGE COMPARISON (identical content, different payer):")
        
        val singlePayloadMsg = singleSignerTx.payloadMessage()
        val multiPayloadMsg = multiSignerTx.payloadMessage()
        
        println("🔍 Single-signer payload message (${singlePayloadMsg.size} bytes):")
        println("🔍   ${singlePayloadMsg.toHexString()}")
        
        println("🔍 Multi-signer payload message (${multiPayloadMsg.size} bytes):")
        println("🔍   ${multiPayloadMsg.toHexString()}")
        
        // Test signing the SAME proposer with both messages
        val singleSig = proposerSigner.sign(singlePayloadMsg)
        val multiSig = proposerSigner.sign(multiPayloadMsg)
        
        println("🔍 Single-signer signature: ${singleSig.toHexString()}")
        println("🔍 Multi-signer signature: ${multiSig.toHexString()}")
        
        // The signatures SHOULD be different because the payer field is different
        val signaturesMatch = singleSig.contentEquals(multiSig)
        println("🔍 Signatures match: $signaturesMatch (expected: false due to different payer)")
        
        // Now test if the proposer can create a VALID signature for the multi-signer case
        println("🔍 Testing if proposer can create valid payload signature for multi-signer transaction...")
        
        // Get the payload message that direct signing used
        val directPayloadMsg = multiSignerTx.payloadMessage()
        println("🔍 Direct payload message: ${directPayloadMsg.toHexString()}")
        
        // Create a payload signature manually using addPayloadSignature
        val testTx = multiSignerTx.addPayloadSignature(proposerAddress, 0, proposerSigner)
        println("🔍 Payload signature created: ${testTx.payloadSignatures.first().signature}")
        
        // Get the payload message that addPayloadSignature would have used
        val addPayloadMsg = multiSignerTx.payloadMessage()  // This should be the same
        println("🔍 addPayloadSignature payload message: ${addPayloadMsg.toHexString()}")
        
        // Check if the messages are identical
        val messagesMatch = directPayloadMsg.contentEquals(addPayloadMsg)
        println("🔍 Payload messages identical: $messagesMatch")
        
        // If messages are identical, manually sign the same message and compare
        if (messagesMatch) {
            val manualSig = proposerSigner.sign(directPayloadMsg)
            println("🔍 Manual signature of same message: ${manualSig.toHexString()}")
            val manualMatches = manualSig.toHexString() == testTx.payloadSignatures.first().signature
            println("🔍 Manual signature matches addPayloadSignature: $manualMatches")
        }
        
        // Compare with what we got from direct signing
        val directSigMatches = testTx.payloadSignatures.first().signature == multiSig.toHexString()
        println("🔍 Direct sign matches addPayloadSignature: $directSigMatches")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testPayloadSignatureDebug() = runBlocking {
        val proposerAddress = "c6de0d94160377cd"
        val proposerPrivateKey = "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9"
        
        val payerAddress = "10711015c370a95c"
        
        val proposerAccount = api.getAccount(proposerAddress)
        val propKey = proposerAccount.keys!!.first { it.index.toInt() == 0 }
        
        val proposerSigner = Crypto.getSigner(
            Crypto.decodePrivateKey(proposerPrivateKey, propKey.signingAlgorithm),
            propKey.hashingAlgorithm
        ).apply {
            address = proposerAddress
            keyIndex = 0
        }
        
        val latest = api.getBlockHeader()
        
        println("🔍 PAYLOAD SIGNATURE DEBUG:")
        println("🔍 Proposer account: $proposerAddress")
        println("🔍 Proposer key sequence: ${propKey.sequenceNumber}")
        println("🔍 Reference block: ${latest.id}")
        
        // Create IDENTICAL transactions except for payer
        val commonScript = """
            transaction {
                prepare(signer: auth(Storage) &Account) {
                    log("Test")
                }
            }
        """.trimIndent()
        
        // Working case: single-signer (proposer = payer)
        val singleSignerTx = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(proposerAddress)  // Same as proposer - this works
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        // Failing case: multi-signer (proposer ≠ payer)
        val multiSignerTx = TransactionBuilder(commonScript)
            .withProposalKey(proposerAddress, 0, propKey.sequenceNumber.toBigInteger())
            .withPayer(payerAddress)  // Different from proposer - this fails
            .withAuthorizers(listOf(proposerAddress))
            .withReferenceBlockId(latest.id)
            .build()
        
        // Get payload messages
        val singlePayloadMsg = singleSignerTx.payloadMessage()
        val multiPayloadMsg = multiSignerTx.payloadMessage()
        
        println("🔍 Single-signer payload message (${singlePayloadMsg.size} bytes):")
        println("🔍   ${singlePayloadMsg.toHexString()}")
        
        println("🔍 Multi-signer payload message (${multiPayloadMsg.size} bytes):")
        println("🔍   ${multiPayloadMsg.toHexString()}")
        
        // Create signatures with the SAME signer (proposer) for both messages
        val singleSig = proposerSigner.sign(singlePayloadMsg)
        val multiSig = proposerSigner.sign(multiPayloadMsg)
        
        println("🔍 Single-signer signature: ${singleSig.toHexString()}")
        println("🔍 Multi-signer signature: ${multiSig.toHexString()}")
        
        // Test single-signer transaction (should work)
        println("🔍 Testing single-signer transaction...")
        val singleSignedTx = singleSignerTx.sign(listOf(proposerSigner))
        val singleResult = api.sendTransaction(singleSignedTx)
        println("🔍 Single-signer transaction submitted: ${singleResult.id}")
        
        // Test multi-signer payload signature manually
        println("🔍 Testing multi-signer payload signature manually...")
        val multiWithPayloadSig = multiSignerTx.addPayloadSignature(proposerAddress, 0, proposerSigner)
        
        // Log what we created
        println("🔍 Multi-signer payload signature created:")
        println("🔍   Address: ${multiWithPayloadSig.payloadSignatures.first().address}")
        println("🔍   KeyIndex: ${multiWithPayloadSig.payloadSignatures.first().keyIndex}")
        println("🔍   Signature: ${multiWithPayloadSig.payloadSignatures.first().signature}")
        
        // Compare the signatures
        val addPayloadSigMatches = multiWithPayloadSig.payloadSignatures.first().signature == multiSig.toHexString()
        println("🔍 addPayloadSignature matches manual sign: $addPayloadSigMatches")
        
        // Also test if the exact same message produces the same signature when signed again
        val multiSig2 = proposerSigner.sign(multiPayloadMsg)
        val signaturesConsistent = multiSig.toHexString() == multiSig2.toHexString()
        println("🔍 Signatures consistent across calls: $signaturesConsistent")
        
        // Check if our KMM signatures are the expected length (should be 64 bytes for P256)
        println("🔍 Single signature length: ${singleSig.size} bytes")
        println("🔍 Multi signature length: ${multiSig.size} bytes")
    }

}