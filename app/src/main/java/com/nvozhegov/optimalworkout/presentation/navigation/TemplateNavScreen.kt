package com.nvozhegov.optimalworkout.presentation.navigation

sealed class TemplateNavScreen(
    val title: String
) {
    data object Template: TemplateNavScreen("Template")
    data object NewTemplate: TemplateNavScreen("New template")
    data object Groups: TemplateNavScreen("Groups")
    data object Exercise: TemplateNavScreen("Exercise")
}