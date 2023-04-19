# Flow KMM SDK

The Flow KMM SDK is an open-source Kotlin Multiplatform Mobile (KMM) library for building Android and iOS applications on the Flow blockchain. It provides a set of APIs for querying the blockchain, managing accounts, interacting with smart contracts, and handling cryptographic operations.

## Features

- Kotlin Multiplatform Mobile (KMM) support for Android and iOS
- Flow Client for interacting with the Flow blockchain
- Interacting with Flow smart contracts
- Sending transactions to the Flow blockchain
- Encode and decode Cadence values & type

## Get Started

#### Android

```groovy
dependencies {
		implementation("org.onflow:flow:$flowKMMVersion")
}
```

#### iOS

We recommend to use Swift Package, and which can be installed via Xcode with the URL of this repository:

```swift
dependencies: [
	.package(url: "https://github.com/onflow/flow-kmm", from: "$flowKMMVersion")
]
```

## API & Examples

The library communicates with access nodes via the Flow RESTful API. You can find the 📖 **RESTful API** documentation [here](https://docs.onflow.org/http-api). To start using the SDK, simply provide the desired chainID. You can configure the chainID as follows:

##### Android

```kotlin
// Android - Mainnet
val api = FlowApi(ChainId.Mainnet)

// Testnet
val api = FlowApi(ChainId.Testnet)

// Custom Endpoint
val accessProvider = ChainId.Custom("https://custom.access.endpoint", "Custom Chain")
val api = FlowApi(accessProvider)
```

##### iOS

```swift
// iOS - Mainnet
let api = FlowApi(chainId: ChainId.Mainnet())
// Testnet
let api = FlowApi(chainId: ChainId.Testnet())
// Custom Endpoint
let provider = ChainId.Custom(baseUrl: "https://custom.access.endpoint", description: "Custom Chain")
let api = FlowApi(chainId: provider)
```

## Querying the Flow Network

Once you've connected to an access node, you can interact with the Flow blockchain to obtain information on blocks, accounts, events, and transactions. In the following sections, we'll delve into the process of retrieving each of these entities.

### Get Account

Retrieve any account from Flow network's latest block or from a specified block height.

📖 **Account address** is a unique account identifier. Be mindful about the `0x` prefix, you should use the prefix as a default representation but be careful and safely handle user inputs without the prefix.

An account includes the following data:

- **Address**: the account address.
- **Balance**: balance of the account.
- **Contracts**: list of contracts deployed to the account.
- **Keys**: list of keys associated with the account.

```kotlin
// Android
val account = api.getAccount("0x328649a25184b171")

// iOS
let account = try await api.getAccount(address: "0x328649a25184b171")
```

### Get Block

Query the network for block by id, height or get the latest block.

📖 **Block ID** is SHA3-256 hash of the entire block payload. This hash is stored as an ID field on any block response object (ie. response from `GetLatestBlock`).

📖 **Block height** expresses the height of the block on the chain. The latest block height increases by one for every valid block produced.

##### Android

```kotlin
// Get Latest Block
val latestBlock = api.getBlock()

// Get Block by id
val block = api.getBlock(id = "e285bafe8372ae0ad9e0070218c35588b83a09a2a4fa0e1cdc71eedc2488bce1")
```

##### iOS

```swift
// Get Latest Block
let latestBlock = try await api.getBlock(id: nil, blockHeight: nil, sealed: true)

// Get Block by id
let block = try await api.getBlock(id: "e285bafe8372ae0ad9e0070218c35588b83a09a2a4fa0e1cdc71eedc2488bce1", 
                                   blockHeight: nil, 
                                   sealed: true)
```

## Contributing

We welcome contributions to the Flow KMM SDK! Please read our [CONTRIBUTING.md](./CONTRIBUTING.md) file for guidelines on submitting issues, feature requests, and pull requests.

## License

The Flow KMM SDK is released under the [Apache License 2.0](./LICENSE).
