package com.yourname.jetfeaturex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetfeaturex.ui.components.input.DatePickerField
import com.example.jetfeaturex.ui.components.input.DropdownField
import com.example.jetfeaturex.ui.components.input.DynamicInputField
import com.example.jetfeaturex.ui.components.input.RadioGroupField
import com.example.jetfeaturex.ui.components.input.SwitchField
import com.example.jetfeaturex.ui.components.input.TimePickerField

@Composable
fun InputExamplesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DynamicInputField(
            label = "First Name",
            placeholder = "Enter your first name",
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            backgroundColor = Color(0xFFFFCDD2)
        )
        DatePickerField(
            label = "Select Date",
            backgroundColor = Color(0xFFC8E6C9),
            onDateSelected = { date -> /* Handle selected date */ }
        )
        TimePickerField(
            label = "Select Time",
            backgroundColor = Color(0xFFBBDEFB),
            onTimeSelected = { time -> /* Handle selected time */ }
        )
        DropdownField(
            label = "Choose Option",
            options = listOf("Option 1", "Option 2", "Option 3"),
            backgroundColor = Color(0xFFFFF9C4),
            onOptionSelected = { option -> /* Handle selected option */ }
        )
        SwitchField (
            label = "Enable Notifications",
            backgroundColor = Color(0xFFD1C4E9),
            onCheckedChange = { isChecked -> /* Handle switch state */ }
        )
        RadioGroupField (
            label = "Select Gender",
            options = listOf("Male", "Female", "Other"),
            backgroundColor = Color(0xFFFFCCBC),
            onOptionSelected = { option -> /* Handle selected option */ }
        )
    }
}

// Preview Function
@Preview(showBackground = true, name = "Input Examples Screen Preview")
@Composable
fun InputExamplesScreenPreview() {
    InputExamplesScreen()
}