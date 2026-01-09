package org.example.weathercrossplatform.presentation.elements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.example.weathercrossplatform.presentation.image_vectors.Pull
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.pull

@Composable
fun ErrorScreen(
    errorMessage: String
) {

    val scrollState = rememberScrollState()

    var showArrow by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        while (true) {
            delay(1000)
            showArrow = !showArrow
        }
    }

    val animateAlpha by animateFloatAsState(
        targetValue = if (showArrow) 1f else 0f,
        animationSpec = tween(durationMillis = 500)
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorMessage, textAlign = TextAlign.Center, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(Res.string.pull), textAlign = TextAlign.Center, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Pull,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.alpha(animateAlpha)
        )
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(errorMessage = "Error")
}