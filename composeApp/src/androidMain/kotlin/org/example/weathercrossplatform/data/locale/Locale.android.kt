package org.example.weathercrossplatform.data.locale

import java.util.Locale

actual class SystemLocale {
    actual fun getSystemLanguage(): String {
        return Locale.getDefault().language
    }
}