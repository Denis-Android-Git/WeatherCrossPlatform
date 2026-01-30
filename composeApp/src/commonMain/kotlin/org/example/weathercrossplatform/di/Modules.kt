package org.example.weathercrossplatform.di

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
    singleOf(::WeatherRepoImpl).bind<WeatherRepo>()
    singleOf(::DataBaseRepoImpl).bind<DataBaseRepo>()
    singleOf(::DataStoreSettingsStorage) bind SettingsStorage::class
    //viewModelOf(::WeatherViewModel)
    viewModel { (pageNumber: Int?, cityId: Int?, orientation: String) ->
        WeatherViewModel(
            locationService = get(),
            weatherRepoImpl = get(),
            dataBaseRepo = get(),
            myLogger = get(),
            settingsStorage = get(),
            pageNumberFromSearchScreen = pageNumber,
            cityIdFromSearchScreen = cityId,
            orientation = orientation
        )
    }
    viewModelOf(::SearchViewModel)
    viewModelOf(::SettingsScreenViewModel)
    viewModelOf(::NavHostViewModel)
}