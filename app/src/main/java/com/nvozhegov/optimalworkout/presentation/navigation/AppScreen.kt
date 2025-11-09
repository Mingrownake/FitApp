package com.nvozhegov.optimalworkout.presentation.navigation

import kotlinx.serialization.Serializable


sealed class AppScreen(val title: String) {
    data object Main: AppScreen("main")
    data object Template: AppScreen("template")
}