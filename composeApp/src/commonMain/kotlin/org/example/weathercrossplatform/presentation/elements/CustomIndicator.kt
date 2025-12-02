package org.example.weathercrossplatform.presentation.elements

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.PositionalThreshold
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CustomIndicator(
    state: PullToRefreshState,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier,
    containerColor: Color,
    color: Color,
    threshold: Dp = PositionalThreshold,
    size: Dp
) {
    IndicatorBox(
        modifier = modifier,
        state = state,
        isRefreshing = isRefreshing,
        containerColor = containerColor,
        threshold = threshold,
    ) {
        Crossfade(
            targetState = isRefreshing,
            animationSpec = tween(durationMillis = 300, delayMillis = 0),
        ) { refreshing ->
            if (refreshing) {
//                CircularWavyProgressIndicator(
//                    color = color,
//                    modifier = Modifier.size(size),
//                )
                LoadingIndicator(
                    modifier = Modifier.size(size),
                    color = color
                )
            } else {
                CustomCircularArrowProgressIndicator(
                    progress = { state.distanceFraction },
                    color = color,
                )
            }
        }
    }
}

@Composable
fun CustomCircularArrowProgressIndicator(progress: MyFloatProducer, color: Color) {
    val path = remember { Path().apply { fillType = PathFillType.EvenOdd } }
    val targetAlpha by remember { derivedStateOf { if (progress() >= 1f) 1f else 0.3f } }
    val alphaState =
        animateFloatAsState(
            targetValue = targetAlpha,
            animationSpec = tween(durationMillis = 300, delayMillis = 0),
        )

    Canvas(
        modifier =
            Modifier.clearAndSetSemantics {
                if (progress() > 0f) {
                    progressBarRangeInfo = ProgressBarRangeInfo(progress(), 0f..1f, 0)
                }
            }
                .size(16.dp)
    ) {
        val values = MyArrowValues(progress())
        val alpha = alphaState.value
        rotate(degrees = values.rotation) {
            val arcRadius = 5.5.dp.toPx() + 2.5.dp.toPx() / 2f
            val arcBounds = Rect(center = size.center, radius = arcRadius)
            myDrawCircularIndicator(color, alpha, values, arcBounds, 2.5.dp)
            myDrawArrow(path, arcBounds, color, alpha, values, 2.5.dp)
        }
    }
}

fun MyArrowValues(progress: Float): MyArrowValues {
    val adjustedPercent = max(min(1f, progress) - 0.4f, 0f) * 5 / 3
    val overshootPercent = abs(progress) - 1.0f
    val linearTension = overshootPercent.coerceIn(0f, 2f)
    val tensionPercent = linearTension - linearTension.pow(2) / 4
    val endTrim = adjustedPercent * 0.8f
    val rotation = (-0.25f + 0.4f * adjustedPercent + tensionPercent) * 0.5f
    val startAngle = rotation * 360
    val endAngle = (rotation + endTrim) * 360
    val scale = min(1f, adjustedPercent)

    return MyArrowValues(rotation, startAngle, endAngle, scale)
}

class MyArrowValues(
    val rotation: Float,
    val startAngle: Float,
    val endAngle: Float,
    val scale: Float,
)

fun interface MyFloatProducer {
    operator fun invoke(): Float
}

fun DrawScope.myDrawCircularIndicator(
    color: Color,
    alpha: Float,
    values: MyArrowValues,
    arcBounds: Rect,
    strokeWidth: Dp,
) {
    drawArc(
        color = color,
        alpha = alpha,
        startAngle = values.startAngle,
        sweepAngle = values.endAngle - values.startAngle,
        useCenter = false,
        topLeft = arcBounds.topLeft,
        size = arcBounds.size,
        style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Butt),
    )
}

fun DrawScope.myDrawArrow(
    arrow: Path,
    bounds: Rect,
    color: Color,
    alpha: Float,
    values: MyArrowValues,
    strokeWidth: Dp,
) {
    arrow.reset()
    arrow.moveTo(0f, 0f)
    arrow.lineTo(x = 10.dp.toPx() * values.scale / 2, y = 5.dp.toPx() * values.scale)
    arrow.lineTo(x = 10.dp.toPx() * values.scale, y = 0f)

    val radius = min(bounds.width, bounds.height) / 2f
    val inset = 10.dp.toPx() * values.scale / 2f
    arrow.translate(
        Offset(x = radius + bounds.center.x - inset, y = bounds.center.y - strokeWidth.toPx())
    )
    rotate(degrees = values.endAngle - strokeWidth.toPx()) {
        drawPath(path = arrow, color = color, alpha = alpha, style = Stroke(strokeWidth.toPx()))
    }
}