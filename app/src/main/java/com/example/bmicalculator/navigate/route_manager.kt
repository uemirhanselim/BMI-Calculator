package com.example.bmicalculator.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.HomeView
import com.example.bmicalculator.view.ShowView

@Composable
fun MyAppNavHost(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItems.Home.route
    ) {
        composable(NavigationItems.Home.route) {
            HomeView(navController = navController)
        }
        composable(NavigationItems.ShowView.route) {
            val value = it.arguments?.getString("value")
            ShowView(value = value,navController = navController)
        }
    }
}