package com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.BaseOutlinedTextField
import com.nvozhegov.optimalworkout.presentation.components.template.WideAddButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTemplateScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    templateViewModel: NewTemplateViewModel = hiltViewModel()
) {
    val state by templateViewModel.usState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val createButtonSentRequest = rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = {
                    AppBarTitle(
                        text = stringResource(R.string.new_template)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                           navController.navigateUp()
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
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
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
                    onValueChange = {newValue ->
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
                                Log.d(
                                    "NewTemplateScreen",
                                    "Click"
                                )
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
                            navController.navigateUp()
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
    }

}