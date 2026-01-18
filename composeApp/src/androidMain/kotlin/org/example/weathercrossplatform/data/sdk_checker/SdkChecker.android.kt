package org.example.weathercrossplatform.data.sdk_checker

import android.os.Build

actual fun isLiquidGlassAvailable(): Boolean {
    return when {
        Build.VERSION.SDK_INT >= 31 -> true
        else -> false
    }
}