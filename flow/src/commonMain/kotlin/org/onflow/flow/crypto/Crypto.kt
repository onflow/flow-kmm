package org.onflow.flow.crypto

import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.Signer

expect object Crypto {
    fun decodePrivateKey(key: String, algo: SigningAlgorithm = SigningAlgorithm.ECDSA_P256): PrivateKey
    fun getSigner(privateKey: PrivateKey, hashAlgo: HashingAlgorithm = HashingAlgorithm.SHA3_256): Signer
}