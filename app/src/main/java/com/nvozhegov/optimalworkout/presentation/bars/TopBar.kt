package com.nvozhegov.optimalworkout.presentation.bars


import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nvozhegov.optimalworkout.R
import com.nvozhegov.optimalworkout.presentation.navigation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    currentScreen: AppScreen,
    canBack: Boolean,
    canRemove: Boolean,
    onDelete: () -> Unit,
    onBack: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
            if(canBack) {
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_arrow_back_24),
                        contentDescription = "back"
                    )
                }
            }

        },
        title = {
            Text(
                text = currentScreen.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            if(canRemove) {
                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_delete_24),
                        contentDescription = "delete"
                    )
                }
            }
        }
    )
}