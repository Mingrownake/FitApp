package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.R

@Composable
fun GroupButton(
    modifier: Modifier = Modifier,
    groupName: String,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(56.dp),
                painter = painterResource(getResourcesNameByTitle(groupName)),
                contentDescription = groupName
            )
            Text(
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                text = groupName,
            )
            Icon(
                painter = painterResource(R.drawable.round_arrow_right_24),
                contentDescription = "Select group"
            )
        }
    }
}

private fun getResourcesNameByTitle(
    title: String
): Int {
    return when (title) {
        "Neck" -> R.drawable.neck
        "Back" -> R.drawable.back
        "Shoulders" -> R.drawable.shoulders
        "Chest" -> R.drawable.chest
        "Biceps" -> R.drawable.biceps
        "Triceps" -> R.drawable.triceps
        "Forearms" -> R.drawable.forearms
        "Core" -> R.drawable.core
        "Quads" -> R.drawable.quadriceps
        "Glutes" -> R.drawable.glutes
        "Hamstrings" -> R.drawable.hamstrings
        "Calves" -> R.drawable.calves
        else -> throw IllegalArgumentException("Muscle group not found")
    }
}