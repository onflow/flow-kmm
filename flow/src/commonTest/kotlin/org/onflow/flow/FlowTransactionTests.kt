package org.onflow.flow

import kotlinx.coroutines.runBlocking
import org.onflow.flow.models.Signer
import org.onflow.flow.models.Transaction
import kotlin.test.Test

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)

    @Test
    fun testSignTestnet() {
        runBlocking {
            val account = api.getAccount("0x328649a25184b171")
            val key = account.keys!!.first()
            val signer = object : Signer {
                override var address: String = account.address
                override var keyIndex: Int = key.index.toInt()
                override suspend fun sign(transaction: Transaction, bytes: ByteArray): ByteArray {
                    return key.sign(bytes)
                }
                override suspend fun sign(bytes: ByteArray): ByteArray {
                    return key.sign(bytes)
                }
            }
            val tx = Transaction(
                script = """
                    access(all) transaction {
                        prepare(signer: AuthAccount) {
                            log(signer.address)
                        }
                    }
                """.trimIndent(),
                arguments = emptyList(),
                referenceBlockId = null,
                payerAddress = account.address,
                authorizers = listOf(account.address),
                payloadSignatures = emptyList()
            )
            val signedTx = tx.sign(signer)
            val result = api.sendTransaction(signedTx)
            println(result)
        }
    }
}