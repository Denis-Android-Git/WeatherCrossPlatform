package org.example.weathercrossplatform.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.weathercrossplatform.domain.models.Coordinates

class NavHostViewModel : ViewModel() {
    var pageNumber by mutableStateOf(0)
    var cityId by mutableStateOf<Int?>(null)
    var coordinates by mutableStateOf<Coordinates?>(null)
}