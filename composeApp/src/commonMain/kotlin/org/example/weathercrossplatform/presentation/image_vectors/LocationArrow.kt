package org.example.weathercrossplatform.presentation.image_vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LocationArrow: ImageVector
    get() {
        if (_LocationArrow != null) {
            return _LocationArrow!!
        }
        _LocationArrow = ImageVector.Builder(
            name = "LocationArrow",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(518.07f, 860.76f)
                lineTo(398.74f, 556.39f)
                lineTo(94.37f, 437.83f)
                verticalLineToRelative(-58.26f)
                lineToRelative(771.26f, -289.83f)
                lineTo(576.57f, 860.76f)
                horizontalLineToRelative(-58.5f)
                close()
                moveTo(543.41f, 718.74f)
                lineTo(732.26f, 223.11f)
                lineTo(237.63f, 412.2f)
                lineToRelative(221.46f, 84.84f)
                lineToRelative(84.32f, 221.7f)
                close()
                moveTo(459.09f, 497.04f)
                close()
            }
        }.build()

        return _LocationArrow!!
    }

@Suppress("ObjectPropertyName")
private var _LocationArrow: ImageVector? = null
