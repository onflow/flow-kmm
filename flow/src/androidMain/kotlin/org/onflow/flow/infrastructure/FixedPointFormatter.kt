package org.onflow.flow.infrastructure

import java.math.BigDecimal

actual object FixedPointFormatter {
    actual fun format(num: String, precision: ULong): String? {
        val bd = BigDecimal(num)
        return String.format("%.8f", bd)
    }
}