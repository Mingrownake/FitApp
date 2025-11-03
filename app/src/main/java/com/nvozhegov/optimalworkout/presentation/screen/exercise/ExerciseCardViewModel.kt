package com.nvozhegov.optimalworkout.presentation.screen.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.domain.exercise.GetAllExerciseUseCase
import com.nvozhegov.optimalworkout.domain.exercise.GetExercisesByGroupIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ExerciseCardViewModel.ExerciseCardFactory::class)
class ExerciseCardViewModel @AssistedInject constructor(
    @Assisted("groupId") groupId: Int,
    private val getExercisesByGroupIdUseCase: GetExercisesByGroupIdUseCase
) : ViewModel() {

    @AssistedFactory
    interface ExerciseCardFactory {
        fun create(@Assisted("groupId") groupId: Int): ExerciseCardViewModel
    }
    private val _uiState = MutableStateFlow<ExerciseCardState>(
        ExerciseCardState.Selecting(listOf())
    )
    val uiState = _uiState.asStateFlow()
    val scope = CoroutineScope(Dispatchers.IO)

    init {
        when (_uiState.value) {
            ExerciseCardState.Finishing -> {
                _uiState.update {prev ->
                    prev
                }
            }
            is ExerciseCardState.Selecting -> {
                viewModelScope.launch {
                    getExercisesByGroupIdUseCase(groupId).onEach {list ->
                        _uiState.update {
                            ExerciseCardState.Selecting(
                                exerciseList = list
                            )
                        }
                    }.launchIn(scope)
                }
            }
        }
    }
}

sealed interface ExerciseCardState {
    data class Selecting(
        val exerciseList: List<Exercise>
    ) : ExerciseCardState
    data object Finishing : ExerciseCardState
}