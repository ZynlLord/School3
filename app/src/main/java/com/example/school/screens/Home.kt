package com.example.school.screens


import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.school.cards.UserCard
import com.example.school.graphs.BottomBarScreen
import com.example.school.model.MainViewModel
import com.example.school.model.MainViewModelFactory

@Composable
fun NewHomeScreen(navController: NavController, viewModel: MainViewModel) {

    val users = viewModel.readAllNotes().observeAsState(listOf()).value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

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



