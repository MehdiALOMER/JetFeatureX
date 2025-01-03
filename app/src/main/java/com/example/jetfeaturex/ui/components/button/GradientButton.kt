package com.yourname.jetfeaturex.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF42A5F5), Color(0xFF1E88E5))
                )
            ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = text, color = Color.White, style = MaterialTheme.typography.bodyLarge)
    }
}