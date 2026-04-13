package org.example.weathercrossplatform.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Orientation
import org.example.weathercrossplatform.domain.models.Routes
import org.example.weathercrossplatform.domain.models.Routes.MainScreenRoute
import org.example.weathercrossplatform.presentation.rain_map_screen.RainMapRoot
import org.example.weathercrossplatform.presentation.search_weather.SearchScreenState
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenRoot
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration
import org.example.weathercrossplatform.presentation.weather_list.MainScreenState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun NavHostMainScreen(
    isFirstLaunch: Boolean,
    modifier: Modifier,
    myLogger: MyLogger = MyLoggerImpl
) {

    val navHostViewModel = koinViewModel<NavHostViewModel>()
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(MainScreenRoute::class, MainScreenRoute.serializer())
                    subclass(Routes.SearchScreenRoute::class, Routes.SearchScreenRoute.serializer())
                    subclass(
                        Routes.SettingsScreenRoute::class,
                        Routes.SettingsScreenRoute.serializer()
                    )
                }
            }
        },
        MainScreenRoute()
    )
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        transitionSpec = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 500)
            ) { it } + fadeIn() togetherWith
                    slideOutHorizontally(
                        animationSpec = tween(durationMillis = 500)
                    ) { -it } + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 500)
            ) { -it } + fadeIn() togetherWith
                    slideOutHorizontally(
                        animationSpec = tween(durationMillis = 500)
                    ) { it } + fadeOut()
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                animationSpec = tween(durationMillis = 500)
            ) { -it } + fadeIn() togetherWith
                    slideOutHorizontally(
                        animationSpec = tween(durationMillis = 500)
                    ) { it } + fadeOut()
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {

            entry<MainScreenRoute> { mainScreen ->

                val configuration = currentDeviceConfiguration()
                val orientation = remember {
                    mutableStateOf(
                        if (configuration.isPortrait) Orientation.Portrait.value else Orientation.Landscape.value
                    )
                }

                MainScreenState(
                    onAddButtonClick = { pageNumber ->
                        backStack.add(Routes.SearchScreenRoute(pageNumber))
                        navHostViewModel.pageNumber = pageNumber
                    },
                    onCancelButtonClick = {
                        navHostViewModel.cityId = null
                        backStack.removeAll { it is MainScreenRoute }
                        backStack.add(MainScreenRoute(pageNumber = navHostViewModel.pageNumber))
                        backStack.add(Routes.SearchScreenRoute())
                    },
                    isFirstLaunch = isFirstLaunch,
                    onSettingsClick = {
                        backStack.add(Routes.SettingsScreenRoute)
                    },
                    modifier = modifier,
                    weatherViewModel = koinViewModel {
                        parametersOf(mainScreen.pageNumber, orientation.value)
                    },
                    orientation = orientation,
                    pageNumberFromSearchScreen = mainScreen.pageNumber,
                    cityIdFromSearchScreen = navHostViewModel.cityId,
                    onAddCityButtonClick = {
                        navHostViewModel.cityId = null
                    },
                    onGoToMapClick = {
                        myLogger.debug("check_coordinates coordinates to viewmodel = $it")
                        navHostViewModel.coordinates = it
                        backStack.add(Routes.MapScreenRoute)
                    },
                )
            }

            entry<Routes.SearchScreenRoute> {
                SearchScreenState(
                    onBackButtonClick = {
                        if (backStack.size > 1) { //NavDisplay backstack cannot be empty
                            backStack.removeAt(backStack.lastIndex)
                        }
                    },
                    onFoundItemClick = { location ->
                        navHostViewModel.cityId = location.id
                        backStack.removeAll { it is Routes.SearchScreenRoute }
                        backStack.removeAll { it is MainScreenRoute }
                        backStack.add(MainScreenRoute())
                    },
                    onSearchedItemClick = { cityId ->
                        navHostViewModel.cityId = cityId
                        backStack.removeAll { it is Routes.SearchScreenRoute }
                        backStack.removeAll { it is MainScreenRoute }
                        backStack.add(MainScreenRoute())
                    },
                    onSavedItemClick = { pageNumber ->
                        backStack.removeAll { it is Routes.SearchScreenRoute }
                        backStack.removeAt(0)
                        backStack.add(MainScreenRoute(pageNumber = pageNumber))
                    },
                    modifier = modifier,
                )
            }

            entry<Routes.SettingsScreenRoute> {
                SettingsScreenRoot(
                    onBackButtonClick = {
                        if (backStack.size > 1) { //NavDisplay backstack cannot be empty
                            backStack.removeAt(backStack.lastIndex)
                        }
                    },
                    modifier = modifier,
                )
            }
            entry<Routes.MapScreenRoute> {
                RainMapRoot(
                    viewModel = koinViewModel {
                        myLogger.debug("check_coordinates coordinates to RainMapRoot = ${navHostViewModel.coordinates}")
                        parametersOf(navHostViewModel.coordinates)
                    },
                    onBackButtonClick = {
                        if (backStack.size > 1) { //NavDisplay backstack cannot be empty
                            backStack.removeAt(backStack.lastIndex)
                        }
                    }
                )
            }
        }
    )
}
