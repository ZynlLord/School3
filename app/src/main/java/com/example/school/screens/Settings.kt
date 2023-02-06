package com.example.school.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.school.graphs.BottomBarScreen
import com.example.school.model.MainViewModel
import com.example.school.model.MainViewModelFactory

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Column(modifier = Modifier.fillMaxSize()) {
        TopSettingsBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "SETTINGS",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    }
}


@Composable
fun TopSettingsBar(
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(text = "Настройки")
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(route = BottomBarScreen.Home.route)

            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back From Settings Icon"
                )
            }
        },
        backgroundColor = Color.White,

        )
}

