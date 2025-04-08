package org.onflow.flow

import com.ionspin.kotlin.bignum.integer.toBigInteger
import kotlinx.coroutines.runBlocking
import org.onflow.flow.models.Transaction
import org.onflow.flow.crypto.Crypto
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.ProposalKey
import kotlin.test.Test
import kotlin.test.assertTrue

class FlowTransactionTests {

    private val api = FlowApi(ChainId.Testnet)

    @Test
    fun testSignTestnet() {
        runBlocking {
            // Generate a new key pair
            val keyPair = Crypto.generateKeyPair()
            println("Generated private key: ${keyPair.private.hex}")
            println("Generated public key: ${keyPair.public.hex}")

            // Replace with your test account address
            val testAccountAddress = "0x328649a25184b171"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")

            // Get the account to verify it exists and get the key index
            val account = api.getAccount(cleanAccountAddress)
            val key = account.keys!!.first()

            // Get the latest block for reference block ID
            val latestBlock = api.getBlock()

            // Create a signer using the generated private key
            val signer = Crypto.getSigner(keyPair.private, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = key.index.toInt()
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
                referenceBlockId = latestBlock.header.id,
                gasLimit = 1000.toBigInteger(),
                payer = cleanAccountAddress,
                proposalKey = ProposalKey(
                    address = cleanAccountAddress,
                    keyIndex = key.index.toInt(),
                    sequenceNumber = key.sequenceNumber.toBigInteger()
                ),
                authorizers = listOf(cleanAccountAddress)
            )

            // Sign and send the transaction
            val signedTx = tx.sign(listOf(signer))
            val result = api.sendTransaction(signedTx)

            // Verify the transaction was sent successfully
            result.id?.isNotEmpty()?.let { assertTrue(it, "Transaction ID should not be empty") }
            println("Transaction sent successfully with ID: ${result.id}")
        }
    }

    @Test
    fun testSignAndSendTransaction() {
        runBlocking {
            val addKeyScript = """
            transaction(publicKey: String, signatureAlgorithm: UInt8, hashAlgorithm: UInt8, weight: UFix64) {
                prepare(signer: auth(AddKey) &Account) {
                    signer.keys.add(
                        publicKey: PublicKey(
                            publicKey: publicKey.decodeHex(),
                            signatureAlgorithm: SignatureAlgorithm(rawValue: signatureAlgorithm)!
                        ),
                        hashAlgorithm: HashAlgorithm(rawValue: hashAlgorithm)!,
                        weight: weight
                    )
                }
            }
        """.trimIndent()

            // Step 1: Generate new key pair
            val newKeyPair = Crypto.generateKeyPair()
            println("Generated private key: ${newKeyPair.private.hex}")
            println("Generated public key: ${newKeyPair.public.hex}")

            // Step 2: Load existing testnet account
            val testAccountAddress = "0x328649a25184b171"
            val cleanAccountAddress = testAccountAddress.removePrefix("0x")
            val account = api.getAccount(cleanAccountAddress)
            val mainKey = account.keys!!.first()
            val latestBlock = api.getBlock()

            // Step 3: Build the addKey transaction
            val addKeyArgs = listOf(
                Cadence.string(newKeyPair.public.hex),
                Cadence.uint8(2u), // SignatureAlgorithm.ECDSA_P256
                Cadence.uint8(3u), // HashAlgorithm.SHA3_256
                Cadence.ufix64("1000.0")
            )

            val addKeyTx = Transaction(
                script = addKeyScript,
                arguments = addKeyArgs,
                referenceBlockId = latestBlock.header.id,
                gasLimit = 1000.toBigInteger(),
                payer = cleanAccountAddress,
                proposalKey = ProposalKey(
                    address = cleanAccountAddress,
                    keyIndex = mainKey.index.toInt(),
                    sequenceNumber = mainKey.sequenceNumber.toBigInteger()
                ),
                authorizers = listOf(cleanAccountAddress)
            )

            // Step 4: Sign with the *existing* key
            val existingPrivateKey = Crypto.decodePrivateKey("YOUR_EXISTING_PRIVATE_KEY_HEX", SigningAlgorithm.ECDSA_P256)
            val existingSigner = Crypto.getSigner(existingPrivateKey, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = mainKey.index.toInt()
            }

            // Step 5: Submit the addKey transaction
            val signedAddKeyTx = addKeyTx.sign(listOf(existingSigner))
            val addKeyResponse = api.sendTransaction(signedAddKeyTx)
            println("AddKey transaction sent: ${addKeyResponse.id}")

            // Step 7: Look up new key index
            val updatedAccount = api.getAccount(cleanAccountAddress)
            val newKey = updatedAccount.keys!!.find { it.publicKey == newKeyPair.public.hex }
                ?: error("New key not found")

            println("New key added with index: ${newKey.index}")

            // Step 8: Build a transaction using the new key
            val logTx = Transaction(
                script = """
                access(all) transaction {
                    prepare(signer: AuthAccount) {
                        log(signer.address)
                    }
                }
            """.trimIndent(),
                arguments = emptyList(),
                referenceBlockId = api.getBlock().header.id,
                gasLimit = 1000.toBigInteger(),
                payer = cleanAccountAddress,
                proposalKey = ProposalKey(
                    address = cleanAccountAddress,
                    keyIndex = newKey.index.toInt(),
                    sequenceNumber = newKey.sequenceNumber.toBigInteger()
                ),
                authorizers = listOf(cleanAccountAddress)
            )

            // Step 9: Sign using the new key
            val newSigner = Crypto.getSigner(newKeyPair.private, HashingAlgorithm.SHA3_256).apply {
                address = cleanAccountAddress
                keyIndex = newKey.index.toInt()
            }

            val signedLogTx = logTx.sign(listOf(newSigner))
            println("Payload signatures: ${signedLogTx.payloadSignatures}")
            println("Envelope signatures: ${signedLogTx.envelopeSignatures}")

            // Step 10: Send the transaction
            val txResponse = api.sendTransaction(signedLogTx)
            println("Log transaction sent: ${txResponse.id}")
            assertTrue(txResponse.id!!.isNotEmpty(), "Transaction ID should not be empty")
        }
    }
}