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

    @Test
    fun testSimpleFlowTxEncode() {
        val tx = Transaction(
            script = "transaction { execute { log(\"Hello, World!\") } }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(42),
            proposalKey = ProposalKey(address = "01", keyIndex = 4, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )
        val hexString = hex(tx.payloadMessage())
        println(hexString)
        val rlpString = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000f875f872b07472616e73616374696f6e207b2065786563757465207b206c6f67282248656c6c6f2c20576f726c64212229207d207dc0a0f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b2a880000000000000001040a880000000000000001c9880000000000000001c0"
        assertEquals(rlpString, hexString)
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testPayloadVsEnvelopeStructure() {
        // Test that payload and envelope messages have the correct structures
        val tx = Transaction(
            script = "transaction { log(\"test\") }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val payloadMsg = tx.payloadMessage()
        val envelopeMsg = tx.envelopeMessage()

        // When there are no payload signatures, both should be identical (this is correct behavior!)
        assertEquals(payloadMsg.toHexString(), envelopeMsg.toHexString(), "Payload and envelope messages should be identical when no payload signatures exist")
        
        // Both should include proper domain tags and content
        assertTrue(payloadMsg.size > 32) // Should include domain tag + content
        assertTrue(envelopeMsg.size > 32) // Should include domain tag + content
        
        // Now test with payload signatures - they should be different
        val txWithPayloadSig = tx.copy(
            payloadSignatures = listOf(
                TransactionSignature(
                    address = "01",
                    keyIndex = 0,
                    signature = "abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890abcd1234567890ab"
                )
            )
        )
        
        val payloadMsgWithSig = txWithPayloadSig.payloadMessage()
        val envelopeMsgWithSig = txWithPayloadSig.envelopeMessage()
        
        // Now they should be different (envelope includes the payload signature)
        assertNotEquals(payloadMsgWithSig.toHexString(), envelopeMsgWithSig.toHexString(), "Payload and envelope messages should differ when payload signatures exist")
        
        println("Empty signatures - Payload: ${payloadMsg.toHexString()}")
        println("Empty signatures - Envelope: ${envelopeMsg.toHexString()}")
        println("With signatures - Payload: ${payloadMsgWithSig.toHexString()}")
        println("With signatures - Envelope: ${envelopeMsgWithSig.toHexString()}")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testPayloadStructureWithEmptySignatures() {
        // Test the critical fix: payload message should include empty signature list
        val tx = Transaction(
            script = "transaction { log(\"test\") }",
            arguments = listOf(),
            referenceBlockId = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
            gasLimit = BigInteger(1000),
            proposalKey = ProposalKey(address = "01", keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = "01",
            authorizers = listOf("01")
        )

        val payloadMsg = tx.payloadMessage()
        val payloadMsgHex = payloadMsg.toHexString()
        
        // Should end with 'c0' which represents empty RLP list for payload signatures
        assertTrue(payloadMsgHex.endsWith("c0"), "Payload message should end with 'c0' (empty payload signatures list)")
        
        // Verify the structure: domain tag + RLPList([payload, empty_list])
        val domainTag = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000"
        assertTrue(payloadMsgHex.startsWith(domainTag), "Should start with domain tag")
        
        println("Payload message structure verified: ${payloadMsgHex}")
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
        
        println("Envelope message with payload signature: ${envelopeMsgHex}")
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun testSingleVsMultiSignerRLPDifference() {
        // Test that single-signer and multi-signer transactions produce different RLP when payer differs
        val commonScript = "transaction { log(\"test\") }"
        val commonArgs = listOf<Cadence.Value>()
        val commonRefBlock = "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b"
        val commonGasLimit = BigInteger(1000)
        val proposerAddress = "01"
        val payerAddress = "02"

        // Single-signer: proposer = payer
        val singleSignerTx = Transaction(
            script = commonScript,
            arguments = commonArgs,
            referenceBlockId = commonRefBlock,
            gasLimit = commonGasLimit,
            proposalKey = ProposalKey(address = proposerAddress, keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = proposerAddress, // Same as proposer
            authorizers = listOf(proposerAddress)
        )

        // Multi-signer: proposer ≠ payer
        val multiSignerTx = Transaction(
            script = commonScript,
            arguments = commonArgs,
            referenceBlockId = commonRefBlock,
            gasLimit = commonGasLimit,
            proposalKey = ProposalKey(address = proposerAddress, keyIndex = 0, sequenceNumber = BigInteger(10)),
            payer = payerAddress, // Different from proposer
            authorizers = listOf(proposerAddress)
        )

        val singlePayloadMsg = singleSignerTx.payloadMessage()
        val multiPayloadMsg = multiSignerTx.payloadMessage()

        // Should be different because payer field is different
        assertNotEquals(singlePayloadMsg.toHexString(), multiPayloadMsg.toHexString())
        
        println("Single-signer payload: ${singlePayloadMsg.toHexString()}")
        println("Multi-signer payload: ${multiPayloadMsg.toHexString()}")
        
        // Both should have the same structure (domain tag + envelope with empty payload sigs)
        val domainTag = "464c4f572d56302e302d7472616e73616374696f6e0000000000000000000000"
        assertTrue(singlePayloadMsg.toHexString().startsWith(domainTag))
        assertTrue(multiPayloadMsg.toHexString().startsWith(domainTag))
        assertTrue(singlePayloadMsg.toHexString().endsWith("c0"))
        assertTrue(multiPayloadMsg.toHexString().endsWith("c0"))
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
        
        println("RLP roundtrip consistency test passed")
    }
}