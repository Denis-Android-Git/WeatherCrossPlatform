package org.example.weathercrossplatform.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Routes
import org.example.weathercrossplatform.domain.models.Routes.MainScreenRoute
import org.example.weathercrossplatform.presentation.search_weather.SearchScreenState
import org.example.weathercrossplatform.presentation.weather_list.MainScreenState

@Composable
fun NavHostMainScreen(
    isFirstLaunch: Boolean,
    myLogger: MyLogger = MyLoggerImpl
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreenRoute()) {
        composable<MainScreenRoute> {
            val args = it.toRoute<MainScreenRoute>()
            myLogger.debug("pageNumber_args: ${args.pageNumber}")
            MainScreenState(
                onAddButtonClick = { pageNumber ->
                    navController.navigate(Routes.SearchScreenRoute(pageNumber))
                },
                cityId = args.cityId,
                onCancelButtonClick = {
                    navController.navigateUp()
                },
                isFirstLaunch = isFirstLaunch,
                pageNumberFromSearchScreen = args.pageNumber
            )
        }
        composable<Routes.SearchScreenRoute> {
            SearchScreenState(
                onBackButtonClick = { pageNumber ->
                    navController.navigate(MainScreenRoute(pageNumber = pageNumber))
                },
                onFoundItemClick = { location ->
                    navController.navigate(MainScreenRoute(location.id))
                    myLogger.debug("location_id: ${location.id}")
                },
                onSavedItemClick = { pageNumber ->
                    myLogger.debug("page_number: $pageNumber")
                    navController.navigate(MainScreenRoute(pageNumber = pageNumber))
                }
            )
        }
    }
}
