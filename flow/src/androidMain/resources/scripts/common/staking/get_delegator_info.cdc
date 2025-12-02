import FlowStakingCollection from 0xFLOWTABLESTAKING
import FlowIDTableStaking from 0xFLOWTABLESTAKING
import LockedTokens from 0xLOCKEDTOKENS
        
access(all) fun main(address: Address): [FlowIDTableStaking.DelegatorInfo]? {
    var res: [FlowIDTableStaking.DelegatorInfo]? = nil

    let inited = FlowStakingCollection.doesAccountHaveStakingCollection(address: address)

    if inited {
        res = FlowStakingCollection.getAllDelegatorInfo(address: address)
    }
    return res
}
