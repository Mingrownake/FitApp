package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.WorkoutTemplate
import com.nvozhegov.optimalworkout.domain.workoutTemplate.GetAllWorkoutTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TemplateViewModel @Inject constructor(
    getAllWorkoutTemplateUseCase: GetAllWorkoutTemplateUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(TemplatesState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    templateList = getAllWorkoutTemplateUseCase()
                )
            }
        }

    }
}

data class TemplatesState(
    val templateList: List<WorkoutTemplate> = listOf()
)