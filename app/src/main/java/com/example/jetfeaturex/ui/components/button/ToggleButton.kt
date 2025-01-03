package com.yourname.jetfeaturex.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ToggleButton(
    textOn: String,
    textOff: String,
    onToggle: (Boolean) -> Unit
) {
    var isToggled by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isToggled = !isToggled
            onToggle(isToggled)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isToggled) Color(0xFF4CAF50) else Color(0xFFF44336),
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = if (isToggled) textOn else textOff,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}