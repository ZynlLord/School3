package com.example.school.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.school.db.entities.Application
import com.example.school.navigation.BottomBarScreen
import com.example.school.ui.theme.Purple200
import com.example.school.ui.theme.Purple500
import com.example.school.ui.theme.Shapes

@Composable
fun ApplicationCard(application: Application, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(BottomBarScreen.Info.route + "/${application.ID_Application}")
            },
        elevation = 8.dp,
        shape = Shapes.medium,
        backgroundColor = Purple500,
        border = BorderStroke(1.dp, Purple200)
    ) {
        Row(
            modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = application.Cabinet,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,

                )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = application.Application_Description,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}