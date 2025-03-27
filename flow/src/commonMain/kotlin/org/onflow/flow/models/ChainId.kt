import kotlinx.serialization.Serializable

@Serializable
enum class ChainId(val id: String) {
    UNKNOWN("unknown"),
    MAINNET("flow-mainnet"),
    TESTNET("flow-testnet"),
    CANARYNET("flow-canarynet"),
    EMULATOR("flow-emulator"),
    SANDBOX("flow-sandboxnet"),
    PREVIEWNET("flow-previewnet");

    companion object {
        fun of(id: String): FlowChainId = values().find { it.id == id } ?: UNKNOWN
    }
}
