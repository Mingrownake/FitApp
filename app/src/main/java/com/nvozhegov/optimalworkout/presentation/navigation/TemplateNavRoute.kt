package com.nvozhegov.optimalworkout.presentation.navigation

sealed class TemplateNavRoute(
    val title: String
) {
    data object Template: TemplateNavRoute("Template")
    data object NewTemplate: TemplateNavRoute("New template")
    data object Groups: TemplateNavRoute("Groups")
    data object Exercise: TemplateNavRoute("Exercise")
}