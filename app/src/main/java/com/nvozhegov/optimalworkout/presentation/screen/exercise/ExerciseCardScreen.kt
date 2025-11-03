package com.nvozhegov.optimalworkout.presentation.screen.exercise

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.template.ExerciseButton
import com.nvozhegov.optimalworkout.presentation.navigation.BarScaffoldViewState

@Composable
fun ExerciseCardScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<BarScaffoldViewState>,
    groupId: Int,
    exerciseViewModel: ExerciseCardViewModel =
        hiltViewModel<ExerciseCardViewModel, ExerciseCardViewModel.ExerciseCardFactory> { factory ->
        factory.create(groupId)
    },
    actionBack: () -> Unit,
    action: (List<Exercise>) -> Unit
) {
    val exercisesState by exerciseViewModel.uiState.collectAsState()
    var selectedExercises by rememberSaveable{
        mutableStateOf(listOf<Exercise>())
    }


    LaunchedEffect(Unit) {
        scaffoldViewState.value = BarScaffoldViewState(
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
            },
            floatingButton = {
                if (selectedExercises.isNotEmpty()) {
                    FloatingActionButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = 16.dp)
                            .padding(horizontal = 16.dp),
                        onClick = {

                        },
                        shape = FloatingActionButtonDefaults.smallShape,
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.primary
                    ) {
                        Text(
                            text = if (selectedExercises.size == 1) {
                                stringResource(R.string.add) + " ${selectedExercises.size} " + stringResource(
                                    R.string.exercise_word_single)
                            } else if (selectedExercises.size < 5) {
                                stringResource(R.string.add) + " ${selectedExercises.size} " + stringResource(
                                    R.string.exercises_two_to_four
                                )
                            } else {
                                stringResource(R.string.add) + " ${selectedExercises.size} " + stringResource(
                                    R.string.exercises_over_five
                                )
                            }
                        )
                    }
                }
            }
        )
    }

    when (val currentExercisesState = exercisesState) {
        ExerciseCardState.Finishing -> {
            actionBack()
        }

        is ExerciseCardState.Selecting -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn() {
                    items(
                        items = currentExercisesState.exerciseList,
                        key = { exercise ->
                            exercise.id
                        }
                    ) { exercise ->
                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )
                        ExerciseButton(
                            exercise = exercise,
                            action = {
                                if(selectedExercises.contains(exercise)) {
                                    selectedExercises = selectedExercises.filter {
                                        it != exercise
                                    }
                                } else {
                                    selectedExercises = selectedExercises + exercise
                                }
                            }
                        )
                    }
                    item {
                        Spacer(
                            modifier = Modifier.height(80.dp)
                        )
                    }
                }
            }
        }
    }
}