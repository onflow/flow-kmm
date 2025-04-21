package org.onflow.flow.wallet

import org.onflow.flow.models.Signer
import org.onflow.flow.models.Transaction

interface Wallet {
    val address: String
    val signer: Signer
    
    suspend fun signTransaction(transaction: Transaction): Transaction
    suspend fun signMessage(message: ByteArray): ByteArray
} 