package org.example.weathercrossplatform.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.weathercrossplatform.domain.models.Destinations

@Composable
fun NavHostMainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.MAIN_SCREEN.route) {
        composable(route = Destinations.MAIN_SCREEN.route) {
            MainScreenState(
                onAddButtonClick = {
                    navController.navigate(Destinations.SEARCH_SCREEN.route)
                }
            )
        }
        composable(route = Destinations.SEARCH_SCREEN.route) {
            SearchScreenState(
                onBackButtonClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}
