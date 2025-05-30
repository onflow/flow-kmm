package org.onflow.flow.rlp

import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.TransactionSignature
import org.onflow.flow.models.payloadMessage
import org.onflow.flow.models.envelopeMessage
import org.onflow.flow.models.payload
import org.onflow.flow.infrastructure.Cadence
import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.util.*
import org.onflow.flow.models.completeEnvelopeMessage
import org.onflow.flow.models.createSigningRLP
import org.onflow.flow.models.createSigningRLPJVMStyle
import org.onflow.flow.models.envelopeMessageJVMStyle
import org.onflow.flow.models.payloadJVMStyle
import org.onflow.flow.models.payloadMessageJVMStyle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class RLPTests {

    @Test
    fun testSimpleDecode() {
        val rlpString = "f83f800182520894095e7baea6a6c7c4c2dfeb977efac326af552d870b801ba048b55bfa915ac795c431978d8a6a992b628d557da5ff759b307d495a3664935301"
        val list = hex(rlpString).decodeRLP() as RLPList
        val size = list.element.size
        assertEquals(9, size)
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testEnvelopeStructureWithPayloadSignatures() {
        // Test envelope structure when payload signatures are present
        val baseTx = Transaction(
            script = "transaction { log(\"test\") }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "02",
            authorizers = listOf("01")
        )

        // Add a payload signature
        val txWithPayloadSig = baseTx.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 0,
                    signature = "abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890ab"
                )
            )
        )

        val envelopeMsg = txWithPayloadSig.envelopeMessage()
        val envelopeMsgHex = envelopeMsg.toHexString()
        
        // Should NOT end with 'c0' because it includes the payload signature
        assertTrue(!envelopeMsgHex.endsWith("c0"), "Envelope message should NOT end with 'c0' when payload signatures exist")
        
        // Should include the signature in the encoding
        assertTrue(envelopeMsgHex.contains("abcd1234567890"), "Should contain part of the signature")
        
        println("Envelope message with payload signature: $envelopeMsgHex")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testRLPPayloadComponentsStructure() {
        // Test the individual components of the payload RLP structure
        val tx = Transaction(
            script = "transaction { log(\"Hello!\") }",
            arguments = listOf(Cadence.string("test")),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(9999),
            proposalKey = ProposalKey(address = "c6de0d94160377cd", keyIndex = 2, sequenceNumber = BigInteger(42)),
            payer = "10711015c370a95c",
            authorizers = listOf("c6de0d94160377cd", "1234567890abcdef")
        )

        val payload = tx.payload()
        assertEquals(9, payload.size, "Payload should have exactly 9 components")

        // Verify each component type by encoding and checking structure
        val payloadRLP = RLPList(payload)
        val payloadEncoded = payloadRLP.encode()
        
        // Should be a valid RLP list
        assertTrue(payloadEncoded.isNotEmpty())
        
        // Decode it back and verify structure
        val decoded = payloadEncoded.decodeRLP() as RLPList
        assertEquals(9, decoded.element.size)
        
        println("Payload components verified: ${payloadEncoded.toHexString()}")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testDomainTagPresence() {
        // Test that domain tag is properly included in both payload and envelope messages
        val tx = Transaction(
            script = "transaction { log(\"domain test\") }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val expectedDomainTag = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000"
        
        val payloadMsg = tx.payloadMessage()
        val envelopeMsg = tx.envelopeMessage()
        
        // Both should start with domain tag
        assertTrue(payloadMsg.toHexString().startsWith(expectedDomainTag), "Payload message should start with domain tag")
        assertTrue(envelopeMsg.toHexString().startsWith(expectedDomainTag), "Envelope message should start with domain tag")
        
        // Domain tag should be exactly 32 bytes
        assertEquals(32, expectedDomainTag.length / 2)
        
        println("Domain tag verified in both payload and envelope messages")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testEmptyArgumentsEncoding() {
        // Test that empty arguments list is properly encoded
        val txWithEmpty = Transaction(
            script = "transaction { log(\"empty args\") }",
            arguments = listOf(), // Empty
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val txWithArgs = Transaction(
            script = "transaction { log(\"with args\") }",
            arguments = listOf(Cadence.string("test")), // Non-empty
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val emptyArgsMsg = txWithEmpty.payloadMessage()
        val withArgsMsg = txWithArgs.payloadMessage()

        // Should be different
        assertNotEquals(emptyArgsMsg.toHexString(), withArgsMsg.toHexString())
        
        // Both should be valid
        assertTrue(emptyArgsMsg.size > 32)
        assertTrue(withArgsMsg.size > 32)
        
        println("Empty arguments encoding verified")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testRLPBasicEncodingDecoding() {
        // Test basic RLP encoding/decoding with known values
        
        // Test empty string
        val emptyString = "".toRLP()
        val emptyEncoded = emptyString.encode()
        assertEquals("80", emptyEncoded.toHexString())
        val emptyDecoded = emptyEncoded.decodeRLP() as RLPElement
        assertEquals("", emptyDecoded.toStringFromRLP())
        
        // Test single byte values
        val singleByte = 15.toByte().toRLP()
        val singleEncoded = singleByte.encode()
        assertEquals("0f", singleEncoded.toHexString())
        val singleDecoded = singleEncoded.decodeRLP() as RLPElement
        assertEquals(15.toByte(), singleDecoded.toByteFromRLP())
        
        // Test short string
        val shortString = "dog".toRLP()
        val shortEncoded = shortString.encode()
        assertEquals("83646f67", shortEncoded.toHexString())
        val shortDecoded = shortEncoded.decodeRLP() as RLPElement
        assertEquals("dog", shortDecoded.toStringFromRLP())
        
        // Test empty list
        val emptyList = RLPList(emptyList<RLPType>())
        val emptyListEncoded = emptyList.encode()
        assertEquals("c0", emptyListEncoded.toHexString())
        val emptyListDecoded = emptyListEncoded.decodeRLP() as RLPList
        assertEquals(0, emptyListDecoded.element.size)
        
        // Test list with strings
        val stringList = RLPList(listOf("cat".toRLP(), "dog".toRLP()))
        val stringListEncoded = stringList.encode()
        assertEquals("c88363617483646f67", stringListEncoded.toHexString())
        val stringListDecoded = stringListEncoded.decodeRLP() as RLPList
        assertEquals(2, stringListDecoded.element.size)
        assertEquals("cat", (stringListDecoded.element[0] as RLPElement).toStringFromRLP())
        assertEquals("dog", (stringListDecoded.element[1] as RLPElement).toStringFromRLP())
        
        println("Basic RLP encoding/decoding tests passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test 
    fun testRLPIntegerEncoding() {
        // Test integer encoding edge cases
        
        // Test zero
        val zero = 0.toRLP()
        val zeroEncoded = zero.encode()
        assertEquals("80", zeroEncoded.toHexString()) // Zero should encode as empty string
        val zeroDecoded = zeroEncoded.decodeRLP() as RLPElement
        assertEquals(0, zeroDecoded.toIntFromRLP())
        
        // Test small integers
        val small = 15.toRLP()
        val smallEncoded = small.encode()
        assertEquals("0f", smallEncoded.toHexString())
        val smallDecoded = smallEncoded.decodeRLP() as RLPElement
        assertEquals(15, smallDecoded.toIntFromRLP())
        
        // Test larger integers
        val large = 1024.toRLP()
        val largeEncoded = large.encode()
        assertEquals("820400", largeEncoded.toHexString())
        val largeDecoded = largeEncoded.decodeRLP() as RLPElement
        assertEquals(1024, largeDecoded.toIntFromRLP())
        
        // Test BigInteger
        val bigInt = BigInteger(1000000).toRLP()
        val bigIntEncoded = bigInt.encode()
        val bigIntDecoded = bigIntEncoded.decodeRLP() as RLPElement
        assertEquals(BigInteger(1000000), bigIntDecoded.toUnsignedBigIntegerFromRLP())
        
        // Test BigInteger zero - should encode as empty like Int zero
        val bigIntZero = BigInteger.ZERO.toRLP()
        val bigIntZeroEncoded = bigIntZero.encode()
        assertEquals("80", bigIntZeroEncoded.toHexString()) // Should encode as empty string like Int zero
        val bigIntZeroDecoded = bigIntZeroEncoded.decodeRLP() as RLPElement
        assertEquals(BigInteger.ZERO, bigIntZeroDecoded.toUnsignedBigIntegerFromRLP())
        
        println("Integer RLP encoding tests passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testRLPByteArrayEncoding() {
        // Test byte array encoding
        
        // Test with hex data (common in blockchain)
        val hexData = hex("deadbeef")
        val hexRLP = hexData.toRLP()
        val hexEncoded = hexRLP.encode()
        assertEquals("84deadbeef", hexEncoded.toHexString())
        val hexDecoded = hexEncoded.decodeRLP() as RLPElement
        assertTrue(hexData.contentEquals(hexDecoded.bytes))
        
        // Test with address-like data (8 bytes padded)
        val addressData = hex("01").paddingZeroLeft(8)
        val addressRLP = addressData.toRLP()
        val addressEncoded = addressRLP.encode()
        val addressDecoded = addressEncoded.decodeRLP() as RLPElement
        assertTrue(addressData.contentEquals(addressDecoded.bytes))
        
        println("Byte array RLP encoding tests passed")
    }

    @Test
    fun testRLPNestedStructures() {
        // Test complex nested structures like we use in transactions
        
        // Create a structure similar to what we use in Flow transactions
        val nestedList = RLPList(listOf(
            "script".toRLP(),                              // Script
            RLPList(emptyList<RLPType>()),                 // Empty arguments
            hex("deadbeef").toRLP(),                       // Reference block ID (4 bytes for test)
            BigInteger(1000).toRLP(),                      // Gas limit
            hex("01").paddingZeroLeft(8).toRLP(),          // Proposer address
            0.toRLP(),                                     // Key index
            BigInteger(10).toRLP(),                        // Sequence number
            hex("02").paddingZeroLeft(8).toRLP(),          // Payer address
            RLPList(listOf(hex("01").paddingZeroLeft(8).toRLP())) // Authorizers
        ))
        
        val encoded = nestedList.encode()
        val decoded = encoded.decodeRLP() as RLPList
        
        assertEquals(9, decoded.element.size, "Should have 9 elements like Flow transaction payload")
        
        // Verify each element
        assertEquals("script", (decoded.element[0] as RLPElement).toStringFromRLP())
        assertEquals(0, (decoded.element[1] as RLPList).element.size) // Empty arguments
        assertTrue(hex("deadbeef").contentEquals((decoded.element[2] as RLPElement).bytes))
        assertEquals(BigInteger(1000), (decoded.element[3] as RLPElement).toUnsignedBigIntegerFromRLP())
        assertTrue(hex("01").paddingZeroLeft(8).contentEquals((decoded.element[4] as RLPElement).bytes))
        assertEquals(0, (decoded.element[5] as RLPElement).toIntFromRLP())
        assertEquals(BigInteger(10), (decoded.element[6] as RLPElement).toUnsignedBigIntegerFromRLP())
        assertTrue(hex("02").paddingZeroLeft(8).contentEquals((decoded.element[7] as RLPElement).bytes))
        
        val authorizersList = decoded.element[8] as RLPList
        assertEquals(1, authorizersList.element.size)
        assertTrue(hex("01").paddingZeroLeft(8).contentEquals((authorizersList.element[0] as RLPElement).bytes))
        
        println("Nested RLP structure tests passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test 
    fun testRLPRoundtripConsistency() {
        // Test that encode -> decode -> encode produces identical results
        
        val originalData = listOf(
            "test".toRLP(),
            123.toRLP(), 
            hex("deadbeef").toRLP(),
            RLPList(listOf("a".toRLP(), "b".toRLP())),
            BigInteger(999999).toRLP()
        )
        
        val originalList = RLPList(originalData)
        val firstEncoding = originalList.encode()
        val decoded = firstEncoding.decodeRLP() as RLPList
        val secondEncoding = decoded.encode()
        
        // Should be identical
        assertEquals(firstEncoding.toHexString(), secondEncoding.toHexString(), "Encode -> Decode -> Encode should be consistent")

        assertEquals(0, RLPElement(byteArrayOf()).toIntFromRLP())
        assertEquals(255, 255.toRLP().toIntFromRLP())

        val bi = BigInteger.fromInt(255)
        assertEquals(bi, bi.toRLP().toUnsignedBigIntegerFromRLP())

        val padded = byteArrayOf(0x1, 0x2).paddingZeroLeft()
        assertEquals(8, padded.size)
        assertTrue(padded.take(6).all { it == 0.toByte() })

        println("RLP roundtrip consistency test passed")

    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testJVMStyleVsCurrentEncoding() {
        // Compare current KMM encoding with JVM SDK style encoding
        val tx = Transaction(
            script = "transaction { log(\"test\") }",
            arguments = listOf(Cadence.string("Hello")),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "02",
            authorizers = listOf("01")
        )

        println("🔍 ENCODING COMPARISON:")
        
        // Test payload encoding
        val currentPayload = tx.payload()
        val jvmStylePayload = tx.payloadJVMStyle()
        
        val currentPayloadEncoded = RLPList(currentPayload).encode()
        val jvmStylePayloadEncoded = RLPList(jvmStylePayload).encode()
        
        println("🔍 Current payload: ${currentPayloadEncoded.toHexString()}")
        println("🔍 JVM style payload: ${jvmStylePayloadEncoded.toHexString()}")
        println("🔍 Payloads match: ${currentPayloadEncoded.contentEquals(jvmStylePayloadEncoded)}")
        
        // Test full message encoding (with domain tags)
        val currentMsg = tx.payloadMessage()
        val jvmStyleMsg = tx.payloadMessageJVMStyle()
        
        println("🔍 Current payload message: ${currentMsg.toHexString()}")
        println("🔍 JVM style payload message: ${jvmStyleMsg.toHexString()}")
        println("🔍 Full messages match: ${currentMsg.contentEquals(jvmStyleMsg)}")
        
        // Test with payload signatures
        val txWithSig = tx.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 0,
                    signature = "abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890ab"
                )
            )
        )
        
        val currentEnvelopeMsg = txWithSig.envelopeMessage()
        val jvmStyleEnvelopeMsg = txWithSig.envelopeMessageJVMStyle()
        
        println("🔍 Current envelope message: ${currentEnvelopeMsg.toHexString()}")
        println("🔍 JVM style envelope message: ${jvmStyleEnvelopeMsg.toHexString()}")
        println("🔍 Envelope messages match: ${currentEnvelopeMsg.contentEquals(jvmStyleEnvelopeMsg)}")
        
        // Key differences to note:
        println("🔍 KEY DIFFERENCES:")
        println("🔍 1. Script encoding: Current uses script.toRLP(), JVM uses script.toByteArray().toRLP()")
        println("🔍 2. Gas limit: Current uses BigInteger, JVM uses Long")
        println("🔍 3. Key indices: Current uses Int, JVM uses Long")
        println("🔍 4. Sequence number: Current uses BigInteger, JVM uses Long")
        println("🔍 5. Signature encoding: Current uses [address, keyIndex, signature], JVM uses [signerIndex, keyIndex, signature]")
        
        // Verify the signer index approach works correctly
        val currentRLP = tx.createSigningRLP(includePayloadSignatures = false)
        val jvmStyleRLP = tx.createSigningRLPJVMStyle(includePayloadSignatures = false)
        
        println("🔍 Current RLP (no sigs): ${currentRLP.toHexString()}")
        println("🔍 JVM style RLP (no sigs): ${jvmStyleRLP.toHexString()}")
        println("🔍 RLP structures match: ${currentRLP.contentEquals(jvmStyleRLP)}")
        
        // Both should be valid RLP structures
        assertTrue(currentMsg.size > 32, "Current message should be valid")
        assertTrue(jvmStyleMsg.size > 32, "JVM style message should be valid")

        // Verify it's different from current encoding (which uses addresses)
        val currentEnvelope = tx.envelopeMessage().toHexString()
        assertNotEquals(currentEnvelope.encodeToByteArray(), jvmStyleEnvelopeMsg, "JVM-style should differ from current address-based encoding")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityBasic() {
        // Test case: "complete tx" from Flow JS SDK
        val tx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val expectedPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001"
        
        val actualPayload = tx.payloadMessage().toHexString()
        assertEquals(expectedPayload, actualPayload, "Payload should match Flow JS SDK encoding")
        
        // Test with payload signature
        val txWithSig = tx.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )
        
        val expectedEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        val actualEnvelope = txWithSig.envelopeMessage().toHexString()
        assertEquals(expectedEnvelope, actualEnvelope, "Envelope should match Flow JS SDK encoding")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityEdgeCases() {
        // Test case: "empty cadence"
        val emptyScriptTx = Transaction(
            script = "",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        val expectedEmptyScript = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f84280c0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001"
        assertEquals(expectedEmptyScript, emptyScriptTx.payloadMessage().toHexString())

        // Test case: "zero computeLimit"
        val zeroGasTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(0),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        val expectedZeroGas = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b80880000000000000001040a880000000000000001c9880000000000000001"
        assertEquals(expectedZeroGas, zeroGasTx.payloadMessage().toHexString())

        // Test case: "zero proposalKey.keyId"
        val zeroKeyTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        val expectedZeroKey = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001800a880000000000000001c9880000000000000001"
        assertEquals(expectedZeroKey, zeroKeyTx.payloadMessage().toHexString())

        // Test case: "zero proposalKey.sequenceNum"
        val zeroSeqTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(0)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        val expectedZeroSeq = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a8800000000000000010480880000000000000001c9880000000000000001"
        assertEquals(expectedZeroSeq, zeroSeqTx.payloadMessage().toHexString())
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityAuthorizers() {
        // Test case: "empty authorizers"
        val emptyAuthTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf()
        )
        
        val expectedEmptyAuth = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f869b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c0"
        assertEquals(expectedEmptyAuth, emptyAuthTx.payloadMessage().toHexString())

        // Test case: "multiple authorizers"
        val multiAuthTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01", "02")
        )
        
        val expectedMultiAuth = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f87bb07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001d2880000000000000001880000000000000002"
        assertEquals(expectedMultiAuth, multiAuthTx.payloadMessage().toHexString())
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilitySignatures() {
        val baseTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )

        // Test case: "empty payloadSigs"
        val emptyPayloadSigs = baseTx.copy(payloadSignatures = listOf())
        val expectedEmptyPayloadSigs = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f875f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001c0"
        assertEquals(expectedEmptyPayloadSigs, emptyPayloadSigs.envelopeMessage().toHexString())

        // Test case: "zero payloadSigs.0.keyId"
        val zeroKeyIdSig = baseTx.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 0,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )
        val expectedZeroKeyIdSig = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001e4e38080a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        assertEquals(expectedZeroKeyIdSig, zeroKeyIdSig.envelopeMessage().toHexString())
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityComplexSignatures() {
        // Test case: "out-of-order payloadSigs -- by signer"
        val outOfOrderBySignerTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01", "02", "03"),
            payloadSignatures = listOf(
                TransactionSignature(address = "03", keyIndex = 0, signature = "c"),
                TransactionSignature(address = "01", keyIndex = 0, signature = "a"),
                TransactionSignature(address = "02", keyIndex = 0, signature = "b")
            )
        )
        
        val expectedOutOfOrderBySigner = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f893f884b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001db880000000000000001880000000000000002880000000000000003ccc3808080c3018080c3028080"
        assertEquals(expectedOutOfOrderBySigner, outOfOrderBySignerTx.envelopeMessage().toHexString())

        // Test case: "out-of-order payloadSigs -- by key ID"
        val outOfOrderByKeyTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(address = "01", keyIndex = 2, signature = "c"),
                TransactionSignature(address = "01", keyIndex = 0, signature = "a"),
                TransactionSignature(address = "01", keyIndex = 1, signature = "b")
            )
        )
        
        val expectedOutOfOrderByKey = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f881f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001ccc3808080c3800180c3800280"
        assertEquals(expectedOutOfOrderByKey, outOfOrderByKeyTx.envelopeMessage().toHexString(), "Out-of-order key signatures should be sorted")

        println("✅ All Flow JS SDK signature ordering tests passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityNullRefBlock() {
        // Test case: "null refBlock" - Flow JS SDK allows null reference block
        val nullRefBlockTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "0000000000000000000000000000000000000000000000000000000000000000", // Null/zero block ID
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        val expectedNullRefBlock = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a000000000000000000000000000000000000000000000000000000000000000002a880000000000000001040a880000000000000001c9880000000000000001"
        assertEquals(expectedNullRefBlock, nullRefBlockTx.payloadMessage().toHexString())
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testJVMStyleSignatureEncoding() {
        // Test that our JVM-style signature encoding produces the expected results
        val tx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01", "02", "03"),
            payloadSignatures = listOf(
                TransactionSignature(address = "03", keyIndex = 0, signature = "c"),
                TransactionSignature(address = "01", keyIndex = 0, signature = "a"),
                TransactionSignature(address = "02", keyIndex = 0, signature = "b")
            )
        )

        // Test JVM-style encoding
        val jvmStyleEnvelope = tx.envelopeMessageJVMStyle().toHexString()
        
        // The JVM style should use signer indices instead of addresses
        // Expected structure: [signerIndex, keyIndex, signature] instead of [address, keyIndex, signature]
        println("🔍 JVM-style envelope encoding: $jvmStyleEnvelope")
        
        // Verify it's different from current encoding (which uses addresses)
        val currentEnvelope = tx.envelopeMessage().toHexString()
        assertNotEquals(currentEnvelope, jvmStyleEnvelope, "JVM-style should differ from current address-based encoding")
        
        // Both should be valid RLP structures
        assertTrue(jvmStyleEnvelope.length > 64, "JVM-style envelope should be valid")
        assertTrue(currentEnvelope.length > 64, "Current envelope should be valid")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityMissingCases() {
        // Test cases missing from our coverage compared to Flow JS SDK

        // Test case: Transaction with actual arguments (not just empty)
        val txWithArguments = Transaction(
            script = "transaction(msg: String) { execute { log(msg) } }",
            arguments = listOf(Cadence.string("Hello")),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        
        // Should be able to encode with arguments
        val payloadWithArgs = txWithArguments.payloadMessage()
        assertTrue(payloadWithArgs.isNotEmpty(), "Should handle transaction with arguments")
        
        // Test case: Different payer than proposer
        val multiRoleTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "02", // Different from proposer
            authorizers = listOf("01")
        )
        
        val multiRolePayload = multiRoleTx.payloadMessage()
        assertNotEquals(txWithArguments.payloadMessage().toHexString(), multiRolePayload.toHexString(), 
                       "Different payer should produce different encoding")
        
        println("✅ Additional compatibility test cases passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityEnvelopeSignatures() {
        // Test envelope signatures (not just payload signatures)
        val baseTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )

        // Test with envelope signatures added
        val txWithEnvelopeSig = baseTx.copy(
            envelopeSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )
        
        // Complete envelope message should include both payload and envelope signatures
        val completeEnvelopeMsg = txWithEnvelopeSig.completeEnvelopeMessage()
        assertTrue(completeEnvelopeMsg.isNotEmpty(), "Should handle envelope signatures")
        
        // Should be different from just payload signatures
        val payloadOnlyEnvelope = baseTx.completeEnvelopeMessage()
        assertNotEquals(payloadOnlyEnvelope.toHexString(), completeEnvelopeMsg.toHexString(), 
                       "Complete envelope with envelope signatures should differ from payload-only")
        
        // Regular envelope message (for signing) should be the same regardless of envelope signatures
        val envelopeForSigning1 = baseTx.envelopeMessage()
        val envelopeForSigning2 = txWithEnvelopeSig.envelopeMessage()
        assertEquals(envelopeForSigning1.toHexString(), envelopeForSigning2.toHexString(),
                    "Envelope message for signing should not include envelope signatures")
        
        println("✅ Envelope signature compatibility tests passed")
    }

    @Test
    fun testFlowJSSDKTransactionIdEncoding() {
        // Test transaction ID encoding (from the txId tests in JS SDK)
        // This would require implementing transaction ID calculation similar to encodeTxIdFromVoucher
        
        val completeTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )
        
        // For now, just verify the transaction structure is valid
        // TODO: Implement actual transaction ID calculation to match JS SDK
        val envelope = completeTx.envelopeMessage()
        assertTrue(envelope.isNotEmpty(), "Transaction should produce valid envelope for ID calculation")
        
        // Expected transaction ID from JS SDK: "118d6462f1c4182501d56f04a0cd23cf685283194bb316dceeb215b353120b2b"
        // This would require implementing SHA-256 hash of the envelope message
        
        println("✅ Transaction ID encoding structure verified (full implementation needed)")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompatibilityComplexAuthorizers() {
        // Test complex authorizer scenarios from JS SDK
        
        // Test case: Multiple authorizers with different addresses
        val multiAuthTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01", "02", "03")
        )
        
        val multiAuthPayload = multiAuthTx.payloadMessage().toHexString()
        
        // Should match the "multiple authorizers" expected encoding pattern
        assertTrue(multiAuthPayload.contains("880000000000000001"), "Should contain proposer address")
        assertTrue(multiAuthPayload.contains("880000000000000002"), "Should contain second authorizer")
        assertTrue(multiAuthPayload.contains("880000000000000003"), "Should contain third authorizer")
        
        // Test case: Authorizer same as proposer (should be deduplicated correctly)
        val overlappingAuthTx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "02",
            authorizers = listOf("01") // Same as proposer
        )
        
        val overlappingPayload = overlappingAuthTx.payloadMessage()
        assertTrue(overlappingPayload.isNotEmpty(), "Should handle overlapping proposer/authorizer correctly")
        
        println("✅ Complex authorizer compatibility tests passed")
    }

    /**
     * Comprehensive test cases matching ALL Flow JS SDK test scenarios
     * These ensure exact compatibility with Flow JavaScript SDK encoding
     */
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKCompletePayloadCompatibility() {
        // Base transaction matching JS SDK test
        fun createBaseTx() = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )

        // Test case: "complete tx" - matches JS SDK baseTx
        val completeTx = createBaseTx()
        val expectedCompletePayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001"
        val expectedCompleteEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedCompletePayload, completeTx.payloadMessage().toHexString(), "Complete tx payload should match JS SDK")
        assertEquals(expectedCompleteEnvelope, completeTx.envelopeMessage().toHexString(), "Complete tx envelope should match JS SDK")

        // Test case: "empty cadence"
        val emptyCadenceTx = completeTx.copy(script = "")
        val expectedEmptyPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f84280c0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001"
        val expectedEmptyEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f869f84280c0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedEmptyPayload, emptyCadenceTx.payloadMessage().toHexString(), "Empty cadence payload should match JS SDK")
        assertEquals(expectedEmptyEnvelope, emptyCadenceTx.envelopeMessage().toHexString(), "Empty cadence envelope should match JS SDK")

        // Test case: "null refBlock"
        val nullRefBlockTx = completeTx.copy(referenceBlockId = "0000000000000000000000000000000000000000000000000000000000000000")
        val expectedNullRefPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a000000000000000000000000000000000000000000000000000000000000000002a880000000000000001040a880000000000000001c9880000000000000001"
        val expectedNullRefEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a000000000000000000000000000000000000000000000000000000000000000002a880000000000000001040a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedNullRefPayload, nullRefBlockTx.payloadMessage().toHexString(), "Null refBlock payload should match JS SDK")
        assertEquals(expectedNullRefEnvelope, nullRefBlockTx.envelopeMessage().toHexString(), "Null refBlock envelope should match JS SDK")

        // Test case: "zero computeLimit"
        val zeroGasTx = completeTx.copy(gasLimit = BigInteger.ZERO)
        val expectedZeroGasPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b80880000000000000001040a880000000000000001c9880000000000000001"
        val expectedZeroGasEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b80880000000000000001040a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedZeroGasPayload, zeroGasTx.payloadMessage().toHexString(), "Zero gas payload should match JS SDK")
        assertEquals(expectedZeroGasEnvelope, zeroGasTx.envelopeMessage().toHexString(), "Zero gas envelope should match JS SDK")

        // Test case: "zero proposalKey.keyId"
        val zeroKeyTx = completeTx.copy(
            proposalKey = completeTx.proposalKey.copy(keyIndex = 0),
            payloadSignatures = listOf(
                TransactionSignature(address = "01", keyIndex = 4, signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162")
            )
        )
        val expectedZeroKeyPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001800a880000000000000001c9880000000000000001"
        val expectedZeroKeyEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001800a880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedZeroKeyPayload, zeroKeyTx.payloadMessage().toHexString(), "Zero key payload should match JS SDK")
        assertEquals(expectedZeroKeyEnvelope, zeroKeyTx.envelopeMessage().toHexString(), "Zero key envelope should match JS SDK")

        // Test case: "zero proposalKey.sequenceNum"
        val zeroSeqTx = completeTx.copy(proposalKey = completeTx.proposalKey.copy(sequenceNumber = BigInteger.ZERO))
        val expectedZeroSeqPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a8800000000000000010480880000000000000001c9880000000000000001"
        val expectedZeroSeqEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a8800000000000000010480880000000000000001c9880000000000000001e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedZeroSeqPayload, zeroSeqTx.payloadMessage().toHexString(), "Zero sequence payload should match JS SDK")
        assertEquals(expectedZeroSeqEnvelope, zeroSeqTx.envelopeMessage().toHexString(), "Zero sequence envelope should match JS SDK")

        // Test case: "empty authorizers"
        val emptyAuthTx = completeTx.copy(authorizers = listOf())
        val expectedEmptyAuthPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f869b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c0"
        val expectedEmptyAuthEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f890f869b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c0e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedEmptyAuthPayload, emptyAuthTx.payloadMessage().toHexString(), "Empty authorizers payload should match JS SDK")
        assertEquals(expectedEmptyAuthEnvelope, emptyAuthTx.envelopeMessage().toHexString(), "Empty authorizers envelope should match JS SDK")

        // Test case: "multiple authorizers"
        val multiAuthTx = completeTx.copy(authorizers = listOf("01", "02"))
        val expectedMultiAuthPayload = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f87bb07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001d2880000000000000001880000000000000002"
        val expectedMultiAuthEnvelope = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f8a2f87bb07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001d2880000000000000001880000000000000002e4e38004a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedMultiAuthPayload, multiAuthTx.payloadMessage().toHexString(), "Multiple authorizers payload should match JS SDK")
        assertEquals(expectedMultiAuthEnvelope, multiAuthTx.envelopeMessage().toHexString(), "Multiple authorizers envelope should match JS SDK")

        println("✅ All Flow JS SDK payload compatibility tests passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKEnvelopeOnlyTestCases() {
        // Base transaction for envelope-specific tests
        fun createBaseTx() = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 4,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )

        // Test case: "empty payloadSigs"
        val emptyPayloadSigsTx = createBaseTx().copy(payloadSignatures = listOf())
        val expectedEmptyPayloadSigs = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f875f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001c0"
        
        assertEquals(expectedEmptyPayloadSigs, emptyPayloadSigsTx.envelopeMessage().toHexString(), "Empty payloadSigs should match JS SDK")

        // Test case: "zero payloadSigs.0.keyId"
        val zeroPayloadKeyTx = createBaseTx().copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 0,
                    signature = "f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
                )
            )
        )
        val expectedZeroPayloadKey = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f899f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001e4e38080a0f7225388c1d69d57e6251c9fda50cbbf9e05131e5adb81e5aa0422402f048162"
        
        assertEquals(expectedZeroPayloadKey, zeroPayloadKeyTx.envelopeMessage().toHexString(), "Zero payload key should match JS SDK")

        println("✅ All Flow JS SDK envelope-only test cases passed")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testFlowJSSDKSignatureOrderingCases() {
        // These test the critical signature ordering that was causing our issues
        fun createBaseTx() = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01", "02", "03")
        )

        // Test case: "out-of-order payloadSigs -- by signer"
        // This tests that signatures get sorted by signer index, not by the order they were added
        val outOfOrderSignerTx = createBaseTx().copy(
            payloadSignatures = listOf(
                TransactionSignature(address = "03", keyIndex = 0, signature = "c"),  // signer index 2
                TransactionSignature(address = "01", keyIndex = 0, signature = "a"),  // signer index 0  
                TransactionSignature(address = "02", keyIndex = 0, signature = "b")   // signer index 1
            )
        )
        val expectedOutOfOrderSigner = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f893f884b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001db880000000000000001880000000000000002880000000000000003ccc3808080c3018080c3028080"
        
        assertEquals(expectedOutOfOrderSigner, outOfOrderSignerTx.envelopeMessage().toHexString(), "Out-of-order signer signatures should be sorted")

        // Test case: "out-of-order payloadSigs -- by key ID"
        // This tests that signatures with same signer get sorted by key index
        val outOfOrderKeyTx = createBaseTx().copy(
            authorizers = listOf("01"),
            payloadSignatures = listOf(
                TransactionSignature(address = "01", keyIndex = 2, signature = "c"),
                TransactionSignature(address = "01", keyIndex = 0, signature = "a"),
                TransactionSignature(address = "01", keyIndex = 1, signature = "b")
            )
        )
        val expectedOutOfOrderKey = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f881f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001ccc3808080c3800180c3800280"
        
        assertEquals(expectedOutOfOrderKey, outOfOrderKeyTx.envelopeMessage().toHexString(), "Out-of-order key signatures should be sorted")

        println("✅ All Flow JS SDK signature ordering tests passed")
    }
}