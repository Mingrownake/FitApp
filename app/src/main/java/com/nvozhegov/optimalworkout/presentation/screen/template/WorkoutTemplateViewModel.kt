package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.lifecycle.ViewModel
import com.nvozhegov.optimalworkout.domain.workoutTemplate.GetByIdWorkoutTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WorkoutTemplateViewModel @Inject constructor(
    getByIdWorkoutTemplateUseCase: GetByIdWorkoutTemplateUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(WorkoutTemplateState())
    val uiState = _uiState.asStateFlow()

    fun editName(value: String) {
        _uiState.update { prevState ->
            prevState.copy(
                templateName = value
            )
        }
    }

}

data class WorkoutTemplateState(
    val templateName: String = ""
)