package org.example.weathercrossplatform

import android.app.Application
import android.content.Context
import org.example.weathercrossplatform.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        initKoin {
            androidContext(this@MyApp)
        }
    }
}
lateinit var appContext: Context
