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
import androidx.navigation.navigation
import com.nvozhegov.optimalworkout.presentation.bars.BottomBar
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.screen.calendar.CalendarScreen
import com.nvozhegov.optimalworkout.presentation.screen.exercise.ExercisesScreen
import com.nvozhegov.optimalworkout.presentation.screen.group.GroupScreen
import com.nvozhegov.optimalworkout.presentation.screen.profile.ProfileScreen
import com.nvozhegov.optimalworkout.presentation.screen.settings.SettingsScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate.NewTemplateScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.TemplatesScreen
import com.nvozhegov.optimalworkout.presentation.screen.workout.WorkoutsScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Main
    ) {
        composable<AppScreen.Main> {
            MainScreen(
                navController = navController
            )
        }

        composable<AppScreen.Template> {
            TemplateScreen(
                navController = navController
            )
        }
    }
}


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val bottomBarNavController = rememberNavController()
    val backStackEntry by bottomBarNavController.currentBackStackEntryAsState()
    val currentTitleScreen= backStackEntry?.destination?.route ?: BottomNavScreen.Workouts.title

    val scaffoldState = remember {
        mutableStateOf(TopBarScaffoldViewState())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                selectedScreenTitle = currentTitleScreen,
                navController = bottomBarNavController,
                onClick = {
                    val navigateToScreen = when(it) {
                        BottomNavScreen.Profile.title -> BottomNavScreen.Profile.title
                        BottomNavScreen.Templates.title -> BottomNavScreen.Templates.title
                        BottomNavScreen.Calendar.title -> BottomNavScreen.Calendar.title
                        BottomNavScreen.Settings.title -> BottomNavScreen.Settings.title
                        else ->  BottomNavScreen.Workouts.title
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
            startDestination = BottomNavScreen.Workouts.title
        ) {
            composable(
                route = BottomNavScreen.Profile.title
            ) {
                ProfileScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavScreen.Templates.title
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
                route = BottomNavScreen.Workouts.title
            ) {
                WorkoutsScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavScreen.Calendar.title
            ) {
                CalendarScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(
                route = BottomNavScreen.Settings.title
            ) {
                SettingsScreen(
                    scaffoldViewState = scaffoldState
                )
            }
        }
    }
}

@Composable
fun TemplateScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val templateNavController = rememberNavController()
    val scaffoldState = remember {
        mutableStateOf(TopBarScaffoldViewState())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = scaffoldState.value.title,
                navigationIcon = scaffoldState.value.navigationIcon,
                actionButton = scaffoldState.value.actionButton
            )
        }
    ) {innerPadding ->
        NavHost(
            navController = templateNavController,
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background),
            startDestination = TemplateNavScreen.Template.title,
            enterTransition = {
                slideInHorizontally {
                    it
                }
            },
            exitTransition = {
                slideOutHorizontally {
                    it
                }
            }
        ) {
            navigation(
                route = TemplateNavScreen.Template.title,
                startDestination = TemplateNavScreen.NewTemplate.title
            ) {
                composable(
                    route = TemplateNavScreen.NewTemplate.title
                ) {
                    NewTemplateScreen(
                        scaffoldViewState = scaffoldState,
                        actionBack = {
                            navController.navigateUp()
                        },
                        navigateTo = {
                            templateNavController.navigate(TemplateNavScreen.Groups.title) {
                                launchSingleTop = true
                            }
                        }
                    )
                }

                composable(
                    route = TemplateNavScreen.Groups.title
                ) {
                    GroupScreen(
                        scaffoldViewState = scaffoldState,
                        actionBack = { templateNavController.popBackStack() },
                        navigateTo = {
                            templateNavController.navigate(
                                TemplateNavScreen.Exercise.title
                            ) {
                                launchSingleTop = true
                            }
                        }
                    )
                }

                composable(
                    route = TemplateNavScreen.Exercise.title
                ) {
                    ExercisesScreen(
                        scaffoldViewState = scaffoldState,
                        actionBack = {
                            templateNavController.popBackStack()
                        },
                        navigateTo = {

                        }
                    )
                }
            }
        }
    }
}