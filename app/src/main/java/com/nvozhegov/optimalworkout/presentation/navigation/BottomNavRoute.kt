package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.annotation.DrawableRes
import com.nvozhegov.optimalworkout.R

sealed class BottomNavRoute(
    val title: String,
    @DrawableRes val iconId: Int
) {
    data object Profile: BottomNavRoute("Profile", R.drawable.baseline_person_24)
    data object Templates: BottomNavRoute("Templates", R.drawable.round_list_alt_24)
    data object Workouts: BottomNavRoute("Workouts", R.drawable.outline_exercise_24)
    data object Calendar: BottomNavRoute("Calendar", R.drawable.round_calendar_month_24)
    data object Settings: BottomNavRoute("Settings", R.drawable.round_settings_24)
}