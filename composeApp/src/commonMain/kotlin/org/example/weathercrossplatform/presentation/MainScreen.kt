package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weather by weatherViewModel.weather.collectAsStateWithLifecycle()
    val error by weatherViewModel.error.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Granted")
        weather?.let {
            Text(text = "${it.current.tempC} - ${it.location.name}")
            val icon = it.current.condition.icon.replace("//", "https://")

            println("image - $icon")

            AsyncImage(
                model = icon,
                contentDescription = null
            )

            SubcomposeAsyncImage(
                model = icon,
                contentDescription = null
            ) {
                when (val state = painter.state.value) {
                    is AsyncImagePainter.State.Loading -> {
                        CircularProgressIndicator(
                        )
                    }

                    is AsyncImagePainter.State.Error -> {
                        state.result.throwable.message?.let { error ->
                            Text(text = error)
                        }
                    }

                    else -> {
                        SubcomposeAsyncImageContent()
                    }
                }
            }
        }
        error?.let {
            Text(text = it)
        }
    }
}