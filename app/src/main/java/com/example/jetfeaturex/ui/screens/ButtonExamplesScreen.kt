package com.yourname.jetfeaturex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourname.jetfeaturex.ui.components.button.*

@Composable
fun ButtonExamplesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        StandardButton(text = "Standard Button") { /* Handle click */ }
        OutlinedButton(text = "Outlined Button") { /* Handle click */ }
        GradientButton(text = "Gradient Button") { /* Handle click */ }
        IconButton(text = "Icon Button") { /* Handle click */ }
        LoadingButton(text = "Loading Button", isLoading = false) { /* Handle click */ }
        ShadowButton(text = "Shadow Button", onClick = { /* Handle click */ })
        ToggleButton(
            textOn = "Toggle On",
            textOff = "Toggle Off",
            onToggle = { toggled -> /* Handle toggle state */ }
        )
    }
}
// Preview Function
@Preview(showBackground = true, name = "Button Examples Screen Preview")
@Composable
fun ButtonExamplesScreenPreview() {
    ButtonExamplesScreen()
}
