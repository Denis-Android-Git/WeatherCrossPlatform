package org.example.weathercrossplatform.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NavHostViewModel : ViewModel() {
    var pageNumber by mutableStateOf(0)
}