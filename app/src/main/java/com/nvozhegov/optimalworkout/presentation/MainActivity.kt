package com.nvozhegov.optimalworkout.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.OptimalWorkoutTheme
import com.nvozhegov.optimalworkout.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OptimalWorkoutTheme {
                Navigation()
            }
        }
    }
}

@Preview()
@Composable
fun PreviewComposable() {
    OptimalWorkoutTheme {
        Navigation()
    }
}