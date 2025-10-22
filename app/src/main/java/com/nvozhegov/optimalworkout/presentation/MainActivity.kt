package com.nvozhegov.optimalworkout.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.OptimalWorkoutTheme
import com.nvozhegov.optimalworkout.presentation.navigation.AppNavigation
import com.nvozhegov.optimalworkout.presentation.screen.exercise.ExercisesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OptimalWorkoutTheme {
                AppNavigation()
            }
        }
    }
}

@Preview()
@Composable
fun PreviewComposable() {
    OptimalWorkoutTheme {
        AppNavigation()
    }
}