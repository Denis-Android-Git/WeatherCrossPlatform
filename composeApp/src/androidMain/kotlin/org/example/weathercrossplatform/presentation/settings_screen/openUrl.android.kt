package org.example.weathercrossplatform.presentation.settings_screen

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
lateinit var appContext: Context

actual fun openUrl(url: String) {
    val context = appContext
    val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(browserIntent)
}