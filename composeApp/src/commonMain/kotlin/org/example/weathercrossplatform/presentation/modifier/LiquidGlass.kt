package org.example.weathercrossplatform.presentation.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kashif_e.backdrop.backdrops.LayerBackdrop
import com.kashif_e.backdrop.drawBackdrop
import com.kashif_e.backdrop.effects.blur
import com.kashif_e.backdrop.effects.lens
import com.kashif_e.backdrop.effects.vibrancy

fun Modifier.myLiquidGlass1(
    backdrop: LayerBackdrop
): Modifier =
    this.drawBackdrop(
        backdrop = backdrop,
        shape = { RoundedCornerShape(16.dp) },
        effects = {
            vibrancy()
            blur(3.dp.toPx())
            lens(
                refractionHeight = 24.dp.toPx(),
                refractionAmount = 32.dp.toPx(),
                chromaticAberration = true
            )
        }
    )

fun Modifier.myLiquidGlass2(
    backdrop: LayerBackdrop
): Modifier =
    this.drawBackdrop(
        backdrop = backdrop,
        shape = { RoundedCornerShape(16.dp) },
        effects = {
            vibrancy()
            lens(
                16f.dp.toPx(), 32f.dp.toPx(),
            )
        }
    )

fun Modifier.noLiquidGlass(): Modifier =
    this.background(
        color = Color.Black.copy(alpha = 0.2f),
        shape = RoundedCornerShape(16.dp)
    )