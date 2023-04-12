package org.onflow.flow.models

import io.ktor.utils.io.core.*
import org.onflow.flow.rlp.paddingZeroRight

sealed class DomainTag {
    abstract val tag: String

    open val bytes: ByteArray
        get() = tag.toByteArray().paddingZeroRight(32)

    data class Transaction(override val tag: String = "FLOW-V0.0-transaction") : DomainTag()

    data class User(override val tag: String = "FLOW-V0.0-user") : DomainTag()

    data class AccountProof(override val tag: String = "FCL-ACCOUNT-PROOF-V0.0") : DomainTag()

    data class Custom(override val tag: String): DomainTag()
}