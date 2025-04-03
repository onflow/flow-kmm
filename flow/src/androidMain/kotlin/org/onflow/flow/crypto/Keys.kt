package org.onflow.flow.crypto

import org.bouncycastle.crypto.params.ECPublicKeyParameters
import org.bouncycastle.crypto.signers.ECDSASigner
import org.bouncycastle.jce.interfaces.ECPublicKey
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm
import java.math.BigInteger
import java.security.PrivateKey
import java.security.PublicKey

actual class KeyPair(
    actual val private: PrivateKey,
    actual val public: PublicKey
)

actual class PrivateKey(
    actual val key: PrivateKey,
    actual val algo: SigningAlgorithm,
    actual val hex: String,
    actual val publicKey: PublicKey
)

actual class PublicKey(
    actual val key: PublicKey,
    actual val algo: SigningAlgorithm,
    actual val hex: String
) {
    actual fun verify(signature: ByteArray, message: ByteArray, hashAlgo: HashingAlgorithm): Boolean {
        // check for supported algos
        Crypto.checkSupportedSignAlgo(algo)
        Crypto.checkHashAlgoForSigning(hashAlgo)

        // check the input key is of the correct type
        val ecPK = if (key is ECPublicKey) {
            key
        } else {
            throw IllegalArgumentException("key in PublicKey must be an ECPublicKey")
        }
        // compute the hash
        val hash = HasherImpl(hashAlgo).hash(message)

        // verify the hash
        val ecdsaObject = ECDSASigner()
        val domain = Crypto.ecDomainFromECSpec(ecPK.parameters)
        val cipherParams = ECPublicKeyParameters(ecPK.q, domain)
        ecdsaObject.init(false, cipherParams)
        val curveOrderSize = Crypto.getCurveOrderSize(domain)
        if (signature.size != 2 * curveOrderSize) {
            return false
        }
        val r = BigInteger(1, signature.copyOfRange(0, curveOrderSize))
        val s = BigInteger(1, signature.copyOfRange(curveOrderSize, signature.size))
        return ecdsaObject.verifySignature(hash, r, s)
    }
} 