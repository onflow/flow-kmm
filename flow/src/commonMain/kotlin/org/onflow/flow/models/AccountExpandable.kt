package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param propertyKeys 
 * @param contracts 
 */
@Serializable
data class AccountExpandable (

    @SerialName(value = "keys") val propertyKeys: String? = null,

    @SerialName(value = "contracts") val contracts: String? = null

)

