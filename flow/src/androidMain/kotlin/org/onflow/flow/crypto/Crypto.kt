package org.onflow.flow.crypto

import org.bouncycastle.crypto.params.ECDomainParameters
import org.bouncycastle.crypto.params.ECPrivateKeyParameters
import org.bouncycastle.crypto.signers.ECDSASigner
import org.bouncycastle.jce.ECNamedCurveTable
import org.bouncycastle.jce.interfaces.ECPrivateKey
import org.bouncycastle.jce.interfaces.ECPublicKey
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.jce.spec.ECParameterSpec
import org.bouncycastle.jce.spec.ECPrivateKeySpec
import org.onflow.flow.models.*
import org.onflow.flow.models.Signer
import java.math.BigInteger
import java.security.*
import java.security.spec.ECGenParameterSpec
import kotlin.math.max
import kotlin.random.Random

actual object Crypto {

    init {
        Security.addProvider(BouncyCastleProvider())
    }

    fun checkSupportedSignAlgo(algo: SigningAlgorithm) {
        // only ECDSA with 2 curves is currently supported
        if (algo !in listOf(SigningAlgorithm.ECDSA_secp256k1, SigningAlgorithm.ECDSA_P256)) {
            throw IllegalArgumentException("algorithm $algo is not supported")
        }
    }

    fun generateKeyPair(algo: SigningAlgorithm = SigningAlgorithm.ECDSA_P256): KeyPair {
        checkSupportedSignAlgo(algo)
        val generator = KeyPairGenerator.getInstance("EC", "BC")
        generator.initialize(ECGenParameterSpec("ECDSA"), SecureRandom())
        val keyPair = generator.generateKeyPair()
        val sk = keyPair.private
        val pk = keyPair.public

        val curveSpec = ECNamedCurveTable.getParameterSpec("ECDSA")
        val curveOrderSize = getCurveOrderSize(ecDomainFromECSpec(curveSpec))
        val curveFieldSize = getCurveFieldSize(ecDomainFromECSpec(curveSpec))

        val publicKey = PublicKey(
            publicKey = pk,
            algo = algo,
            hex = jsecPublicKeyToHexString(pk, curveFieldSize)
        )
        val privateKey = PrivateKey(
            privateKey = sk,
            algo = algo,
            publicKey = publicKey,
            hex = jsecPrivateKeyToHexString(sk, curveOrderSize)
        )
        return KeyPair(
            private = privateKey,
            public = publicKey
        )
    }

    actual fun decodePrivateKey(
        key: String,
        algo: SigningAlgorithm
    ): PrivateKey {
        checkSupportedSignAlgo(algo)

        val curveSpec = ECNamedCurveTable.getParameterSpec(algo.curve)
        val curveOrderSize = getCurveOrderSize(ecDomainFromECSpec(curveSpec))
        val curveFieldSize = getCurveFieldSize(ecDomainFromECSpec(curveSpec))

        // check input string has the correct length
        if (key.length != 2 * curveOrderSize) {
            throw IllegalArgumentException("string length must be ${2 * curveOrderSize}, got ${key.length}")
        }

        // ECPrivateKeySpec checks the input scalar is in [1..N-1] so there
        // is no need to check it again.
        // This also enforced by tests in the `SignTest` class
        val ecPrivateKeySpec = ECPrivateKeySpec(BigInteger(key, 16), curveSpec)
        val keyFactory = KeyFactory.getInstance("ECDSA", "BC")
        val sk = keyFactory.generatePrivate(ecPrivateKeySpec)
        // ideally `ecPrivateKeySpec.d` should be randomized or destroyed but
        // BigInteger seems to be an immutable type.
        val pk = derivePublicKey(sk)

        var publicKey = PublicKey(
            publicKey = pk,
            algo = algo,
            hex = jsecPrivateKeyToHexString(pk, curveFieldSize)
        )

        return PrivateKey(
            privateKey = sk,
            algo = algo,
            publicKey = publicKey,
            hex = key
        )
    }

    @JvmStatic
    actual fun getSigner(
        privateKey: PrivateKey,
        hashAlgo: HashingAlgorithm
    ): Signer = SignerImpl(privateKey, hashAlgo)

    @JvmStatic
    fun ecDomainFromECSpec(spec: ECParameterSpec): ECDomainParameters {
        val domain = ECDomainParameters(spec.curve, spec.g, spec.n, spec.h)
        return domain
    }

    @JvmStatic
    fun jsecPrivateKeyToHexString(sk: java.security.PrivateKey, curveOrderSize: Int): String {
        var hexString = ""
        if (sk is ECPrivateKey) {
            val paddedSKBytes = ByteArray(curveOrderSize)
            val skBytes = sk.d.toByteArray()
            // sk byte size must be guaranteed to be less than curveOrderSize at this point
            skBytes.copyInto(paddedSKBytes, max(curveOrderSize - skBytes.size, 0), max(skBytes.size - curveOrderSize, 0))
            hexString = paddedSKBytes.bytesToHex()
            Random.nextBytes(skBytes)
            Random.nextBytes(paddedSKBytes)
        } else {
            throw IllegalArgumentException("PrivateKey must be an ECPublicKey")
        }
        return hexString
    }

    @JvmStatic
    fun jsecPublicKeyToHexString(pk: java.security.PublicKey, curveFieldSize: Int): String {
        val hexString = if (pk is ECPublicKey) {
            val paddedPKBytes = ByteArray(2 * curveFieldSize)
            val xBytes = pk.q.xCoord.encoded
            val yBytes = pk.q.yCoord.encoded
            // x and y must be guaranteed to be less than curveFieldSize each at this point
            xBytes.copyInto(paddedPKBytes, max(curveFieldSize - xBytes.size, 0), max(xBytes.size - curveFieldSize, 0))
            yBytes.copyInto(paddedPKBytes, curveFieldSize + max(curveFieldSize - yBytes.size, 0), max(yBytes.size - curveFieldSize, 0))
            (xBytes + yBytes).bytesToHex()
        } else {
            throw IllegalArgumentException("PublicKey must be an ECPublicKey")
        }
        return hexString
    }


    @JvmStatic
    private fun derivePublicKey(sk: java.security.PrivateKey): java.security.PublicKey {
        val ecSK = if (sk is ECPrivateKey) {
            sk
        } else {
            throw IllegalArgumentException("Private key must be an ECPrivateKey")
        }
        // compute the point
        val curveParams = ecSK.parameters
        val bcPoint = curveParams.curve.multiplier.multiply(curveParams.g, ecSK.d)
        // convert to ECPublicKey
        var ECPointParams = org.bouncycastle.jce.spec.ECPublicKeySpec(bcPoint, curveParams)
        val keyFactory = KeyFactory.getInstance("EC", "BC")
        val publicKey = keyFactory.generatePublic(ECPointParams)
        return publicKey
    }

    @JvmStatic
    fun checkHashAlgoForSigning(hashAlgo: HashingAlgorithm) {
        if (hashAlgo !in listOf(HashingAlgorithm.SHA2_256, HashingAlgorithm.SHA3_256)) {
            // only allow hashes of 256 bits, to match the supported curves (order of 256 bits),
            // although higher hashes could be used in theory (FIPS 186-4)
            throw IllegalArgumentException("Unsupported hash algorithm: ${hashAlgo.value}")
        }
    }

    @JvmStatic
    // curve order size in bytes
    fun getCurveOrderSize(curve: ECDomainParameters): Int {
        val bitSize = curve.n.bitLength()
        val byteSize = (bitSize + 7) / 8
        return byteSize
    }

    @JvmStatic
    // curve prime field size in bytes
    fun getCurveFieldSize(curve: ECDomainParameters): Int {
        val bitSize = curve.curve.fieldSize
        val byteSize = (bitSize + 7) / 8
        return byteSize
    }

    @JvmStatic
    fun formatSignature(r: BigInteger, s: BigInteger, curveOrderSize: Int): ByteArray {
        val paddedSignature = ByteArray(2 * curveOrderSize)
        val rBytes = r.toByteArray()
        val sBytes = s.toByteArray()

        // occasionally R/S bytes representation has leading zeroes, so make sure to copy them appropriately
        rBytes.copyInto(
            paddedSignature,
            max(curveOrderSize - rBytes.size, 0),
            max(rBytes.size - curveOrderSize, 0)
        )
        sBytes.copyInto(
            paddedSignature,
            curveOrderSize + max(curveOrderSize - sBytes.size, 0),
            max(sBytes.size - curveOrderSize, 0)
        )
        return paddedSignature
    }
}

