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
import weathercrossplatform.composeapp.generated.resources.im_14
import weathercrossplatform.composeapp.generated.resources.im_2
import weathercrossplatform.composeapp.generated.resources.im_3
import weathercrossplatform.composeapp.generated.resources.im_4
import weathercrossplatform.composeapp.generated.resources.im_5
import weathercrossplatform.composeapp.generated.resources.im_6
import weathercrossplatform.composeapp.generated.resources.im_7
import weathercrossplatform.composeapp.generated.resources.im_8
import weathercrossplatform.composeapp.generated.resources.im_9
import weathercrossplatform.composeapp.generated.resources.landscape_1
import weathercrossplatform.composeapp.generated.resources.landscape_10
import weathercrossplatform.composeapp.generated.resources.landscape_11
import weathercrossplatform.composeapp.generated.resources.landscape_12
import weathercrossplatform.composeapp.generated.resources.landscape_13
import weathercrossplatform.composeapp.generated.resources.landscape_14
import weathercrossplatform.composeapp.generated.resources.landscape_2
import weathercrossplatform.composeapp.generated.resources.landscape_3
import weathercrossplatform.composeapp.generated.resources.landscape_4
import weathercrossplatform.composeapp.generated.resources.landscape_5
import weathercrossplatform.composeapp.generated.resources.landscape_6
import weathercrossplatform.composeapp.generated.resources.landscape_7
import weathercrossplatform.composeapp.generated.resources.landscape_8
import weathercrossplatform.composeapp.generated.resources.landscape_9
import kotlin.time.Clock
import kotlin.time.Instant

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
        Res.drawable.im_13,
        Res.drawable.im_14
    ),
    val landscapePhotoList: List<DrawableResource> = listOf(
        Res.drawable.landscape_1,
        Res.drawable.landscape_2,
        Res.drawable.landscape_3,
        Res.drawable.landscape_4,
        Res.drawable.landscape_5,
        Res.drawable.landscape_6,
        Res.drawable.landscape_7,
        Res.drawable.landscape_8,
        Res.drawable.landscape_9,
        Res.drawable.landscape_10,
        Res.drawable.landscape_11,
        Res.drawable.landscape_12,
        Res.drawable.landscape_13,
        Res.drawable.landscape_14,
    ),
    val isTempC: Boolean = true,
    val isWindKph: Boolean = true,
    val isPressureMb: Boolean = true,
    val isLiquidGlassOn: Boolean = false,
    val initialTime: Instant = Clock.System.now(),
    val randomPicNumber: Int = (0..<appPhotoList.size).random(),
    val currentCoordinates: String? = null,
    val currentOrientation: String = Orientation.Portrait.value
)
