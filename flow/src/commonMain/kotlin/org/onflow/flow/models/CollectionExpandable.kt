package org.onflow.flow.models


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param transactions 
 */
@Serializable
data class CollectionExpandable (

    @SerialName(value = "transactions") val transactions: List<String>? = null

)

