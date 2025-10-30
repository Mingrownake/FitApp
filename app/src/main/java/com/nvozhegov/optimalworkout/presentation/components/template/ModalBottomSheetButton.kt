package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModalBottomSheetButton(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes iconId: Int,
    color: Color = MaterialTheme.colorScheme.onBackground,
    onClick: () -> Unit
) {
    Button (
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(iconId),
            tint = color,
            contentDescription = title
        )
        Spacer(
            modifier = Modifier.width(16.dp)
        )
        Text(
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = color,
            text = title
        )
    }
}