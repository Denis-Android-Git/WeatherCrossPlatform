package com.example.androidapp

import android.app.Application
import android.webkit.WebView
import org.example.weathercrossplatform.di.initKoin
import org.example.weathercrossplatform.presentation.settings_screen.appContext
import org.koin.android.ext.koin.androidContext

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        WebView.setWebContentsDebuggingEnabled(true)
        appContext = this
        initKoin {
            androidContext(this@MyApp)
        }
    }
}
