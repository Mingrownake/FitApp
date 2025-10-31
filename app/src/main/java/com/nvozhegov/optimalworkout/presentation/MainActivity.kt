package com.nvozhegov.optimalworkout.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.compose.OptimalWorkoutTheme
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.components.template.GroupButton
import com.nvozhegov.optimalworkout.presentation.components.template.SelectButtonTemplate
import com.nvozhegov.optimalworkout.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(2500)
            keepSplashScreen = false
        }
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

}