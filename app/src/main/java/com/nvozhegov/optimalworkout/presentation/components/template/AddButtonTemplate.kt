package com.nvozhegov.optimalworkout.presentation.components.template

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nvozhegov.optimalworkout.R

@Composable
fun AddButtonTemplate(
    modifier: Modifier = Modifier,
    action: () -> Unit = {}
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        onClick = action
    ) {
        Icon(
            modifier = Modifier.padding(vertical = 16.dp).alpha(0.3f),
            painter = painterResource(R.drawable.round_add_circle_outline_24),
            contentDescription = "Add template"
        )
    }
}
