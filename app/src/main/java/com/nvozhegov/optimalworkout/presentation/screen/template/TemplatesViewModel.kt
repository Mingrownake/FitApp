package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.entity.Template
import com.nvozhegov.optimalworkout.domain.template.DeleteTemplateUseCase
import com.nvozhegov.optimalworkout.domain.template.GetAllTemplatesUseCase
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
    val getAllTemplatesUseCase: GetAllTemplatesUseCase,
    val deleteTemplateUseCase: DeleteTemplateUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<TemplatesState>(TemplatesState.Viewing(
        flowOf()
    ))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {templatesState ->
                when (templatesState) {
                    is TemplatesState.Viewing -> {
                        templatesState.copy(
                            templateList = getAllTemplatesUseCase()
                        )
                    }
                }
            }
        }
    }

     fun deleteTemplate(template: Template) {
         viewModelScope.launch {
             _uiState.update { templatesState ->
                 when (templatesState) {
                     is TemplatesState.Viewing -> {
                         deleteTemplateUseCase(template)
                         templatesState.copy(
                             templateList = getAllTemplatesUseCase()
                         )
                     }
                 }
             }
         }
    }
}

sealed interface TemplatesState {
    data class Viewing(val templateList: Flow<List<Template>>) : TemplatesState
}