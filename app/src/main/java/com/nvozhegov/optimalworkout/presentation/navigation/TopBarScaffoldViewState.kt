package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.runtime.Composable

data class TopBarScaffoldViewState(
    val title: @Composable () -> Unit = {},
    val navigationIcon: @Composable () -> Unit = {},
    val actionButton: @Composable () -> Unit = {}
)