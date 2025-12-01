import FungibleToken from 0xFUNGIBLETOKEN
import FlowToken from 0xFLOWTOKEN
import EVM from 0xEVM

transaction(rlpEncodedTransaction: [UInt8],  coinbaseAddr: String) {

  prepare(signer: auth(Storage, EVM.Withdraw) &Account) {
	let coinbase = EVM.addressFromString(coinbaseAddr)

	let runResult = EVM.run(tx: rlpEncodedTransaction, coinbase: coinbase)
	assert(
	    runResult.status == EVM.Status.successful,
	    message: "evm tx was not executed successfully."
	)
  }
  
  execute {
  }
}
