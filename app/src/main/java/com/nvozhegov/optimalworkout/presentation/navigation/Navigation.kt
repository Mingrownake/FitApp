package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Main
    ) {
        composable<AppScreen.Main> {
            MainNavScreen(
                navController = navController
            )
        }

        composable<AppScreen.Template> {
            TemplateNavScreen(
                navController = navController
            )
        }
    }
}


