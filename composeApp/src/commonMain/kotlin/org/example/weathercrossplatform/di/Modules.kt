package org.example.weathercrossplatform.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.example.weathercrossplatform.data.database.DbFactory
import org.example.weathercrossplatform.data.repo_impl.DataBaseRepoImpl
import org.example.weathercrossplatform.data.repo_impl.DataStoreSettingsStorage
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import org.example.weathercrossplatform.domain.repo.SettingsStorage
import org.example.weathercrossplatform.domain.repo.WeatherRepo
import org.example.weathercrossplatform.presentation.navigation.NavHostViewModel
import org.example.weathercrossplatform.presentation.search_weather.SearchViewModel
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenViewModel
import org.example.weathercrossplatform.presentation.weather_list.WeatherViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        get<DbFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigration(
                dropAllTables = true
            )
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
    singleOf(::WeatherRepoImpl).bind<WeatherRepo>()
    singleOf(::DataBaseRepoImpl).bind<DataBaseRepo>()
    singleOf(::DataStoreSettingsStorage) bind SettingsStorage::class
    viewModel { (pageNumber: Int?, orientation: String) ->
        WeatherViewModel(
            locationService = get(),
            weatherRepo = get(),
            dataBaseRepo = get(),
            myLogger = get(),
            settingsStorage = get(),
            pageNumberFromSearchScreen = pageNumber,
            orientation = orientation
        )
    }
    viewModelOf(::SearchViewModel)
    viewModelOf(::SettingsScreenViewModel)
    viewModelOf(::NavHostViewModel)
}