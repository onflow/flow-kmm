package org.onflow.flow.models


import org.onflow.flow.infrastructure.BigIntegerCadenceSerializer
import org.onflow.flow.infrastructure.IntCadenceSerializer
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param address The 8-byte address of an account.
 * @param keyIndex 
 * @param sequenceNumber 
 */
@Serializable
data class ProposalKey (

    /* The 8-byte address of an account. */
    @SerialName(value = "address") @Required val address: String,

    @Serializable(IntCadenceSerializer::class)
    @SerialName(value = "key_index") @Required val keyIndex: Int,

    @Serializable(BigIntegerCadenceSerializer::class)
    @SerialName(value = "sequence_number") @Required val sequenceNumber: BigInteger

)

