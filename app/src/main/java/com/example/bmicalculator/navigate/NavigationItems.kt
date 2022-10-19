package com.example.bmicalculator.navigate

sealed class NavigationItems(val route: String) {
    object Home:NavigationItems("home")
    object ShowView:NavigationItems("showView/{value}")
}
