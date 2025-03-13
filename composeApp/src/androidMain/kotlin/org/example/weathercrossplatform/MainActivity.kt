package org.example.weathercrossplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import io.ktor.client.engine.okhttp.OkHttp
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.repo_impl.createHttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            App(
                locationService = remember {
                    LocationService(context)
                },
                weatherRepoImpl = remember {
                    WeatherRepoImpl(createHttpClient(OkHttp.create()))
                }
            )
        }
    }
}