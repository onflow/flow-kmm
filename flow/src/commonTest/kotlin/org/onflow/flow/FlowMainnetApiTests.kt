package org.onflow.flow

import org.onflow.flow.cadence.TestStruct
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.getField
import kotlinx.coroutines.runBlocking
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FlowMainnetApiTests {

    val api = FlowApi(ChainId.Mainnet)

    @Test
    @Ignore
    fun testGetTransactionID() {
        runBlocking {
            val tx = api.getTransaction("663869d910278d7b6caf793396f6f2c5b91aace7180c2c70cfb3b0b6efd7a049")
            assertEquals(1, tx.arguments.count())
            assertEquals(291975851UL, tx.arguments.first().decode<ULong>())
            assertTrue( tx.payloadSignatures.first().signature.startsWith("0xfe25c43444") )
        }
    }

    @Test
    @Ignore
    fun testGetEvents() {
        runBlocking {
            val result = api.getTransactionResult("663869d910278d7b6caf793396f6f2c5b91aace7180c2c70cfb3b0b6efd7a049")
            val event = result.events.first().payload.value as Cadence.CompositeValue
            assertEquals("A.b8ea91944fd51c43.Offers.OfferCompleted", event.id)
            assertEquals(291975851UL, event.getField<ULong>("offerId"))
        }
    }

    @Test
    @Ignore
    fun decodeStruct() {
        runBlocking {
            val result = api.executeScript(
                """
                  pub struct StorageInfo {
                      pub let capacity: Int
                      pub let used: Int
                      pub let available: Int

                      init(capacity: Int, used: Int, available: Int) {
                          self.capacity = capacity
                          self.used = used
                          self.available = available
                      }
                  }

                  pub fun main(addr: Address): [StorageInfo] {
                    let acct = getAccount(addr)
                    return [StorageInfo(capacity: 1,
                                       used: 2,
                                       available: 3)]
                  }
                """.trimIndent(),
                listOf(Cadence.address("0x84221fe0294044d7"))
            )

            val info = result.decode<List<TestStruct>>().first()

            assertEquals(1, info.capacity)
            assertEquals(2, info.used)
            assertEquals(3, info.available)
        }
    }
}