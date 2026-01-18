package org.example.weathercrossplatform.domain.models

import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.utils.UiText
import org.jetbrains.compose.resources.DrawableResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.im_1
import weathercrossplatform.composeapp.generated.resources.im_10
import weathercrossplatform.composeapp.generated.resources.im_11
import weathercrossplatform.composeapp.generated.resources.im_12
import weathercrossplatform.composeapp.generated.resources.im_13
import weathercrossplatform.composeapp.generated.resources.im_2
import weathercrossplatform.composeapp.generated.resources.im_3
import weathercrossplatform.composeapp.generated.resources.im_4
import weathercrossplatform.composeapp.generated.resources.im_5
import weathercrossplatform.composeapp.generated.resources.im_6
import weathercrossplatform.composeapp.generated.resources.im_7
import weathercrossplatform.composeapp.generated.resources.im_8
import weathercrossplatform.composeapp.generated.resources.im_9

data class WeatherMainScreenState(
    val isLoading: Boolean = false,
    val weatherDto: ForecastDto? = null,
    val error: UiText? = null,
    val image: String = "",
    val weatherItemList: List<WeatherItem> = emptyList(),
    val cityId: Int? = null,
    val isAddCity: Boolean = false,
    val savedCities: List<SavedWeatherItem> = emptyList(),
    val pageNumberFromSearchScreen: Int? = null,
    val pageNumber: Int = 0,
    val appPhotoList: List<DrawableResource> = listOf(
        Res.drawable.im_1,
        Res.drawable.im_2,
        Res.drawable.im_3,
        Res.drawable.im_4,
        Res.drawable.im_5,
        Res.drawable.im_6,
        Res.drawable.im_7,
        Res.drawable.im_8,
        Res.drawable.im_9,
        Res.drawable.im_10,
        Res.drawable.im_11,
        Res.drawable.im_12,
        Res.drawable.im_13
    ),
    val isTempC: Boolean = true,
    val isWindKph: Boolean = true,
    val isPressureMb: Boolean = true,
    val isLiquidGlassOn: Boolean = false
)
