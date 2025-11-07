package com.example.navigation_layout.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation_layout.form.FormScreen
import com.example.navigation_layout.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(
                onNavigateToForm = { navController.navigate("form") }
            )
        }
        composable("form") {
            FormScreen(
                onNavigateHome = { navController.popBackStack("welcome", inclusive = false) }, // Kembali ke "welcome"
                onNavigateToFormPendaftaran = { navController.navigate("form") } // Untuk saat ini, kembali ke form ini sendiri. Bisa diubah ke route lain jika ada form pendaftaran yang berbeda
            )
        }
    }
}