package com.example.androidapp.inappupdate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun UpdateProgressIndicator(
    progress: Float
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        LinearWavyProgressIndicator(
            progress = { progress },
            modifier = Modifier.systemBarsPadding().padding(top = 40.dp, start = 16.dp),
            color = Color(0xFF357BD9),
            stopSize = 0.dp
        )
    }
}

@Preview
@Composable
fun PreviewUpdateProgressIndicatorState() {
    UpdateProgressIndicator(progress = 0.5f)
}
