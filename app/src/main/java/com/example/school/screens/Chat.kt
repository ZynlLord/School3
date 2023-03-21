package com.example.school.screens

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
fun Chat(navController: NavHostController, viewModel: MainViewModel) {
TopChatBar(navController = navController)
}

@Composable
fun TopChatBar(
    navController: NavController
) {
    TopAppBar(
        
        title = {
            Text(text = "Чат")
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(route = BottomBarScreen.Home.route)
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back From Chat Icon"
                )
            }
        },
        backgroundColor = Color.White,
        )
}