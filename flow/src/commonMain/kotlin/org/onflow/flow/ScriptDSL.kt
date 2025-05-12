package org.onflow.flow

import org.onflow.flow.infrastructure.Cadence

fun flowScript(block: ScriptBuilder.() -> Unit): ScriptBuilder {
    val ret = ScriptBuilder()
    block(ret)
    return ret
}

suspend fun FlowApi.query(
    chainId: ChainId = ChainId.Mainnet,
    block: ScriptBuilder.() -> Unit
): Cadence.Value {
    val api = this
    val builder = flowScript(block)
    val registry = AddressRegistry()
    return try {
        api.executeScript(
            script = registry.processScript(builder.script, chainId),
            arguments = builder.arguments
        )
    } catch (t: Throwable) {
        throw Exception("Error while running script", t)
    }
}

class ScriptBuilder {
    private var _script: String? = null
    private var _arguments: MutableList<Cadence.Value> = mutableListOf()

    var script: String
        get() {
            return _script!!
        }
        set(value) {
            _script = value
        }

    fun script(script: String) {
        this.script = script
    }

    fun script(code: ByteArray) = script(code.decodeToString())

    fun script(code: () -> String) = script(code())

    var arguments: MutableList<Cadence.Value>
        get() {
            return _arguments
        }
        set(value) {
            _arguments.clear()
            _arguments.addAll(value)
        }

    fun arguments(arguments: MutableList<Cadence.Value>) {
        this.arguments = arguments
    }

    fun args(arguments: () -> MutableList<Cadence.Value>) = arguments(arguments())
    fun args(vararg arguments: Cadence.Value) = arguments(arguments.toMutableList())

    fun arg(argument: Cadence.Value) = _arguments.add(argument)
    fun arg(argument: () -> Cadence.Value) = arg(argument())
}
