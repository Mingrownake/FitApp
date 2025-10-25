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
import com.nvozhegov.optimalworkout.presentation.screen.template.NewWorkoutScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.TemplatesScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentTitleScreen = backStackEntry?.destination?.route ?: AppScreen.Exercises.title

    val scaffoldState = remember {
        mutableStateOf(ScaffoldViewState())
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = scaffoldState.value.title,
                navigationIcon = scaffoldState.value.navigationIcon,
                actionButton = scaffoldState.value.actionButton
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                currentScreenTitle = currentTitleScreen
            )
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Templates.title,
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
            composable(route = AppScreen.Profile.title) {
                ProfileScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Templates.title) {
                TemplatesScreen(
                    scaffoldViewState = scaffoldState,
                    navController = navController
                )
            }

            composable(route = AppScreen.NewTemplate.title) {
                NewWorkoutScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Exercises.title) {
                ExercisesScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Calendar.title) {
                CalendarScreen(
                    scaffoldViewState = scaffoldState
                )
            }

            composable(route = AppScreen.Settings.title) {
                SettingsScreen(
                    scaffoldViewState = scaffoldState
                )
            }
        }
    }


}
sealed class AppScreen(
    val title: String,
    @DrawableRes val iconId: Int = R.drawable.round_add_circle_outline_24
) {
    data object Profile: AppScreen("Profile", R.drawable.baseline_person_24)
    data object Templates: AppScreen("Templates", R.drawable.round_list_alt_24)
    data object Exercises: AppScreen("Exercises", R.drawable.outline_exercise_24)
    data object Calendar: AppScreen("Calendar", R.drawable.round_calendar_month_24)
    data object Settings: AppScreen("Settings", R.drawable.round_settings_24)
    data object NewTemplate: AppScreen("NEW TEMPLATE")
}

data class ScaffoldViewState(
    val title: @Composable () -> Unit = {},
    val navigationIcon: @Composable () -> Unit = {},
    val actionButton: @Composable () -> Unit = {}
)

