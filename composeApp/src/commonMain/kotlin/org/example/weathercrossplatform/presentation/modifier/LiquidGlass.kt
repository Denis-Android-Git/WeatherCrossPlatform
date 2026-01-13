package org.example.weathercrossplatform.presentation.modifier

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kashif_e.backdrop.Backdrop
import com.kashif_e.backdrop.drawBackdrop
import com.kashif_e.backdrop.effects.blur
import com.kashif_e.backdrop.effects.lens
import com.kashif_e.backdrop.effects.vibrancy

fun Modifier.myLiquidGlass(
    backdrop: Backdrop
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