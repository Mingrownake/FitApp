package com.example.compose

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = theme_light_primary,
    onPrimary = theme_light_on_primary,
    secondary = theme_light_secondary,
    tertiary = theme_light_tertiary,
    onTertiary = theme_light_on_tertiary,
    background = theme_light_background,
    onBackground = theme_light_on_background,
    error = theme_light_error
)

private val darkScheme = darkColorScheme(

)

@Composable
fun OptimalWorkoutTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

