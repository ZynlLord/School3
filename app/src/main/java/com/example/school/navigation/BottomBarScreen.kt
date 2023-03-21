package com.example.school.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.Face
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.school.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int = R.drawable.house
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.house
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.user
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings"
    )

    object Registration : BottomBarScreen(
        route = "registration",
        title = "Registration"
    )

    object Login : BottomBarScreen(
        route = "login",
        title = "Login"
    )

    object AddUser : BottomBarScreen(
        route = "adduser",
        title = "AddUser"
    )
    object Info: BottomBarScreen(
        route = "info",
        title = "Info",
    )

    object ProfileSettings : BottomBarScreen(
        route = "profilesettings",
        title = "ProfileSettings"
    )

    object NotificationSettings : BottomBarScreen(
        route = "notificationsettings",
        title = "Notifications"
    )

    object AccountSettings : BottomBarScreen(
        route = "accountsettings",
        title = "AccountSettings"
    )
    object AllChats : BottomBarScreen(
        route = "allchats",
        title = "Chats",
    )
    object SignUp : BottomBarScreen(
        route = "signup",
        title = "SignUp"
    )

    object SendApplication : BottomBarScreen(
        route = "sendapplication",
        title = "SendApplication"
    )

    object Chat : BottomBarScreen(
        route = "chat",
        title = "Chat"
    )

    object AboutApplications : BottomBarScreen(
        route = "aboutapplciations",
        title = "AboutApplications",
        icon = R.drawable.piechart
    )
    object ApplicationInfo : BottomBarScreen(
        route = "applicationinfo",
        title = "ApplicationInfo"
    )

}
