package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.runtime.Composable

data class MainScaffoldViewState(
    val title: @Composable () -> Unit = {},
    val navigationIcon: @Composable () -> Unit = {},
    val actionButton: @Composable () -> Unit = {}
)