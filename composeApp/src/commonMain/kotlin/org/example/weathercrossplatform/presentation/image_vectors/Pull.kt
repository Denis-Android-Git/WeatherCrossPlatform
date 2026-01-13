package org.example.weathercrossplatform.presentation.image_vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Pull: ImageVector
    get() {
        if (_Pull != null) {
            return _Pull!!
        }
        _Pull = ImageVector.Builder(
            name = "Pull",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(480f, 920.85f)
                lineTo(227.13f, 667.98f)
                lineToRelative(55.11f, -55.11f)
                lineToRelative(197.76f, 199f)
                lineToRelative(198.76f, -199f)
                lineToRelative(54.11f, 55.11f)
                lineTo(480f, 920.85f)
                close()
                moveTo(480f, 642.11f)
                lineTo(227.13f, 389.24f)
                lineToRelative(55.11f, -54.87f)
                lineToRelative(197.76f, 199f)
                lineToRelative(198.76f, -199f)
                lineToRelative(54.11f, 54.87f)
                lineTo(480f, 642.11f)
                close()
                moveTo(480f, 363.61f)
                lineTo(227.13f, 110.74f)
                lineToRelative(55.11f, -54.87f)
                lineToRelative(197.76f, 199f)
                lineToRelative(198.76f, -199f)
                lineToRelative(54.11f, 54.87f)
                lineTo(480f, 363.61f)
                close()
            }
        }.build()

        return _Pull!!
    }

@Suppress("ObjectPropertyName")
private var _Pull: ImageVector? = null
