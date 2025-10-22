package com.nvozhegov.optimalworkout.presentation.screen.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.presentation.navigation.ScaffoldViewState

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<ScaffoldViewState>
) {
    LaunchedEffect(Unit) {
        scaffoldViewState.value = ScaffoldViewState(
            canBack = false,
            canRemove = false,
            navigationButton = {

            },
            actionsButton = {

            }
        )
    }

    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 16.dp)
    ) {
        Text("Calendar")
    }
}

