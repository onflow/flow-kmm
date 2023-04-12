package org.onflow.flow.models

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param result 
 */
@Serializable
data class TransactionExpandable (

    @SerialName(value = "result") val result: String? = null

)

