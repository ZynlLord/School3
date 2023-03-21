package com.example.school.screens.settings

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.school.navigation.BottomBarScreen
import com.example.school.viewmodel.MainViewModel

@Composable
fun NotificationSettings(navController: NavHostController, viewModel: MainViewModel) {
    TopSettingsNotificationsBar(navController = navController)
}

@Composable
fun TopSettingsNotificationsBar(
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(text = "Настройки уведомлений")
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(route = BottomBarScreen.Profile.route)

            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back From Settings Profile Icon"
                )
            }
        },
        backgroundColor = Color.White,
    )
}