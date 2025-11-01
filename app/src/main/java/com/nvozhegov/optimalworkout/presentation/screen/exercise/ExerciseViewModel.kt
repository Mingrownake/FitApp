package com.nvozhegov.optimalworkout.presentation.screen.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.Group
import com.nvozhegov.optimalworkout.domain.exercise.GetAllExerciseUseCase
import com.nvozhegov.optimalworkout.presentation.screen.group.GroupsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val getAllExerciseUseCase: GetAllExerciseUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        ExerciseState(
            flowOf()
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    exerciseList = getAllExerciseUseCase()
                )
            }
        }

    }
}

data class ExerciseState(
    val exerciseList: Flow<List<Exercise>>
)