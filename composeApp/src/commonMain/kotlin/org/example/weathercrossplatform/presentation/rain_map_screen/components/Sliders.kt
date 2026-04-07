package org.example.weathercrossplatform.presentation.rain_map_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SliderWithCustomThumbSample() {
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val colors = SliderDefaults.colors(thumbColor = Color.Red, activeTrackColor = Color.Red)

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            interactionSource = interactionSource,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            thumb = {
                //SliderDefaults.Thumb(interactionSource = interactionSource, colors = colors)

                Label(
                    label = {
                        PlainTooltip(modifier = Modifier.sizeIn(45.dp, 25.dp).wrapContentWidth()) {
                            Text(sliderPosition.toString())
                        }
                    },
                    interactionSource = interactionSource,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.Red,
                    )
                }
            },
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun SliderWithTrackIconsSample() {
    val sliderState =
        rememberSliderState(
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
    val interactionSource = remember { MutableInteractionSource() }
    val startIcon = rememberVectorPainter(Icons.Filled.Favorite)
    val endIcon = rememberVectorPainter(Icons.Filled.Check)
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = sliderState.value.toString())
        Slider(
            state = sliderState,
            interactionSource = interactionSource,
            track = {
                val iconSize = DpSize(20.dp, 20.dp)
                val iconPadding = 10.dp
                val thumbTrackGapSize = 6.dp
                val activeIconColor = SliderDefaults.colors().activeTickColor
                val inactiveIconColor = SliderDefaults.colors().inactiveTickColor
                val trackIconStart: DrawScope.(Offset, Color) -> Unit = { offset, color ->
                    translate(offset.x + iconPadding.toPx(), offset.y) {
                        with(startIcon) {
                            draw(iconSize.toSize(), colorFilter = ColorFilter.tint(color))
                        }
                    }
                }
                val trackIconEnd: DrawScope.(Offset, Color) -> Unit = { offset, color ->
                    translate(offset.x - iconPadding.toPx() - iconSize.toSize().width, offset.y) {
                        with(endIcon) {
                            draw(iconSize.toSize(), colorFilter = ColorFilter.tint(color))
                        }
                    }
                }
                SliderDefaults.Track(
                    sliderState = sliderState,
                    modifier =
                        Modifier.height(36.dp).drawWithContent {
                            drawContent()
                            val yOffset = size.height / 2 - iconSize.toSize().height / 2
                            val activeTrackStart = 0f
                            val activeTrackEnd =
                                size.width * sliderState.coercedValueAsFraction -
                                        thumbTrackGapSize.toPx()
                            val inactiveTrackStart = activeTrackEnd + thumbTrackGapSize.toPx() * 2
                            val inactiveTrackEnd = size.width
                            val activeTrackWidth = activeTrackEnd - activeTrackStart
                            val inactiveTrackWidth = inactiveTrackEnd - inactiveTrackStart
                            if (
                                iconSize.toSize().width < activeTrackWidth - iconPadding.toPx() * 2
                            ) {
                                trackIconStart(Offset(activeTrackStart, yOffset), activeIconColor)
                                trackIconEnd(Offset(activeTrackEnd, yOffset), activeIconColor)
                            }
                            if (
                                iconSize.toSize().width <
                                inactiveTrackWidth - iconPadding.toPx() * 2
                            ) {
                                trackIconStart(
                                    Offset(inactiveTrackStart, yOffset),
                                    inactiveIconColor,
                                )
                                trackIconEnd(Offset(inactiveTrackEnd, yOffset), inactiveIconColor)
                            }
                        },
                    trackCornerSize = 12.dp,
                    drawStopIndicator = null,
                    thumbTrackGapSize = thumbTrackGapSize,
                )
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSlider(
    steps: Int = 3,
    startValue: Int,
    endValue: Int,
    selectedSliderValue: Float,
    onSliderValueChange: (Float) -> Unit = {},
    onValueChange: (selectedIndex: Int, sliderValue: Float) -> Unit = { _, _ -> }
) {
    val safeSteps = if (steps < 0) 0 else steps
    var trackWidth by remember { mutableStateOf(IntSize.Zero) }
    val density = LocalDensity.current
    val hapticFeedback = LocalHapticFeedback.current
    var previousStep by remember { mutableIntStateOf(-1) }
    val valueRange = endValue.toFloat() - startValue.toFloat()

    LaunchedEffect(selectedSliderValue) {
        // Sync external state changes
        val result = if (safeSteps == 0) {
            handleZeroStepsChange(selectedSliderValue, startValue, endValue, valueRange, previousStep)
        } else {
            handleMultiStepsChange(selectedSliderValue, startValue, valueRange, safeSteps, previousStep)
        }
        previousStep = result.selectedIndex
    }

    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Slider(
            value = selectedSliderValue,
            onValueChange = { newValue ->
                val result = if (safeSteps == 0) {
                    handleZeroStepsChange(newValue, startValue, endValue, valueRange, previousStep)
                } else {
                    handleMultiStepsChange(newValue, startValue, valueRange, safeSteps, previousStep)
                }

                onSliderValueChange(result.newSliderValue)

                if (result.shouldTriggerCallback) {
                    hapticFeedback.performHapticFeedback(HapticFeedbackType.SegmentFrequentTick)
                    onValueChange(result.selectedIndex, result.newSliderValue)
                }
            },
            valueRange = startValue.toFloat()..endValue.toFloat(),
            modifier = Modifier.fillMaxWidth(),
            steps = safeSteps,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xffce35d9),
                activeTrackColor = Color(0xFF357BD9),
                inactiveTrackColor = Color(0xFFBCBCBC)
            ),
            thumb = { CustomSliderThumb() },
            track = { sliderState ->
                CustomSliderTrack(
                    sliderState = sliderState,
                    trackWidth = trackWidth,
                    onTrackSized = { trackWidth = it },
                    density = density,
                    startValue = startValue,
                    valueRange = valueRange,
                    steps = safeSteps
                )
            }
        )

        // Value labels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(startValue.toString(), style = typography.bodyLarge, color = Color(0xFFBCBCBC))
            Text(endValue.toString(), style = typography.bodyMedium, color = Color(0xff2b1b1b))
        }
    }
}
private fun handleZeroStepsChange(
    newValue: Float,
    startValue: Int,
    endValue: Int,
    valueRange: Float,
    previousStep: Int
): SliderChangeResult {
    val progress = ((newValue - startValue.toFloat()) / valueRange).coerceIn(0f, 1f)
    val selectedIndex = if (progress >= 0.5f) 1 else 0
    val snappedValue = if (selectedIndex == 1) endValue.toFloat() else startValue.toFloat()
    val shouldTriggerCallback = selectedIndex != previousStep

    return SliderChangeResult(snappedValue, selectedIndex, shouldTriggerCallback)
}
private data class SliderChangeResult(
    val newSliderValue: Float,
    val selectedIndex: Int,
    val shouldTriggerCallback: Boolean
)

