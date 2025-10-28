package com.nvozhegov.optimalworkout.presentation.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.AppBarTitle
import com.nvozhegov.optimalworkout.presentation.navigation.MainScaffoldViewState

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    scaffoldViewState: MutableState<MainScaffoldViewState>
) {
    LaunchedEffect(Unit) {
        scaffoldViewState.value = MainScaffoldViewState(
            title = {
                AppBarTitle(
                    text = stringResource(R.string.profile)
                )
            },
            navigationIcon = {

            },
            actionButton = {

            }
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ){
        Text("Profile")
    }
}