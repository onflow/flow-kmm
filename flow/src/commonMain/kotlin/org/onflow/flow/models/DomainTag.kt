package org.onflow.flow.models

import io.ktor.utils.io.core.*
import org.onflow.flow.rlp.paddingZeroRight

abstract class DomainTag {
    abstract val tag: String

    open val bytes: ByteArray
        get() = tag.toByteArray().paddingZeroRight(32)

    object Transaction : DomainTag() {
        override val tag: String = "FLOW-V0.0-transaction"
    }

    object User: DomainTag() {
        override val tag: String = "FLOW-V0.0-user"
    }

    object AccountProof: DomainTag() {
        override val tag: String = "FLOW-V0.0-account-proof"
    }

    data class Custom(override val tag: String): DomainTag()
}