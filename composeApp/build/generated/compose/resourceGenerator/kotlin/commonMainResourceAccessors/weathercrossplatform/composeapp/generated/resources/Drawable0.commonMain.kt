@file:OptIn(InternalResourceApi::class)

package weathercrossplatform.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String =
    "composeResources/weathercrossplatform.composeapp.generated.resources/"

internal val Res.drawable.arrow_downward: DrawableResource by lazy {
      DrawableResource("drawable:arrow_downward", setOf(
        ResourceItem(setOf(), "${MD}drawable/arrow_downward.png", -1, -1),
      ))
    }

internal val Res.drawable.clouds: DrawableResource by lazy {
      DrawableResource("drawable:clouds", setOf(
        ResourceItem(setOf(), "${MD}drawable/clouds.png", -1, -1),
      ))
    }

internal val Res.drawable.compose_multiplatform: DrawableResource by lazy {
      DrawableResource("drawable:compose_multiplatform", setOf(
        ResourceItem(setOf(), "${MD}drawable/compose-multiplatform.xml", -1, -1),
      ))
    }

internal val Res.drawable.feels_like_arrow: DrawableResource by lazy {
      DrawableResource("drawable:feels_like_arrow", setOf(
        ResourceItem(setOf(), "${MD}drawable/feels_like_arrow.png", -1, -1),
      ))
    }

internal val Res.drawable.gauge: DrawableResource by lazy {
      DrawableResource("drawable:gauge", setOf(
        ResourceItem(setOf(), "${MD}drawable/gauge.png", -1, -1),
      ))
    }

internal val Res.drawable.meter: DrawableResource by lazy {
      DrawableResource("drawable:meter", setOf(
        ResourceItem(setOf(), "${MD}drawable/meter.png", -1, -1),
      ))
    }

internal val Res.drawable.speedometer: DrawableResource by lazy {
      DrawableResource("drawable:speedometer", setOf(
        ResourceItem(setOf(), "${MD}drawable/speedometer.png", -1, -1),
      ))
    }

internal val Res.drawable.water_drop: DrawableResource by lazy {
      DrawableResource("drawable:water_drop", setOf(
        ResourceItem(setOf(), "${MD}drawable/water_drop.png", -1, -1),
      ))
    }

internal val Res.drawable.wind_arrow: DrawableResource by lazy {
      DrawableResource("drawable:wind_arrow", setOf(
        ResourceItem(setOf(), "${MD}drawable/wind_arrow.png", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("arrow_downward", Res.drawable.arrow_downward)
  map.put("clouds", Res.drawable.clouds)
  map.put("compose_multiplatform", Res.drawable.compose_multiplatform)
  map.put("feels_like_arrow", Res.drawable.feels_like_arrow)
  map.put("gauge", Res.drawable.gauge)
  map.put("meter", Res.drawable.meter)
  map.put("speedometer", Res.drawable.speedometer)
  map.put("water_drop", Res.drawable.water_drop)
  map.put("wind_arrow", Res.drawable.wind_arrow)
}
