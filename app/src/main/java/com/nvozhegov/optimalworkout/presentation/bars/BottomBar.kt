package com.nvozhegov.optimalworkout.presentation.bars

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentScreenTitle: String
) {
    val navigationList = listOf(
        AppScreen.Profile,
        AppScreen.Templates,
        AppScreen.Exercises,
        AppScreen.Calendar,
        AppScreen.Settings
    )
    NavigationBar(
        modifier = modifier.height(80.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        navigationList.forEach {
            NavigationBarItem(
                selected = it.title == currentScreenTitle,
                onClick = {
                    if (currentScreenTitle != it.title) {
                        navController.navigate(route = it.title)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(it.iconId),
                        contentDescription = it.title
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