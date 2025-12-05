package org.example.weathercrossplatform.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Routes
import org.example.weathercrossplatform.domain.models.Routes.MainScreenRoute
import org.example.weathercrossplatform.presentation.search_weather.SearchScreenState
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenRoot
import org.example.weathercrossplatform.presentation.weather_list.MainScreenState

@Composable
fun NavHostMainScreen(
    isFirstLaunch: Boolean,
    modifier: Modifier,
    myLogger: MyLogger = MyLoggerImpl
) {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(MainScreenRoute::class, MainScreenRoute.serializer())
                    subclass(Routes.SearchScreenRoute::class, Routes.SearchScreenRoute.serializer())
                    subclass(Routes.SettingsScreenRoute::class, Routes.SettingsScreenRoute.serializer())
                }
            }
        },
        MainScreenRoute()
    )
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is MainScreenRoute -> {
                    NavEntry(key) {
                        MainScreenState(
                            onAddButtonClick = { pageNumber ->
                                backStack.add(Routes.SearchScreenRoute(pageNumber))
                            },
                            onCancelButtonClick = {
                                backStack.remove(MainScreenRoute())
                            },
                            isFirstLaunch = isFirstLaunch,
                            onSettingsClick = {
                                backStack.add(Routes.SettingsScreenRoute)
                            },
                            modifier = modifier,
                        )
                    }
                }

                is Routes.SearchScreenRoute -> {
                    NavEntry(key) {
                        SearchScreenState(
                            onBackButtonClick = { pageNumber ->
                                backStack.add(MainScreenRoute(pageNumber = pageNumber))
                            },
                            onFoundItemClick = { location ->
                                backStack.add(MainScreenRoute(location.id))
                                myLogger.debug("location_id: ${location.id}")
                            },
                            onSavedItemClick = { pageNumber ->
                                myLogger.debug("page_number: $pageNumber")
                                backStack.add(MainScreenRoute(pageNumber = pageNumber))
                            },
                            modifier = modifier,
                        )
                    }
                }

                is Routes.SettingsScreenRoute -> {
                    NavEntry(key) {
                        SettingsScreenRoot(
                            onBackButtonClick = {
                                backStack.add(MainScreenRoute())
                            },
                            modifier = modifier,
                        )
                    }
                }

                else -> error("Unknown NavKey: $key")
            }
        }
    )
}
