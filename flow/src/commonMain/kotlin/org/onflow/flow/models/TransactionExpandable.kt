package org.onflow.flow.models

import kotlinx.serialization.*

/**
 * 
 *
 * @param result 
 */
@Serializable
data class TransactionExpandable (

    @SerialName(value = "result") val result: String? = null

)

