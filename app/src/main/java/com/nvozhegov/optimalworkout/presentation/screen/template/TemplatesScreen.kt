package com.nvozhegov.optimalworkout.presentation.screen.template

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.template.ModalBottomSheetButton
import com.nvozhegov.optimalworkout.presentation.components.template.WideAddButton
import com.nvozhegov.optimalworkout.presentation.components.template.SelectButtonTemplate
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen
import com.nvozhegov.optimalworkout.presentation.navigation.MainScaffoldViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplatesScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<MainScaffoldViewState>,
    navController: NavController,
    templatesViewModel: TemplatesViewModel = hiltViewModel()
) {
    val state by templatesViewModel.uiState.collectAsState()
    val templateList by state.templateList.collectAsState(listOf())

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    var selectedTemplate: Template? by remember {
        mutableStateOf(null)
    }

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
    if(showBottomSheet) {
        ModalBottomSheet(
            containerColor = MaterialTheme.colorScheme.primary,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier.padding(top = 8.dp, bottom = 32.dp, start = 8.dp, end = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${selectedTemplate?.title}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                ModalBottomSheetButton(
                    title = stringResource(R.string.edit),
                    iconId = R.drawable.outline_edit_24,
                    onClick = {
                        Log.d("TemplatesScreen", "Id: ${selectedTemplate?.id}")
                    }
                )
                ModalBottomSheetButton(
                    title = stringResource(R.string.delete),
                    iconId = R.drawable.round_delete_24,
                    color = Color.Red,
                    onClick = {
                        Log.d("TemplatesScreen", "Id: ${selectedTemplate?.id}")
                    }
                )
            }

        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            WideAddButton(
                action = {
                    navController.navigate(AppScreen.NewTemplate) {
                        launchSingleTop = true
                    }
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
        items(
            templateList,
            key = {template ->
                template.id
            }
        ) {template ->
            SelectButtonTemplate(
                templateName = template.title,
                onClick = {
                    selectedTemplate = template
                    showBottomSheet = true
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}
