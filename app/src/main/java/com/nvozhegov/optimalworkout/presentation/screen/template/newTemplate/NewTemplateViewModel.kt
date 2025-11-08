package com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate

import androidx.lifecycle.ViewModel
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.data.model.TemplateExerciseCrossRef
import com.nvozhegov.optimalworkout.domain.template.CreateTemplateCrossRefUseCase
import com.nvozhegov.optimalworkout.domain.template.CreateTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewTemplateViewModel @Inject constructor(
    private val createTemplateUseCase: CreateTemplateUseCase,
    private val createTemplateCrossRefUseCase: CreateTemplateCrossRefUseCase
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

    fun removeExercise(exercise: Exercise) {
        _uiState.update { prev ->
            prev.copy(
                exerciseList = prev.exerciseList.filter {
                    it.exerciseId != exercise.exerciseId
                }.toMutableList()
            )
        }
    }

    suspend fun createTemplate(): Int {
        val template = Template(
            templateId = 0,
            title = _uiState.value.title
        )
        return createTemplateUseCase(
            template = template
        )
    }

    suspend fun createCrossRef(templateId: Int, exerciseId: Int) {
        createTemplateCrossRefUseCase(templateId, exerciseId)
    }
}

data class TemplateState(
    val title: String = "",
    val exerciseList: MutableList<Exercise> = mutableListOf()
)