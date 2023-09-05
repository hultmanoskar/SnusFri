package com.ogge.snusfri.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ogge.snusfri.screens.InputScreen2
import com.ogge.snusfri.screens.StartDateInput
import com.ogge.snusfri.screens.WelcomeScreen

object NavigationScreens {
    const val WelcomeScreen = "welcomescreen"
    const val StarDateInput = "startdateinput"
    const val InputScreen2 = "inputscreen2"

}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.WelcomeScreen){
        composable(route = NavigationScreens.WelcomeScreen){
            WelcomeScreen(navController = navController)
        }
        composable(route = "${NavigationScreens.StarDateInput}/{snusUsage}/{pricePerDosa}", arguments = listOf(
            navArgument("snusUsage"){ type = NavType.FloatType },
            navArgument("pricePerDosa"){ type = NavType.FloatType}
        )){ navBackStackEntry ->
            val snusUsage =
                navBackStackEntry.arguments?.getFloat("snusUsage") ?: 0f
            val pricePerDosa =
                navBackStackEntry.arguments?.getFloat("pricePerDosa") ?: 0f
            StartDateInput(navController = navController, snusUsage, pricePerDosa)
        }
        composable(route = NavigationScreens.InputScreen2){
            InputScreen2(navController = navController)
        }
    }
}