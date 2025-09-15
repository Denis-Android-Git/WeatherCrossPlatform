package org.example.weathercrossplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import org.example.weathercrossplatform.presentation.InfiniteNumberPicker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
//            InfiniteNumberPicker(
//                range = 1..24,
//                itemHeight = 50.dp,
//                visibleItems = 5,
//
//            )
        }
    }
}