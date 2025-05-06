@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package weathercrossplatform.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val arrow_downward: DrawableResource by 
      lazy { init_arrow_downward() }

  public val clouds: DrawableResource by 
      lazy { init_clouds() }

  public val compose_multiplatform: DrawableResource by 
      lazy { init_compose_multiplatform() }

  public val feels_like_arrow: DrawableResource by 
      lazy { init_feels_like_arrow() }

  public val gauge: DrawableResource by 
      lazy { init_gauge() }

  public val meter: DrawableResource by 
      lazy { init_meter() }

  public val speedometer: DrawableResource by 
      lazy { init_speedometer() }

  public val water_drop: DrawableResource by 
      lazy { init_water_drop() }

  public val wind_arrow: DrawableResource by 
      lazy { init_wind_arrow() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("arrow_downward", CommonMainDrawable0.arrow_downward)
  map.put("clouds", CommonMainDrawable0.clouds)
  map.put("compose_multiplatform", CommonMainDrawable0.compose_multiplatform)
  map.put("feels_like_arrow", CommonMainDrawable0.feels_like_arrow)
  map.put("gauge", CommonMainDrawable0.gauge)
  map.put("meter", CommonMainDrawable0.meter)
  map.put("speedometer", CommonMainDrawable0.speedometer)
  map.put("water_drop", CommonMainDrawable0.water_drop)
  map.put("wind_arrow", CommonMainDrawable0.wind_arrow)
}

internal val Res.drawable.arrow_downward: DrawableResource
  get() = CommonMainDrawable0.arrow_downward

private fun init_arrow_downward(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:arrow_downward",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/arrow_downward.png", -1, -1),
    )
)

internal val Res.drawable.clouds: DrawableResource
  get() = CommonMainDrawable0.clouds

private fun init_clouds(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:clouds",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/clouds.png", -1, -1),
    )
)

internal val Res.drawable.compose_multiplatform: DrawableResource
  get() = CommonMainDrawable0.compose_multiplatform

private fun init_compose_multiplatform(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:compose_multiplatform",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/compose-multiplatform.xml", -1, -1),
    )
)

internal val Res.drawable.feels_like_arrow: DrawableResource
  get() = CommonMainDrawable0.feels_like_arrow

private fun init_feels_like_arrow(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:feels_like_arrow",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/feels_like_arrow.png", -1, -1),
    )
)

internal val Res.drawable.gauge: DrawableResource
  get() = CommonMainDrawable0.gauge

private fun init_gauge(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:gauge",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/gauge.png", -1, -1),
    )
)

internal val Res.drawable.meter: DrawableResource
  get() = CommonMainDrawable0.meter

private fun init_meter(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:meter",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/meter.png", -1, -1),
    )
)

internal val Res.drawable.speedometer: DrawableResource
  get() = CommonMainDrawable0.speedometer

private fun init_speedometer(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:speedometer",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/speedometer.png", -1, -1),
    )
)

internal val Res.drawable.water_drop: DrawableResource
  get() = CommonMainDrawable0.water_drop

private fun init_water_drop(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:water_drop",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/water_drop.png", -1, -1),
    )
)

internal val Res.drawable.wind_arrow: DrawableResource
  get() = CommonMainDrawable0.wind_arrow

private fun init_wind_arrow(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:wind_arrow",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "composeResources/weathercrossplatform.composeapp.generated.resources/drawable/wind_arrow.png", -1, -1),
    )
)
