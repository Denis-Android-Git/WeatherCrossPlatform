package org.example.weathercrossplatform.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.weathercrossplatform.domain.models.Routes
import org.example.weathercrossplatform.domain.models.Routes.MainScreenRoute

@Composable
fun NavHostMainScreen(
    isFirstLaunch: Boolean
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreenRoute()) {
        composable<MainScreenRoute> {
            val args = it.toRoute<MainScreenRoute>()
            println("pageNumber_args: ${args.pageNumber}")
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
        composable<Routes.SearchScreenRoute> { it ->
            val args = it.toRoute<Routes.SearchScreenRoute>()
            SearchScreenState(
                onBackButtonClick = { pageNumber ->
                    navController.navigate(MainScreenRoute(pageNumber = pageNumber))
                },
                onFoundItemClick = { location ->
                    navController.navigate(MainScreenRoute(location.id))
                    println("location_id: ${location.id}")
                },
                pageNumber = args.pageNumber,
                onSavedItemClick = { pageNumber ->
                    println("page_number: $pageNumber")
                    navController.navigate(MainScreenRoute(pageNumber = pageNumber))
                }
            )
        }
    }
}
