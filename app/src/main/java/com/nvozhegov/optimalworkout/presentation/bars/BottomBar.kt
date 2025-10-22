package com.nvozhegov.optimalworkout.presentation.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentScreen: AppScreen
) {
    NavigationBar(
        modifier = modifier.height(80.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        AppScreen.entries.forEach {
            NavigationBarItem(
                selected = it.name == currentScreen.name,
                onClick = {
                    navController.navigate(route = it.name)
                },
                icon = {
                    Icon(
                        painter = painterResource(it.iconId),
                        contentDescription = it.name
                    )
                },
                label = {
                    Text(
                        text = it.title
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.tertiary,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}