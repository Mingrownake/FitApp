package com.nvozhegov.optimalworkout.presentation.screen.group

import androidx.lifecycle.ViewModel
import com.nvozhegov.optimalworkout.data.model.entity.Group
import com.nvozhegov.optimalworkout.domain.group.GetAllGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    private val getAllGroupsUseCase: GetAllGroupsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<GroupsState>(
        GroupsState.Selecting(listOf())
    )
    val uiState = _uiState.asStateFlow()
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        when (_uiState.value) {
            GroupsState.Finishing -> {
                _uiState.update { prevState ->
                    prevState
                }
            }
            is GroupsState.Selecting -> {
                getAllGroupsUseCase().onEach {list ->
                    _uiState.update { prev ->
                        GroupsState.Selecting(
                            groupList = list
                        )
                    }
                }.launchIn(coroutineScope)
            }
        }
    }
}

sealed interface GroupsState {
    data class Selecting(
        val groupList: List<Group>
    ) : GroupsState

    data object Finishing: GroupsState
}