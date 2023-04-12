package org.onflow.flow.rlp

import org.onflow.flow.models.ProposalKey
import org.onflow.flow.models.Transaction
import org.onflow.flow.models.payloadMessage
import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

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
}