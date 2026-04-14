package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RainMapRoot(
    viewModel: RainMapViewModel,
    onBackButtonClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RainMapScreen(
        state = state,
        onAction = viewModel::onAction,
        onBackButtonClick = onBackButtonClick
    )
}