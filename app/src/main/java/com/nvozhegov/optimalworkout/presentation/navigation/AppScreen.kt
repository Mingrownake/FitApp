package com.nvozhegov.optimalworkout.presentation.navigation

import kotlinx.serialization.Serializable


sealed interface AppScreen {
    @Serializable
    data object Main: AppScreen
    @Serializable
    data object NewTemplate: AppScreen
}