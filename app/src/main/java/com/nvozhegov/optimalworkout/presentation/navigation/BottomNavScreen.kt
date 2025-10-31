package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.annotation.DrawableRes
import com.nvozhegov.optimalworkout.R

sealed class BottomNavScreen(
    val title: String,
    @DrawableRes val iconId: Int
) {
    data object Profile: BottomNavScreen("Profile", R.drawable.baseline_person_24)
    data object Templates: BottomNavScreen("Templates", R.drawable.round_list_alt_24)
    data object Exercises: BottomNavScreen("Exercises", R.drawable.outline_exercise_24)
    data object Calendar: BottomNavScreen("Calendar", R.drawable.round_calendar_month_24)
    data object Settings: BottomNavScreen("Settings", R.drawable.round_settings_24)
}