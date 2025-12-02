import HybridCustody from 0xHYBRIDCUSTODY

access(all) fun main(parent: Address): [Address] {
    let acct = getAuthAccount<auth(Storage) &Account>(parent)
    if let manager = acct.storage.borrow<&HybridCustody.Manager>(from: HybridCustody.ManagerStoragePath) {
        return  manager.getChildAddresses()
    }
    return []
}
