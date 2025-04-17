package org.onflow.flow.infrastructure

import org.onflow.flow.ChainId
import org.onflow.flow.infrastructure.scripts.ContractAddressRegister
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ContractAddressRegisterTest {
    
    @Test
    fun testGetAddress() {
        val register = ContractAddressRegister()
        val address = register.getAddress("EVM", ChainId.Testnet)
        assertNotNull(address)
        assertEquals("0x8c5303eaa26202d6", address)
    }
    
    @Test
    fun testContractExists() {
        val register = ContractAddressRegister()
        assertTrue(register.contractExists("EVM", ChainId.Testnet))
    }
    
    @Test
    fun testResolveImports() {
        val register = ContractAddressRegister()
        val code = """
            import EVM from 0xEVM
            
            access(all) fun main(flowAddress: Address): String? {
                if let address: EVM.EVMAddress = getAuthAccount<auth(BorrowValue) &Account>(flowAddress)
                    .storage.borrow<&EVM.CadenceOwnedAccount>(from: /storage/evm)?.address() {
                    let bytes: [UInt8] = []
                    for byte in address.bytes {
                        bytes.append(byte)
                    }
                    return String.encodeHex(bytes)
                }
                return nil
            }
        """.trimIndent()
        
        val resolvedCode = register.resolveImports(code, ChainId.Testnet)
        println(resolvedCode)
        assertTrue(resolvedCode.contains("import EVM from 0x8c5303eaa26202d6"))
    }


    @Test
    fun testImportAddresses() {
        val register = ContractAddressRegister()
        val newAddresses = mapOf("0xTest" to "0x1234567890")
        register.importAddresses(ChainId.Testnet, newAddresses)
        assertEquals("0x1234567890", register.getAddress("0xTest", ChainId.Testnet))
    }
} 