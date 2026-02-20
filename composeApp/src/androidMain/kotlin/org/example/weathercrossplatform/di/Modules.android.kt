package org.example.weathercrossplatform.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.engine.okhttp.OkHttp
import org.example.weathercrossplatform.data.createDataStore
import org.example.weathercrossplatform.data.database.DbFactory
import org.example.weathercrossplatform.data.lifecycleObserver.LifeCycleObserver
import org.example.weathercrossplatform.data.locale.SystemLocale
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.data.network.HttpClientFactory
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {

    single<MyLogger> { MyLoggerImpl }

    single {
        HttpClientFactory(get()).createHttpClient(OkHttp.create())
    }
    single {
        DbFactory(androidContext())
    }
    single<DataStore<Preferences>> {
        createDataStore(androidContext())
    }
    singleOf(::LifeCycleObserver)
    factoryOf(::LocationService)
    factoryOf(::SystemLocale)
}