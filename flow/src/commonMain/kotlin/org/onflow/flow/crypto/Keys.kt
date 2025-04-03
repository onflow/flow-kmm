package org.onflow.flow.crypto

import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm

expect class KeyPair {
    val private: PrivateKey
    val public: PublicKey
}

expect class PrivateKey {
    val key: Any
    val algo: SigningAlgorithm
    val hex: String
    val publicKey: PublicKey
}

expect class PublicKey (
    val key: Any,
    val algo: SigningAlgorithm,
    val hex: String
) {
    fun verify(signature: ByteArray, message: ByteArray, hashAlgo: HashingAlgorithm) : Boolean
}