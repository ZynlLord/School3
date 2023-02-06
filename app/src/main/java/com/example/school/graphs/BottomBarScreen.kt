package com.example.school.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Settings: BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
    object Registration: BottomBarScreen(
        route = "registration",
        title = "Registration",
        icon = Icons.Default.Place
    )
    object Login: BottomBarScreen(
        route = "login",
        title = "Login",
        icon = Icons.Filled.AccountCircle
    )
    object AddUser: BottomBarScreen(
        route = "adduser",
        title = "Adduser",
        icon = Icons.Default.AccountBox
    )
    object Info: BottomBarScreen(
        route = "info",
        title = "Info",
        icon = Icons.Default.AccountBox
    )
}
