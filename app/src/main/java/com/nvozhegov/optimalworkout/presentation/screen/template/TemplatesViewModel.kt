package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.data.model.WorkoutTemplate
import com.nvozhegov.optimalworkout.domain.template.GetAllTemplatesUseCase
import com.nvozhegov.optimalworkout.domain.workoutTemplate.GetAllWorkoutTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TemplatesViewModel @Inject constructor(
    getAllTemplatesUseCase: GetAllTemplatesUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(TemplatesState(
        flowOf()
    ))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    templateList = getAllTemplatesUseCase()
                )
            }
        }

    }
}

data class TemplatesState(
    val templateList: Flow<List<Template>>
)