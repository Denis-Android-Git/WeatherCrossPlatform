package org.example.weathercrossplatform.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.weathercrossplatform.domain.models.Routes
import org.example.weathercrossplatform.domain.models.Routes.MainScreenRoute

@Composable
fun NavHostMainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreenRoute()) {
        composable<MainScreenRoute> {
            val args = it.toRoute<MainScreenRoute>()

            MainScreenState(
                onAddButtonClick = {
                    navController.navigate(Routes.SearchScreenRoute)
                },
                cityId = args.cityId,
                onCancelButtonClick = {
                    navController.navigateUp()
                },
            )
        }
        composable<Routes.SearchScreenRoute> {
            SearchScreenState(
                onBackButtonClick = {
                    navController.navigateUp()
                },
                onFoundItemClick = {
                    navController.navigate(MainScreenRoute(it.id))
                    println("location_id: ${it.id}")
                }
            )
        }
    }
}
