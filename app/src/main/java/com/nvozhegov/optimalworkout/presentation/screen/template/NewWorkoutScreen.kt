package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.navigation.ScaffoldViewState

@Composable
fun NewWorkoutScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<ScaffoldViewState>
) {
    LaunchedEffect(Unit) {
        scaffoldViewState.value = ScaffoldViewState(
            title = {
                Text(
                    text = "New Template",
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_arrow_back_24),
                        contentDescription = "back"
                    )
                }
            },
            actionButton = {

            }
        )
    }

    Text(
        text = "New Template Workout"
    )
}