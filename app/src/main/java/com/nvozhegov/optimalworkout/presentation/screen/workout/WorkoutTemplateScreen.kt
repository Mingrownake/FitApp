package com.nvozhegov.optimalworkout.presentation.screen.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.BaseOutlinedTextField
import com.nvozhegov.optimalworkout.presentation.navigation.BarScaffoldViewState


@Composable
fun WorkoutTemplateScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<BarScaffoldViewState>,
    viewModel: WorkoutTemplateViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        scaffoldViewState.value = BarScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.workout_template)
                )
            },
            navigationIcon = {

            },
            actionButton = {

            }
        )
    }

    Column() {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                text = stringResource(R.string.templateName)
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            BaseOutlinedTextField(
                value = uiState.templateName,
                onValueChange = {newValue ->
                    viewModel.editName(newValue)
                },
                placeholder = R.string.enterTemplateName
            )
        }
    }