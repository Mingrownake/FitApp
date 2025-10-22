package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.bars.BottomBar
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.screen.calendar.CalendarScreen
import com.nvozhegov.optimalworkout.presentation.screen.exercise.ExercisesScreen
import com.nvozhegov.optimalworkout.presentation.screen.profile.ProfileScreen
import com.nvozhegov.optimalworkout.presentation.screen.settings.SettingsScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.TemplatesScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Exercises.name
    )

    val scaffoldState = remember {
        mutableStateOf(ScaffoldViewState())
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canBack = scaffoldState.value.canBack,
                canRemove = scaffoldState.value.canRemove,
                onDelete = { scaffoldState.value.actionsButton },
                onBack = { scaffoldState.value.navigationButton }
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                currentScreen = currentScreen
            )
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Exercises.name,
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background),
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 500)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 500)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            composable(route = AppScreen.Profile.name) {
                ProfileScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Templates.name) {
                TemplatesScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Exercises.name) {
                ExercisesScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Calendar.name) {
                CalendarScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Settings.name) {
                SettingsScreen(
                    scaffoldViewState = scaffoldState
                )
            }
        }
    }


}

enum class AppScreen(
    val title: String,
    @DrawableRes val iconId: Int
) {
    Profile("Profile", R.drawable.baseline_person_24 ),
    Templates("Templates", R.drawable.round_list_alt_24),
    Exercises("Exercises", R.drawable.outline_exercise_24),
    Calendar("Calendar", R.drawable.round_calendar_month_24),
    Settings("Settings", R.drawable.round_settings_24)
}

data class ScaffoldViewState(
    val canBack: Boolean = false,
    val canRemove: Boolean = false,
    val navigationButton: @Composable () -> Unit = {},
    val actionsButton: @Composable () -> Unit = {}
)

