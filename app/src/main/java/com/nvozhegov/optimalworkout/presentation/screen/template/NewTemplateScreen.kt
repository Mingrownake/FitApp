package com.nvozhegov.optimalworkout.presentation.screen.template

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.components.BaseOutlinedTextField
import com.nvozhegov.optimalworkout.presentation.navigation.MainScaffoldViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTemplateScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
                            navController.popBackStack()
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
            modifier = Modifier
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
                    value = "",
                    onValueChange = {

                    },
                    placeholder = R.string.enterTemplateName
                )
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    item {

                    }
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        contentColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.primary,
                        disabledContainerColor = MaterialTheme.colorScheme.onBackground
                    ),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {

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