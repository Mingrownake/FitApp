package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.annotation.DrawableRes
import com.nvozhegov.optimalworkout.R

sealed class BottomBarScreen(
    val title: String,
    @DrawableRes val iconId: Int
) {
    data object Profile: BottomBarScreen("Profile", R.drawable.baseline_person_24)
    data object Templates: BottomBarScreen("Templates", R.drawable.round_list_alt_24)
    data object Exercises: BottomBarScreen("Exercises", R.drawable.outline_exercise_24)
    data object Calendar: BottomBarScreen("Calendar", R.drawable.round_calendar_month_24)
    data object Settings: BottomBarScreen("Settings", R.drawable.round_settings_24)
}