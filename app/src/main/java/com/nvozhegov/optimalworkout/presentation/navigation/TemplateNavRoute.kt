package com.nvozhegov.optimalworkout.presentation.navigation

sealed class TemplateNavRoute(
    val title: String
) {
    data object Template: TemplateNavRoute("template")
    data object NewTemplate: TemplateNavRoute("new_template")
    data object EditTemplate: TemplateNavRoute("edit_template")
    data object Groups: TemplateNavRoute("groups")
    data object Exercise: TemplateNavRoute("exercise")
}