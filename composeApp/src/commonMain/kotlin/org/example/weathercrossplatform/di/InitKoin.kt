package org.example.weathercrossplatform.di

import io.kotzilla.sdk.analytics.koin.analytics
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.mp.KoinPlatform.getKoin

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(platformModule, sharedModule)
        // Add kotzilla analytics
        analytics()
    }
    GlobalScope.launch(Dispatchers.Default) { //warm up HttpClient
        getKoin().get<HttpClient>()
    }
}