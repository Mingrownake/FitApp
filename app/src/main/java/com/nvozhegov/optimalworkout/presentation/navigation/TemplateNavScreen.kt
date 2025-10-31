package com.nvozhegov.optimalworkout.presentation.navigation

sealed class TemplateNavScreen(
    val title: String
) {
    data object NewTemplate: TemplateNavScreen("New template")
    data object Groups: TemplateNavScreen("Groups")
}