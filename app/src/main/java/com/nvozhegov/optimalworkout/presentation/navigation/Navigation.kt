package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Main.title
    ) {
        composable(route = AppScreen.Main.title) {
            MainNavScreen(
                navController = navController
            )
        }

        composable(
            route = "${AppScreen.Template.title}?target={target}",
            arguments = listOf(navArgument("target") {
                type = NavType.StringType
                defaultValue = TemplateNavRoute.NewTemplate.title
            })
        ) {backStackEntry ->
            val target = backStackEntry.arguments?.getString("target")
            TemplateNavScreen(
                navController =  navController,
                startDestination = target
            )
        }
    }
}