private fun handleMultiStepsChange(
    newValue: Float,
    startValue: Int,
    valueRange: Float,
    safeSteps: Int,
    previousStep: Int
): SliderChangeResult {
    // Normalize progress to [0,1]
    val progress = ((newValue - startValue.toFloat()) / valueRange).coerceIn(0f, 1f)

    // Total discrete positions = steps + 2 (start + steps + end)
    val totalPositions = safeSteps + 2

    // Find closest discrete position
    val roundedIndex = (progress * (totalPositions - 1)).roundToInt()
        .coerceIn(0, totalPositions - 1)

    // Calculate exact slider value for this position
    val stepSize = valueRange / (totalPositions - 1)
    val snappedValue = startValue.toFloat() + (roundedIndex * stepSize)

    val shouldTriggerCallback = roundedIndex != previousStep

    return SliderChangeResult(snappedValue, roundedIndex, shouldTriggerCallback)
}
@Composable
private fun CustomSliderThumb() {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(Color(0xffce35d9))
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomSliderTrack(
    sliderState: SliderState,
    trackWidth: IntSize,
    onTrackSized: (IntSize) -> Unit,
    density: Density,
    startValue: Int,
    valueRange: Float,
    steps: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Left edge cap
        Box(
            modifier = Modifier
                .height(8.dp)
                .width(5.dp)
                .background(Color(0xff3277aa))
        )

        // Main track body
        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .background(Color.Transparent)
                .onGloballyPositioned { coordinates ->
                    onTrackSized(coordinates.size)
                }
        ) {
            if (trackWidth != IntSize.Zero) {
                val trackWidthDp = with(density) { trackWidth.width.toDp() }
                val progress = (sliderState.value - startValue.toFloat()) / valueRange

                // Background track (inactive)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color(0xFFBCBCBC))
                )

                // Active track (filled portion)
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .height(4.dp)
                        .background(Color(0xFF357BD9))
                )

                // Step tick marks
                val totalSegments = steps + 1
                for (step in 1..steps) {
                    val position = step.toFloat() / totalSegments.toFloat()
                    val tickX = trackWidthDp * position - 2.dp
                    Box(
                        modifier = Modifier
                            .size(width = 4.dp, height = 8.dp)
                            .offset(x = tickX)
                            .background(Color(0xffbd4b4b))
                    )
                }
            }
        }

        // Right edge cap
        Box(
            modifier = Modifier
                .height(8.dp)
                .width(5.dp)
                .background(Color(0xFFBCBCBC))
        )
    }
}

@Preview(showBackground = true, name = "Default Slider")
@Composable
fun CustomSliderPreview() {
    CustomSlider(steps = 2, startValue = 10, endValue = 100, selectedSliderValue = 10f)
}

@Preview(showBackground = true, name = "Mid-Range Value")
@Composable
fun CustomSliderWithSelectedValuePreview() {
    CustomSlider(steps = 2, startValue = 10, endValue = 100, selectedSliderValue = 50f)
}

@Preview(showBackground = true, name = "Many Steps")
@Composable
fun CustomSliderWithValuePreview() {
    CustomSlider(steps = 9, startValue = 20, endValue = 150, selectedSliderValue = 30f)
}