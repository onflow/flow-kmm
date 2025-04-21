package org.onflow.flow.crypto

import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm
import org.onflow.flow.models.Signer

actual object Crypto {
    actual fun decodePrivateKey(key: String, algo: SigningAlgorithm): PrivateKey {
        throw NotImplementedError("decodePrivateKey is not implemented for iOS")
    }

    actual fun getSigner(privateKey: PrivateKey, hashAlgo: HashingAlgorithm): Signer {
        throw NotImplementedError("getSigner is not implemented for iOS")
    }

    actual fun generateKeyPair(algo: SigningAlgorithm): KeyPair {
        throw NotImplementedError("generateKeyPair is not implemented for iOS")
    }
}

actual class KeyPair {
    actual val private: PrivateKey
        get() = throw NotImplementedError("private is not implemented for iOS")
    actual val public: PublicKey
        get() = throw NotImplementedError("public is not implemented for iOS")
}

actual class PrivateKey {
    actual val key: Any
        get() = throw NotImplementedError("key is not implemented for iOS")
    actual val algo: SigningAlgorithm
        get() = throw NotImplementedError("algo is not implemented for iOS")
    actual val hex: String
        get() = throw NotImplementedError("hex is not implemented for iOS")
    actual val publicKey: PublicKey
        get() = throw NotImplementedError("publicKey is not implemented for iOS")
}

actual class PublicKey {
    actual val key: Any
        get() = throw NotImplementedError("key is not implemented for iOS")
    actual val algo: SigningAlgorithm
        get() = throw NotImplementedError("algo is not implemented for iOS")
    actual val hex: String
        get() = throw NotImplementedError("hex is not implemented for iOS")
    
    actual fun verify(signature: ByteArray, message: ByteArray, hashAlgo: HashingAlgorithm): Boolean {
        throw NotImplementedError("verify is not implemented for iOS")
    }
} 