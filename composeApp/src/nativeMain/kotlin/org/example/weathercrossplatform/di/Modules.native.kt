package org.example.weathercrossplatform.di

import io.ktor.client.engine.darwin.Darwin
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.createHttpClient
import org.koin.dsl.module

actual val platformModule = module {
    single {
        createHttpClient(Darwin.create())
    }

    single {
        LocationService()
    }
}