package com.example.school.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.school.graphs.BottomBarScreen
import com.example.school.db.User
import com.example.school.R

@Composable
fun UserCard(user: User, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(BottomBarScreen.Info.route + "/${user.User_ID}")
            },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                painter = painterResource(id = R.drawable.ic_compose),
                contentDescription = "User_Avatar"
            )

            Text(
                text = user.User_Surname,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = user.User_Name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}