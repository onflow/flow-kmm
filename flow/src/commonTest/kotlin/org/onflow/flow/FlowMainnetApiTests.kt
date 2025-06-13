package org.onflow.flow

import org.onflow.flow.cadence.TestStruct
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.infrastructure.getField
import kotlinx.coroutines.runBlocking
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class FlowMainnetApiTests {

    val api = FlowApi(ChainId.Mainnet)

    @Test
    fun testGetTransactionID() {
        runBlocking {
            val tx = api.getTransaction("e5b5fe5457e7d3594d9cf581cee74af1a589fbc37b70952b2223d714894d2849")
            assertEquals(4, tx.arguments.count())
            assertEquals("0x779ffd206566b382", tx.arguments.last().decode<String>())
        }
    }

    @Ignore
    @Test
    fun testGetEvents() {
        runBlocking {
            val result = api.getTransactionResult("e5b5fe5457e7d3594d9cf581cee74af1a589fbc37b70952b2223d714894d2849")
            val event = result.events.first().payload.value as Cadence.CompositeValue
            assertEquals("A.a08e88e23f332538.DapperStorageRent.RefilledFailed", event.id)
            assertEquals("Address is not below StorageRentRefillThreshold", event.getField<String>("reason"))
        }
    }

    @Test
    fun testLargeNumberParsingIssue() {
        runBlocking {
            try {
                // This is the specific transaction ID from the user's logs that's causing the parsing error
                val result = api.getTransactionResult("41741c38f870842971808eaa93599211e241036b87727c87713e2329a767d4d7")
                println("Transaction result retrieved successfully")
                println("Events count: ${result.events.size}")
                println("Computation used: ${result.computationUsed}")
                println("Status: ${result.status}")
                
                // Log event details to see where the large number appears
                result.events.forEachIndexed { index, event ->
                    println("Event $index:")
                    println("  Type: ${event.type}")
                    println("  Transaction Index: ${event.transactionIndex}")
                    println("  Event Index: ${event.eventIndex}")
                    println("  Payload: ${event.payload}")
                }
            } catch (e: Exception) {
                println("Failed to parse transaction result: ${e.message}")
                println("Exception type: ${e::class.simpleName}")
                e.printStackTrace()
                throw e
            }
        }
    }

    @Test
    fun decodeStruct() {
        runBlocking {
            val result = api.executeScript(
                """
                  access(all) struct StorageInfo {
                      access(all) let capacity: Int
                      access(all) let used: Int
                      access(all) let available: Int

                      init(capacity: Int, used: Int, available: Int) {
                          self.capacity = capacity
                          self.used = used
                          self.available = available
                      }
                  }

                  access(all) fun main(addr: Address): [StorageInfo] {
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

    @Test
    fun testScriptDSL() {
        runBlocking {
            val result = api.query {
                script {
                    """
                    import EVM from 0xEVM
                    
                    access(all) fun main(flowAddress: Address): String? {
                        let account = getAuthAccount<auth(BorrowValue) &Account>(flowAddress)
                        if let address = account.storage.borrow<&EVM.CadenceOwnedAccount>(from: /storage/evm)?.address() {
                            let bytes: [UInt8] = []
                            for byte in address.bytes {
                                bytes.append(byte)
                            }
                            return "0x".concat(String.encodeHex(bytes))
                        }
                        return nil
                    }
                """.trimIndent()
                }

                arg {
                    Cadence.address("0x84221fe0294044d7")
                }
            }
            val info = result.decode<String?>()
            assertEquals("0x0000000000000000000000020c260f03355ff69d", info)
        }
    }
}