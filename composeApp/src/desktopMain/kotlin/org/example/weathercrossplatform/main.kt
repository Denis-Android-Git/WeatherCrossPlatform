package org.example.weathercrossplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "WeatherCrossPlatform",
    ) {
//        App(
//            locationService = remember {
//                LocationService(context)
//            },
//            weatherRepoImpl = remember {
//                WeatherRepoImpl(createHttpClient(OkHttp.create()))
//            })
    }
}