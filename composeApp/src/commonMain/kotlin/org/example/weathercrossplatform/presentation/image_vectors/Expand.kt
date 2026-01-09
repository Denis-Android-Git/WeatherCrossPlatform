package org.example.weathercrossplatform.presentation.image_vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Expand: ImageVector
    get() {
        if (_Expand != null) {
            return _Expand!!
        }
        _Expand = ImageVector.Builder(
            name = "Expand",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(480f, 894.15f)
                lineTo(226.61f, 640.76f)
                lineToRelative(55.87f, -56.87f)
                lineTo(480f, 782.17f)
                lineToRelative(198.52f, -198.28f)
                lineToRelative(54.87f, 56.87f)
                lineTo(480f, 894.15f)
                close()
                moveTo(281.72f, 375.35f)
                lineTo(226.61f, 318.48f)
                lineTo(480f, 65.09f)
                lineToRelative(253.39f, 253.39f)
                lineToRelative(-54.87f, 56.87f)
                lineTo(480f, 177.07f)
                lineTo(281.72f, 375.35f)
                close()
            }
        }.build()

        return _Expand!!
    }

@Suppress("ObjectPropertyName")
private var _Expand: ImageVector? = null
