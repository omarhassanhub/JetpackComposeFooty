package com.example.jetpackcomposefooty.ui.screens

import com.example.jetpackcomposefooty.R

sealed class BottomNavItem(var title: String, var icon: Int, var route: String){
    object Matches: BottomNavItem("Matches", R.drawable.baseline_sensor_window_24, "matches")
    object News: BottomNavItem("News", R.drawable.baseline_sensor_window_24, "news")
    object Leagues: BottomNavItem("Leagues", R.drawable.baseline_sensor_window_24, "leagues")
    object Following: BottomNavItem("Following", R.drawable.baseline_sensor_window_24, "following")
    object Settings: BottomNavItem("Settings", R.drawable.baseline_settings_24, "settings")
}