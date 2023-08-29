package com.ogge.snusfri.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ogge.snusfri.screens.InputScreen
import com.ogge.snusfri.screens.InputScreen2
import com.ogge.snusfri.screens.WelcomeScreen

object NavigationScreens {
    const val WelcomeScreen = "welcomescreen"
    const val InputScreen = "inputscreen"
    const val InputScreen2 = "inputscreen2"

}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.WelcomeScreen){
        composable(route = NavigationScreens.WelcomeScreen){
            WelcomeScreen(navController = navController)
        }
        composable(route = NavigationScreens.InputScreen){
            InputScreen(navController = navController)
        }
        composable(route = NavigationScreens.InputScreen2){
            InputScreen2(navController = navController)
        }
    }
}