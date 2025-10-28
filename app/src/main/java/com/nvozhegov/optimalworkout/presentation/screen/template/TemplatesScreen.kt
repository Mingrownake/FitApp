package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.template.AddButtonTemplate
import com.nvozhegov.optimalworkout.presentation.components.template.SelectButtonTemplate
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen
import com.nvozhegov.optimalworkout.presentation.navigation.MainScaffoldViewState

@Composable
fun TemplatesScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<MainScaffoldViewState>,
    navController: NavController,
    templatesViewModel: TemplateViewModel = hiltViewModel()
) {
    val state by templatesViewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        scaffoldViewState.value = MainScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.templates)
                )
            },
            navigationIcon = {

            },
            actionButton = {

            }
        )
    }
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            AddButtonTemplate(
                action = {
                    navController.navigate(AppScreen.NewTemplate) {
                        launchSingleTop = true
                    }
                }
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
        items(
            state.templateList,
            key = {
                it.id
            }
        ) {template ->
            SelectButtonTemplate(templateName = template.title)
        }
    }
}
