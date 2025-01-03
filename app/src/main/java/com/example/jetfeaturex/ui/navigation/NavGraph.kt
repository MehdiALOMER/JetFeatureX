package com.yourname.jetfeaturex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yourname.jetfeaturex.ui.screens.HomeScreen
import com.yourname.jetfeaturex.ui.screens.InputExamplesScreen
import com.yourname.jetfeaturex.ui.screens.LoginScreen
import com.yourname.jetfeaturex.ui.screens.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") {  HomeScreen(navController)  }
        composable("text_input") { InputExamplesScreen() }
        composable("profile") { ProfileScreen() }
    }
}