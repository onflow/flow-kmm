package org.onflow.flow.crypto

import org.bouncycastle.crypto.params.ECPublicKeyParameters
import org.bouncycastle.crypto.signers.ECDSASigner
import org.bouncycastle.jce.interfaces.ECPublicKey
import org.onflow.flow.models.HashingAlgorithm
import org.onflow.flow.models.SigningAlgorithm
import java.math.BigInteger
import java.security.PublicKey

actual class KeyPair(
    actual  val private: PrivateKey,
    actual  val public: org.onflow.flow.crypto.PublicKey
)

actual class PrivateKey(
    internal val privateKey: java.security.PrivateKey,
    actual val algo: SigningAlgorithm,
    actual val hex: String,
    actual val publicKey: org.onflow.flow.crypto.PublicKey
) {
    actual val key: Any
        get() = privateKey
}

actual class PublicKey(
    private val publicKey: PublicKey,
    actual val algo: SigningAlgorithm,
    actual val hex: String
) {
    actual val key: Any
        get() = publicKey

    actual fun verify(
        signature: ByteArray,
        message: ByteArray,
        hashAlgo: HashingAlgorithm
    ): Boolean {
        // check for supported algos
        Crypto.checkSupportedSignAlgo(algo)
        Crypto.checkHashAlgoForSigning(hashAlgo)

        // check the input key is of the correct type
        val ecPK = if (publicKey is ECPublicKey) {
            publicKey
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