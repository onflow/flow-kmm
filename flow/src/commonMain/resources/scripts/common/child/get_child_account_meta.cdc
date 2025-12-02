import HybridCustody from 0xHYBRIDCUSTODY
import MetadataViews from 0xNONFUNGIBLETOKEN

access(all) fun main(parent: Address): {Address: AnyStruct} {
    let acct = getAuthAccount<auth(Storage) &Account>(parent)
    let m = acct.storage.borrow<&HybridCustody.Manager>(from: HybridCustody.ManagerStoragePath)

    if m == nil {
        return {}
    } else {
        var data: {Address: AnyStruct} = {}
        for address in m?.getChildAddresses()! {
            let c = m?.getChildAccountDisplay(address: address) 
            data.insert(key: address, c)
        }
        return data
    }
}
