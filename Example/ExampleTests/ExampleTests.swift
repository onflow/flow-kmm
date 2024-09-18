//
//  ExampleTests.swift
//  ExampleTests
//
//  Created by Hao Fu on 18/4/2023.
//

import XCTest
@testable import Example
import Flow
import CryptoKit

class ECDSA_P256_Signer: Signer {

    var keyIndex: Int32
    var address: String
    var privateKey: P256.Signing.PrivateKey

    init(address: String, keyIndex: Int32, privateKey: P256.Signing.PrivateKey) {
        self.address = address
        self.keyIndex = keyIndex
        self.privateKey = privateKey
    }

    func sign(bytes: KotlinByteArray) async -> KotlinByteArray {
        let data = Data(bytes.toHexString().hexValue)
        let hashedData = SHA256.hash(data: data)
        let signature = try? privateKey.signature(for: hashedData)
        return bytes
    }


}


final class ExampleTests: XCTestCase {

    let addressA = "0xc6de0d94160377cd"
    let publicKeyA = try! P256.KeyAgreement.PublicKey(rawRepresentation: "d487802b66e5c0498ead1c3f576b718949a3500218e97a6a4a62bf69a8b0019789639bc7acaca63f5889c1e7251c19066abb09fcd6b273e394a8ac4ee1a3372f".hexValue)
    let privateKeyA = try! P256.Signing.PrivateKey(rawRepresentation: "c9c0f04adddf7674d265c395de300a65a777d3ec412bba5bfdfd12cffbbb78d9".hexValue)

    let api = FlowApi(chainId: ChainId.Testnet())

    func testSign() throws {

        Transaction(id: nil,
                    script: <#T##String#>,
                    arguments: <#T##[Cadence.Value]#>,
                    referenceBlockId: <#T##String#>,
                    gasLimit: <#T##BignumBigInteger#>,
                    payer: <#T##String#>,
                    proposalKey: <#T##ProposalKey#>,
                    authorizers: <#T##[String]#>,
                    payloadSignatures: [],
                    envelopeSignatures: [],
                    expandable: nil,
                    result: nil,
                    links: nil)

//        api.sendTransaction(request: <#T##Transaction#>, completionHandler: <#T##(Transaction?, Error?) -> Void#>)
    }

}

extension String {
    /// Convert hex string to bytes
    var hexValue: [UInt8] {
        var startIndex = self.startIndex
        return (0 ..< count / 2).compactMap { _ in
            let endIndex = index(after: startIndex)
            defer { startIndex = index(after: endIndex) }
            return UInt8(self[startIndex ... endIndex], radix: 16)
        }
    }
}
