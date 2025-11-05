package com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.domain.template.CreateTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewTemplateViewModel @Inject constructor(
    private val createTemplateUseCase: CreateTemplateUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(TemplateState())
    val usState = _uiState.asStateFlow()

    fun editTitle(newTitle: String) {
        _uiState.update { prev ->
            prev.copy(
                title = newTitle
            )
        }
    }

    fun addExercises(exerciseList: List<Exercise>) {
        _uiState.update { prev ->
            val newTemplate = prev.copy()
            exerciseList.forEach {
                newTemplate.exerciseList.add(it)
            }
            newTemplate
        }
    }

    suspend fun createTemplate() {
        val template = Template(
            id = 0,
            title = _uiState.value.title
        )
        createTemplateUseCase(
            template = template
        )
    }
}

data class TemplateState(
    val title: String = "",
    val exerciseList: MutableList<Exercise> = mutableListOf()
)