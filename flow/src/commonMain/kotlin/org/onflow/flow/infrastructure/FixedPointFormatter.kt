package org.onflow.flow.infrastructure

expect object FixedPointFormatter {
    fun format(num: String, precision: ULong): String?
}