package org.example.weathercrossplatform.presentation.settings_screen

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openUrl(url: String) {
    val nsUrl = NSURL(string = url)

    UIApplication.sharedApplication.openURL(
        nsUrl,
        emptyMap<Any?, Any?>()
    ) {

    }
}