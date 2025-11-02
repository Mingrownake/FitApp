package com.nvozhegov.optimalworkout.presentation.screen.exercise

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.template.ExerciseButton
import com.nvozhegov.optimalworkout.presentation.navigation.TopBarScaffoldViewState
import com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate.NewTemplateViewModel

@Composable
fun ExercisesScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<TopBarScaffoldViewState>,
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    actionBack: () -> Unit,
    action: (Exercise) -> Unit
) {
    val exercisesState by exerciseViewModel.uiState.collectAsState()
    val exerciseList by exercisesState.exerciseList.collectAsState(listOf())

    LaunchedEffect(Unit) {
        scaffoldViewState.value = TopBarScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.choose_exercise)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = actionBack
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_arrow_back_24),
                        contentDescription = "back"
                    )
                }
            }
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(
            items = exerciseList,
            key = {exercise ->
                exercise.id
            }
        ) {exercise ->
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            ExerciseButton(
                exerciseTitle = exercise.name,
                onClick = {
                    action(exercise)
                }
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}