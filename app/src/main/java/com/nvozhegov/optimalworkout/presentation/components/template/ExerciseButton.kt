package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.data.model.Exercise

@Composable
fun ExerciseButton(
    modifier: Modifier = Modifier,
    exercise: Exercise,
    action: () -> Unit
) {
    var checked by rememberSaveable { mutableStateOf(false) }
    Button(
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth(),
        onClick = {
            action()
            checked = !checked
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                text = exercise.name,
            )
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                    action()
                }
            )
        }
    }
}