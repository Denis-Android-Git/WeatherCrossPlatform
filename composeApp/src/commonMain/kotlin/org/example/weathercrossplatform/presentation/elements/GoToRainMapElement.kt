package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif_e.backdrop.backdrops.LayerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import org.example.weathercrossplatform.presentation.utils.myLiquidGlass2
import org.example.weathercrossplatform.presentation.utils.noLiquidGlass
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.rainmap

@Composable
fun GoToRainMapElement(
    modifier: Modifier = Modifier,
    backdrop: LayerBackdrop,
    isLiquidGlassOn: Boolean,
    text: String,
    onGoToMapClick: () -> Unit
) {
    Box(
        modifier = if (isLiquidGlassOn) {
            modifier
                .fillMaxWidth()
                .height(150.dp)
                .myLiquidGlass2(backdrop)
                .padding(horizontal = 26.dp, vertical = 8.dp)
                .clickable {
                    onGoToMapClick()
                }
        } else {
            modifier
                .fillMaxWidth()
                .height(150.dp)
                .noLiquidGlass()
                .padding(horizontal = 26.dp, vertical = 8.dp)
                .clickable {
                    onGoToMapClick()
                }
        },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.rainmap), contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(6.dp)).fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.7f,
        )
        Box(
            modifier = Modifier
                .wrapContentSize()
                .noLiquidGlass()
                .padding(horizontal = 11.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun GoToRainMapElementPreview() {
    GoToRainMapElement(
        isLiquidGlassOn = true,
        backdrop = rememberLayerBackdrop(),
        text = "Карта осадков",
        onGoToMapClick = {}
    )
}