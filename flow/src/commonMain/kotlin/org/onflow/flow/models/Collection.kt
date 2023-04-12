package org.onflow.flow.models

import org.onflow.flow.models.CollectionExpandable
import org.onflow.flow.models.Links
import kotlinx.serialization.*

/**
 * 
 *
 * @param id A 32-byte unique identifier for an entity.
 * @param expandable 
 * @param transactions 
 * @param links 
 */
@Serializable
data class Collection (

    /* A 32-byte unique identifier for an entity. */
    @SerialName(value = "id") @Required val id: String,

    @SerialName(value = "_expandable") @Required val expandable: CollectionExpandable,

    @SerialName(value = "transactions") val transactions: List<Transaction>? = null,

    @SerialName(value = "_links") val links: Links? = null

)

