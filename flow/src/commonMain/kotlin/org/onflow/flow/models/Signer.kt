package org.onflow.flow.models

interface Signer {
    var address: String
    var keyIndex: Int
    suspend fun sign(bytes: ByteArray): ByteArray
    suspend fun signWithDomain(bytes: ByteArray, domain: ByteArray): ByteArray = sign(domain + bytes)
    suspend fun signAsUser(bytes: ByteArray): ByteArray = signWithDomain(bytes, DomainTag.User.bytes)
    suspend fun signAsTransaction(bytes: ByteArray): ByteArray = signWithDomain(bytes, DomainTag.Transaction.bytes)
}

interface Hasher {
    fun hash(bytes: ByteArray): ByteArray
    fun hashAsHexString(bytes: ByteArray): String = hash(bytes).toHexString()
}