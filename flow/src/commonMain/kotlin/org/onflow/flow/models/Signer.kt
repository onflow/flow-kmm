package org.onflow.flow.models

interface Signer {
    var address: String
    var keyIndex: Int
    suspend fun sign(bytes: ByteArray, transaction: Transaction? = null): ByteArray
    suspend fun signWithDomain(bytes: ByteArray, domain: ByteArray, transaction: Transaction? = null): ByteArray =
        sign(domain + bytes, transaction)
    suspend fun signAsUser(bytes: ByteArray): ByteArray = signWithDomain(bytes, DomainTag.User.bytes)
    suspend fun signAsTransaction(bytes: ByteArray, transaction: Transaction? = null): ByteArray =
        signWithDomain(bytes, DomainTag.Transaction.bytes, transaction)
}

interface Hasher {
    fun hash(bytes: ByteArray): ByteArray
    fun hashAsHexString(bytes: ByteArray): String = hash(bytes).toHexString()
}
