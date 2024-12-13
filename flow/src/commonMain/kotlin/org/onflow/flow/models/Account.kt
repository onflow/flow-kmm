package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray
import org.onflow.flow.infrastructure.Base64ByteArraySerializer

/**
 *
 *
 * @param address The 8-byte address of an account.
 * @param balance Flow balance of the account.
 * @param expandable
 * @param propertyKeys
 * @param contracts
 * @param links
 */
@Serializable
data class Account(

    /* The 8-byte address of an account. */
    @SerialName(value = "address") @Required val address: String,

    /* Flow balance of the account. */
    @SerialName(value = "balance") @Required val balance: String,

    @SerialName(value = "_expandable") @Required val expandable: AccountExpandable,

    @SerialName(value = "keys") val keys: Set<AccountPublicKey>? = null,

    @SerialName(value = "contracts")
    val contracts: Map<String, @Serializable(with = Base64ByteArraySerializer::class) Base64ByteArray>? = null,

    @SerialName(value = "_links") val links: Links? = null

)

