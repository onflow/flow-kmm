package org.onflow.flow.infrastructure

import platform.Foundation.NSDecimalNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle

actual object FixedPointFormatter {
    actual fun format(num: String, precision: ULong): String? {
        val formatter = NSNumberFormatter()
        formatter.minimumFractionDigits = precision
        formatter.maximumFractionDigits = precision
        formatter.numberStyle = NSNumberFormatterDecimalStyle
        val nsNum = NSDecimalNumber(num)
        return formatter.stringFromNumber(nsNum)
    }
}