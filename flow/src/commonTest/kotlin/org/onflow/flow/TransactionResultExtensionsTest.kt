package org.onflow.flow

import kotlinx.coroutines.runBlocking
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.Event
import org.onflow.flow.models.TransactionResult
import org.onflow.flow.models.TransactionStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TransactionResultExtensionsTest {

    @Test
    fun `getCreatedAddress should return address when event present`() {
        val payload = Cadence.eventValue(
            Cadence.CompositeValue(
                id = "flow.AccountCreated",
                fields = listOf(
                    Cadence.CompositeAttribute(
                        name = "address",
                        value = Cadence.address("0xabc")
                    )
                )
            )
        )

        val event = Event(
            type = "flow.AccountCreated",
            transactionId = "tx",
            transactionIndex = "0",
            eventIndex = "0",
            payload = payload
        )

        val txResult = TransactionResult(
            blockId = "block",
            status = TransactionStatus.SEALED,
            statusCode = 0,
            errorMessage = "",
            computationUsed = "0",
            events = listOf(event)
        )

        assertEquals("0xabc", txResult.getCreatedAddress())
    }

    @Test
    fun `getCreatedAddress should return null when event missing`() {
        val txResult = TransactionResult(
            blockId = "block",
            status = TransactionStatus.EXECUTED,
            statusCode = 0,
            errorMessage = "",
            computationUsed = "0",
            events = emptyList()
        )

        assertNull(txResult.getCreatedAddress())
    }

    @Test
    fun `waitForCreatedAccountAddress returns created address after seal`() = runBlocking {
        val txId = "0xd7320b52ce88d37855086facadaf0214a1c184078527a109ab9d002a4296fb7b"
        val api = FlowApi(ChainId.Mainnet)
        val addr = api.waitForCreatedAccountAddress(txId)
        // monkey-patch via extension call using sealed result
        assertEquals("0x55a8d27a989c4706", addr)
    }
}
