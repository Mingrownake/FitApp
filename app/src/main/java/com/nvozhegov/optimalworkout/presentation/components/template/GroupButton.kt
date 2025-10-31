package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
                    .size(80.dp),
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

private sealed class MuscleGroup(
    val title: String
) {
    data object Neck: MuscleGroup("Neck")
    data object Trapezius: MuscleGroup("Trapezius")
    data object Broadest: MuscleGroup("Broadest")
    data object Extensors: MuscleGroup("Extensors")
    data object Shoulders: MuscleGroup("Shoulders")
    data object Chest: MuscleGroup("Chest")
    data object Biceps: MuscleGroup("Biceps")
    data object Triceps: MuscleGroup("Triceps")
    data object Forearms: MuscleGroup("Forearms")
    data object Press: MuscleGroup("Press")
    data object Quadriceps: MuscleGroup("Quadriceps")
    data object Cheek: MuscleGroup("Cheek")
    data object BackBiceps: MuscleGroup("Back Biceps")
    data object Gastrocnemius: MuscleGroup("Gastrocnemius")
}

private fun getResourcesNameByTitle(
    title: String
): Int {
    return when (title) {
        "Neck" -> R.drawable.neck
        "Trapezius" -> R.drawable.trapezius
        "Broadest" -> R.drawable.broadest
        "Extensors" -> R.drawable.extensors
        "Shoulders" -> R.drawable.shoulders
        "Chest" -> R.drawable.chest
        "Biceps" -> R.drawable.biceps
        "Triceps" -> R.drawable.triceps
        "Forearms" -> R.drawable.forearms
        "Press" -> R.drawable.press
        "Quadriceps" -> R.drawable.quadriceps
        "Cheek" -> R.drawable.cheek
        "Back Biceps" -> R.drawable.backbiceps
        "Gastrocnemius" -> R.drawable.gastrocnemius
        else -> throw IllegalArgumentException("Muscle group not found")
    }
}