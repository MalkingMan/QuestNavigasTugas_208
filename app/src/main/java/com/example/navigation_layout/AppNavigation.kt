package com.example.navigation_layout

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(onNavigateToForm = { navController.navigate("form") })
        }
        composable("form") {
            FormScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}