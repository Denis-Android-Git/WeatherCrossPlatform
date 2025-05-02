package org.example.weathercrossplatform.di

import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.domain.repo.WeatherRepo
import org.example.weathercrossplatform.viewmodels.SearchViewModel
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    singleOf(::WeatherRepoImpl).bind<WeatherRepo>()
    viewModelOf(::WeatherViewModel)
    viewModelOf(::SearchViewModel)
}