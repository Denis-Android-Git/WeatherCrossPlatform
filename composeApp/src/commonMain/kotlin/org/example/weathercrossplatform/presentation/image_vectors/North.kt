package org.example.weathercrossplatform.presentation.image_vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val North: ImageVector
    get() {
        if (_North != null) {
            return _North!!
        }
        _North = ImageVector.Builder(
            name = "North",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(440f, 880f)
                verticalLineToRelative(-647f)
                lineTo(256f, 416f)
                lineToRelative(-56f, -56f)
                lineToRelative(280f, -280f)
                lineToRelative(280f, 280f)
                lineToRelative(-56f, 57f)
                lineToRelative(-184f, -184f)
                verticalLineToRelative(647f)
                horizontalLineToRelative(-80f)
                close()
            }
        }.build()

        return _North!!
    }

@Suppress("ObjectPropertyName")
private var _North: ImageVector? = null
