package com.nvozhegov.optimalworkout.presentation.bars

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen
import com.nvozhegov.optimalworkout.presentation.navigation.BottomBarScreen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedScreenTitle: String,
    navController: NavController,
    onClick: (String) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val navigationList = listOf(
        BottomBarScreen.Profile,
        BottomBarScreen.Templates,
        BottomBarScreen.Exercises,
        BottomBarScreen.Calendar,
        BottomBarScreen.Settings
    )
    NavigationBar(
        modifier = modifier.height(80.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        navigationList.forEach { screen ->
            val selected = screen.title == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onClick(screen.title)
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.iconId),
                        contentDescription = screen.title
                    )
                },
                label = {
                    Text(
                        text = screen.title
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