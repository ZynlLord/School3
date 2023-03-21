package com.example.school.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.school.db.entities.Application
import com.example.school.navigation.BottomBarScreen

@Composable
fun ChatCard(application: Application, navController: NavController) {
    Card(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 4.dp)
        .clickable {
            navController.navigate(BottomBarScreen.Chat.route)
        }
    ) {

    }
}