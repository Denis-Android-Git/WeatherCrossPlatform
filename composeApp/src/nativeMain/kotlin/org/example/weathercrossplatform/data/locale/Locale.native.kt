package org.example.weathercrossplatform.data.locale

import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages

actual class SystemLocale {
    actual fun getSystemLanguage(): String {
        val lang = NSLocale.preferredLanguages.first() as String
        return lang.substringBefore("-")
    }
}