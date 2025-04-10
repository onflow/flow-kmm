package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 * Base64 encoded signature.
 *
 * @param address The 8-byte address of an account.
 * @param keyIndex 
 * @param signature A variable length signature.
 */
@Serializable
data class TransactionSignature (

    /* The 8-byte address of an account. */
    @SerialName(value = "address") @Required val address: String,

    @Serializable(StringIntSerializer::class)
    @SerialName(value = "key_index") @Required val keyIndex: Int,

    /* A variable length signature. */
    @Serializable(Base64HexSerializer::class)
    @SerialName(value = "signature") @Required val signature: String
)

class CompareTransactionSignature {
    companion object : Comparator<TransactionSignature> {
        override fun compare(a: TransactionSignature, b: TransactionSignature): Int = when {
            a.keyIndex == b.keyIndex -> 0
            else -> a.keyIndex - b.keyIndex
        }
    }
}
