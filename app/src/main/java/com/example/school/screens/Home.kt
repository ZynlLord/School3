package com.example.school.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.school.cards.UserCard
import com.example.school.navigation.BottomBarScreen
import com.example.school.ui.theme.ElectricBlue
import com.example.school.viewmodel.MainViewModel

@Composable
fun NewHomeScreen(navController: NavController, viewModel: MainViewModel) {

    val users = viewModel.readAllUsers().observeAsState(listOf()).value

    Column(
        modifier = Modifier.fillMaxSize()
            .background(ElectricBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn {
            items(users) { user ->
                UserCard(user = user, navController = navController)
            }
        }
    }
        FloatingActionButton(onClick = {
            navController.navigate(BottomBarScreen.AddUser.route)
        }) {
            Text(text = "+")
        }

}



