package com.nvozhegov.optimalworkout.presentation.screen.group

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.template.GroupButton
import com.nvozhegov.optimalworkout.presentation.navigation.TopBarScaffoldViewState

@Composable
fun GroupScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<TopBarScaffoldViewState>,
    groupViewModel: GroupViewModel = hiltViewModel(),
    actionBack: () -> Unit,
    navigateTo: (Int) -> Unit
) {
    val state by groupViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        scaffoldViewState.value = TopBarScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.muscle_groups)
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
            }
        )
    }
    when (val currentState = state) {
        GroupsState.Finishing -> {
            actionBack()
        }
        is GroupsState.Selecting -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(
                    items = currentState.groupList,
                    key = {group ->
                        group.id
                    }
                ) {group ->
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    GroupButton(
                        groupName = group.name,
                        onClick = {
                            navigateTo(group.id)
                        }
                    )
                }
                item {
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }
            }
        }
    }
}