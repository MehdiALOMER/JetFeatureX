package com.yourname.jetfeaturex.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShadowButton(
    text: String,
    onClick: () -> Unit,
    shadowColor: Color = Color.Black,
    elevation: Int = 8
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation.dp,
                shape = MaterialTheme.shapes.medium,
                clip = true
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}