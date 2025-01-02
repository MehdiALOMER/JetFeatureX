package com.yourname.jetfeaturex.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var scale by remember { mutableStateOf(1f) }
    val scaleAnimation = animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(durationMillis = 200)
    )
    var errorMessage by remember { mutableStateOf("") }

    // Animasyon: Fade-in için alpha değerini kontrol eden animasyon
    val alphaAnimation = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Title with fade-in animation
            Text(
                text = "Welcome to FeatureX",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 30.sp),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = alphaAnimation.value),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Username TextField
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                placeholder = { Text("Enter your username") },
                isError = username.isBlank() && errorMessage.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password TextField
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
//                        Icon(
//                            imageVector = if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
//                            contentDescription = "Toggle Password Visibility"
//                        )
                    }
                },
                isError = password.isBlank() && errorMessage.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Error Message
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Animated Login Button
            Button(
                onClick = {
                    if (username.isBlank() || password.isBlank()) {
                        errorMessage = "Please fill out all fields."
                    } else {
                        errorMessage = ""
                        scale = 0.9f // Animation Effect
                        navController.navigate("home")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .graphicsLayer(scaleX = scaleAnimation.value, scaleY = scaleAnimation.value),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Login", style = MaterialTheme.typography.bodyLarge)
            }

            // Reset button scale animation after click
            LaunchedEffect(scale) {
                if (scale < 1f) {
                    scale = 1f
                }
            }
        }
    }
}

// Preview Function
@Preview(showBackground = true, name = "Login Screen Preview")
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}