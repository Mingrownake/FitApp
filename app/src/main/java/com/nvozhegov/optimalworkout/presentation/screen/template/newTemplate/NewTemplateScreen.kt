package com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.BaseOutlinedTextField
import com.nvozhegov.optimalworkout.presentation.components.template.WideAddButton
import com.nvozhegov.optimalworkout.presentation.navigation.TemplateNavScreen
import com.nvozhegov.optimalworkout.presentation.navigation.TopBarScaffoldViewState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTemplateScreen(
    modifier: Modifier = Modifier,
    outerNavController: NavController,
    innerNavController: NavController,
    scaffoldViewState: MutableState<TopBarScaffoldViewState>,
    templateViewModel: NewTemplateViewModel = hiltViewModel()
) {
    val state by templateViewModel.usState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val createButtonSentRequest = rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        scaffoldViewState.value = TopBarScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.new_template)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        outerNavController.navigateUp()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_arrow_back_24),
                        contentDescription = "back"
                    )
                }
            }
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            fontSize = 14.sp,
            text = stringResource(R.string.templateName)
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        BaseOutlinedTextField(
            value = state.title,
            onValueChange = { newValue ->
                templateViewModel.editTitle(newValue)
            },
            placeholder = R.string.enterTemplateName
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            fontSize = 14.sp,
            text = stringResource(R.string.list_exercise)
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                WideAddButton(
                    action = {
                        innerNavController.navigate(TemplateNavScreen.Groups.title)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.onTertiary,
                disabledContainerColor = MaterialTheme.colorScheme.tertiary
            ),
            enabled = state.title.isNotBlank() && !createButtonSentRequest.value,
            shape = RoundedCornerShape(8.dp),
            onClick = {
                createButtonSentRequest.value = true
                coroutineScope.launch {
                    templateViewModel.createTemplate()
                    innerNavController.navigateUp()
                }
            }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                text = "Сохранить"
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }

}
