package com.example.composeinputsdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeinputsdemo.MainScreen
import com.example.composeinputsdemo.ui.screen.TextFieldScreen

@Composable
fun GlobalNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainMenu.name, modifier = modifier) {
        composable(route = Routes.MainMenu.name) {
            MainScreen(navController = navController)
        }
        composable(route = Routes.TextField.name) {
            TextFieldScreen(navController = navController)
        }
    }
}