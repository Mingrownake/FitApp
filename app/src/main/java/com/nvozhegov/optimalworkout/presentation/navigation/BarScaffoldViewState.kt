package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.runtime.Composable

data class BarScaffoldViewState(
    val title: @Composable () -> Unit = {},
    val navigationIcon: @Composable () -> Unit = {},
    val actionButton: @Composable () -> Unit = {},
    val floatingButton: @Composable () -> Unit = {}
)