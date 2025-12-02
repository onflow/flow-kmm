package org.onflow.flow

import io.ktor.util.decodeBase64Bytes
import org.onflow.flow.infrastructure.Cadence
import org.onflow.flow.models.Signer
import org.onflow.flow.models.Transaction

enum class CadenceTargetType {
    Query,
    Transaction
}

data class CadenceTarget(
    val cadenceBase64: String,
    val type: CadenceTargetType,
    val arguments: List<Cadence.Value> = emptyList()
)

suspend fun FlowApi.query(target: CadenceTarget): Cadence.Value {
    val script = target.cadenceBase64.decodeBase64Bytes().decodeToString()
    return executeScript(script = script, arguments = target.arguments)
}

suspend fun FlowApi.sendTransaction(
    target: CadenceTarget,
    signers: List<Signer>,
    chainId: ChainIdProvider = this.chainId,
    addressRegistry: AddressRegistry = AddressRegistry(),
    builder: TransactionDSLBuilder.() -> Unit
): Transaction {
    val script = target.cadenceBase64.decodeBase64Bytes().decodeToString()
    val combinedBuilder: TransactionDSLBuilder.() -> Unit = {
        cadence { script }
        arguments { target.arguments }
        builder()
    }

    val unsignedTx = buildTransaction(chainId, addressRegistry, combinedBuilder)
    val signedTx = signTransaction(unsignedTx, signers)
    return sendTransaction(signedTx)
}
