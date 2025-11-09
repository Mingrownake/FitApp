package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.nvozhegov.optimalworkout.data.model.entity.Exercise

@Composable
fun ExerciseCard(
    modifier: Modifier = Modifier,
    exercise: Exercise,
    deleteAction: () -> Unit
) {
    Row (
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.primary
            )
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = exercise.name,
            fontWeight = FontWeight.Bold,
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Icon(
            modifier = Modifier.clickable(
                onClick = deleteAction
            ),
            painter = painterResource(R.drawable.round_delete_24),
            contentDescription = "remove",
            tint = MaterialTheme.colorScheme.error
        )
    }
}