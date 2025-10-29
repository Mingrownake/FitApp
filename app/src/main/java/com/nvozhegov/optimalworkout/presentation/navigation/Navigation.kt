package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nvozhegov.optimalworkout.presentation.bars.BottomBar
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.screen.calendar.CalendarScreen
import com.nvozhegov.optimalworkout.presentation.screen.exercise.ExercisesScreen
import com.nvozhegov.optimalworkout.presentation.screen.profile.ProfileScreen
import com.nvozhegov.optimalworkout.presentation.screen.settings.SettingsScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate.NewTemplateScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.TemplatesScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Main
    ) {
        composable<AppScreen.Main> {
            MainBottomBar(navController = navController)
        }

        composable<AppScreen.NewTemplate> {
            NewTemplateScreen(
                navController = navController
            )
        }
    }
}


@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val bottomBarNavController = rememberNavController()
    val backStackEntry by bottomBarNavController.currentBackStackEntryAsState()
    val currentTitleScreen= backStackEntry?.destination?.route ?: BottomBarScreen.Exercises.title

    val scaffoldState = remember {
        mutableStateOf(MainScaffoldViewState())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                selectedScreenTitle = currentTitleScreen,
                navController = bottomBarNavController,
                onClick = {
                    val navigateToScreen = when(it) {
                        BottomBarScreen.Profile.title -> BottomBarScreen.Profile.title
                        BottomBarScreen.Templates.title -> BottomBarScreen.Templates.title
                        BottomBarScreen.Calendar.title -> BottomBarScreen.Calendar.title
                        BottomBarScreen.Settings.title -> BottomBarScreen.Settings.title
                        else ->  BottomBarScreen.Exercises.title
                    }
                    if (currentTitleScreen != navigateToScreen) {
                        bottomBarNavController.navigate(navigateToScreen) {
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                }
            )
        },
        topBar = {
            TopBar(
                title = scaffoldState.value.title,
                navigationIcon = scaffoldState.value.navigationIcon,
                actionButton = scaffoldState.value.actionButton
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomBarNavController,
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background),
            startDestination = BottomBarScreen.Exercises.title
        ) {
            composable(
                route = BottomBarScreen.Profile.title
            ) {
                ProfileScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomBarScreen.Templates.title
            ) {
                TemplatesScreen(
                    scaffoldViewState = scaffoldState,
                    navController = navController
                )
            }

            composable(
                route = BottomBarScreen.Exercises.title
            ) {
                ExercisesScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomBarScreen.Calendar.title
            ) {
                CalendarScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomBarScreen.Settings.title
            ) {
                SettingsScreen(
                    scaffoldViewState = scaffoldState
                )
            }
        }
    }
}