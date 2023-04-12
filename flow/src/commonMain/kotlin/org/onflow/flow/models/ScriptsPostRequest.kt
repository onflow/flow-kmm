package org.onflow.flow.models

import kotlinx.serialization.*
import org.onflow.flow.infrastructure.Base64ByteArray

/**
 *
 *
 * @param script Base64 encoded content of the Cadence script.
 * @param arguments An list of arguments each encoded as Base64 passed in the [JSON-Cadence interchange format](https://docs.onflow.org/cadence/json-cadence-spec/).
 */
@Serializable
data class ScriptsPostRequest(

    /* Base64 encoded content of the Cadence script. */
    @SerialName(value = "script") val script: String? = null,

    /* An list of arguments each encoded as Base64 passed in the [JSON-Cadence interchange format](https://docs.onflow.org/cadence/json-cadence-spec/). */
    @SerialName(value = "arguments") val arguments: List<String>? = null

)

