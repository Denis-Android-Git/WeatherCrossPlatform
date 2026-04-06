package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RainMapRoot(
    viewModel: RainMapViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RainMapScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun RainMapScreen(
    state: RainMapState,
    onAction: (RainMapAction) -> Unit,
) {
    RainMapWebView(
        modifier = Modifier.fillMaxSize(),
        latitude = state.latitude,
        longitude = state.longitude,
        zoom = state.zoom,
        date = state.date,
        hour = state.hour
    )
}

@Preview
@Composable
fun RainMapScreenPreview() {
    RainMapScreen(
        state = RainMapState(),
        onAction = {}
    )
}