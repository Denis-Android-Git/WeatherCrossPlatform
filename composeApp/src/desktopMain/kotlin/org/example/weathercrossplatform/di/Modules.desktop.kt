package org.example.weathercrossplatform.di

import io.ktor.client.engine.okhttp.OkHttp
import org.example.weathercrossplatform.data.locale.SystemLocale
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.data.network.HttpClientFactory
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    single<MyLogger> { MyLoggerImpl }

    single {
        HttpClientFactory(get()).createHttpClient(OkHttp.create())
    }
    singleOf(::LocationService)
    singleOf(::SystemLocale)
}