internal class HasherImpl(
    private val hashAlgo: HashingAlgorithm
) : Hasher {

    override fun hash(bytes: ByteArray): ByteArray {
        val digest = MessageDigest.getInstance(hashAlgo.value)
        return digest.digest(bytes)
    }
}

internal class SignerImpl(
    private val privateKey: PrivateKey,
    private val hashAlgo: HashingAlgorithm, override var address: String, override var keyIndex: Int
) : Signer {
    init {
        Crypto.checkSupportedSignAlgo(privateKey.algo)
        Crypto.checkHashAlgoForSigning(hashAlgo)
    }

    override suspend fun sign(transaction: Transaction, bytes: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }

    override suspend fun sign(bytes: ByteArray): ByteArray {
        // check the private key is of the correct type
        val ecSK = if (privateKey.privateKey is ECPrivateKey) {
            privateKey.privateKey
        } else {
            throw IllegalArgumentException("Private key must be an ECPrivateKey")
        }

        // compute the hash
        val hash = HasherImpl(hashAlgo).hash(bytes)

        // sign the hash
        val ecdsaObject = ECDSASigner()
        val domain = Crypto.ecDomainFromECSpec(ecSK.parameters)
        val cipherParams = ECPrivateKeyParameters(ecSK.d, domain)
        ecdsaObject.init(true, cipherParams)
        val RS = ecdsaObject.generateSignature(hash)
        val curveOrderSize = Crypto.getCurveOrderSize(domain)
        return Crypto.formatSignature(RS[0], RS[1], curveOrderSize)
    }
}