package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.bars.BottomBar
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.navigation.ScaffoldViewState


@Composable
fun WorkoutTemplateScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<ScaffoldViewState>,
    //viewModel: WorkoutTemplateViewModel = hiltViewModel()
) {
    //val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        scaffoldViewState.value = ScaffoldViewState(
            title = {

            },
            navigationIcon = {

            },
            actionButton = {

            }
        )
    }

    Column() {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                text = stringResource(R.string.templateName)
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                //value = uiState.templateName,
                //onValueChange = { change ->
                //    viewModel.editName(change)
                //},
                value = "",
                onValueChange = { newValue ->
                    newValue
                },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.secondary
                ),
                placeholder = {
                    Text(
                        fontSize = 14.sp,
                        text = stringResource(R.string.enterTemplateName)
                    )
                }
            )
        }
    }