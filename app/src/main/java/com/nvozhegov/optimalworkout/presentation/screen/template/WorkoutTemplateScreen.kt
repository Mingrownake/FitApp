package com.nvozhegov.optimalworkout.presentation.screen.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WorkoutTemplateScreen(
    modifier: Modifier = Modifier
) {
    Scaffold {innerPadding ->
        Column(modifier = modifier.fillMaxSize().padding(innerPadding)) {
            Text(text = "Hello World!")
        }
    }
}