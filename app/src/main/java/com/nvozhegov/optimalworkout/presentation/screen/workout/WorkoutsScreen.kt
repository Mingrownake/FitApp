package com.nvozhegov.optimalworkout.presentation.screen.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.navigation.BarScaffoldViewState

@Composable
fun WorkoutsScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<BarScaffoldViewState>
) {
    LaunchedEffect(Unit) {
        scaffoldViewState.value = BarScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.workouts)
                )
            }
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text("Workouts")
    }
}