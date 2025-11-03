package com.nvozhegov.optimalworkout.presentation.navigation

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nvozhegov.optimalworkout.presentation.bars.BottomBar
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.screen.calendar.CalendarScreen
import com.nvozhegov.optimalworkout.presentation.screen.profile.ProfileScreen
import com.nvozhegov.optimalworkout.presentation.screen.settings.SettingsScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.TemplatesScreen
import com.nvozhegov.optimalworkout.presentation.screen.workout.WorkoutsScreen

@Composable
fun MainNavScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val bottomBarNavController = rememberNavController()
    val backStackEntry by bottomBarNavController.currentBackStackEntryAsState()
    val currentTitleScreen= backStackEntry?.destination?.route ?: BottomNavRoute.Workouts.title

    val scaffoldState = remember {
        mutableStateOf(BarScaffoldViewState())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                selectedScreenTitle = currentTitleScreen,
                navController = bottomBarNavController,
                onClick = {
                    val navigateToScreen = when(it) {
                        BottomNavRoute.Profile.title -> BottomNavRoute.Profile.title
                        BottomNavRoute.Templates.title -> BottomNavRoute.Templates.title
                        BottomNavRoute.Calendar.title -> BottomNavRoute.Calendar.title
                        BottomNavRoute.Settings.title -> BottomNavRoute.Settings.title
                        else ->  BottomNavRoute.Workouts.title
                    }
                    if (currentTitleScreen != navigateToScreen) {
                        bottomBarNavController.navigate(navigateToScreen) {
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
            startDestination = BottomNavRoute.Workouts.title
        ) {
            composable(
                route = BottomNavRoute.Profile.title
            ) {
                ProfileScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavRoute.Templates.title
            ) {
                TemplatesScreen(
                    scaffoldViewState = scaffoldState,
                    navigateTo = {
                        navController.navigate(AppScreen.Template) {
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(
                route = BottomNavRoute.Workouts.title
            ) {
                WorkoutsScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavRoute.Calendar.title
            ) {
                CalendarScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavRoute.Settings.title
            ) {
                SettingsScreen(
                    scaffoldViewState = scaffoldState
                )
            }
        }
    }
}