package com.example.school.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.school.navigation.BottomBarScreen
import com.example.school.db.entities.User
import com.example.school.R
import com.example.school.ui.theme.*
import com.example.school.utils.Constants.Keys.NONE

@Composable
fun UserCard(user: User, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(BottomBarScreen.Info.route + "/${user.ID_User}")
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
            Image(
                painter = rememberAsyncImagePainter("https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"),
                contentDescription = "gfg image",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = user.User_Surname,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = user.User_Name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/*
@Preview
@Composable
fun UserCardPreview() {
    val navController: NavController
    UserCard(
        user = User(
            ID_User = 0,
            User_Photo = NONE,
            User_Phone = NONE,
            User_Surname = "Бобряшов",
            User_Name = "Евгений",
            User_LastName = "Викторович",
            User_Password = NONE,
            User_Login = NONE
        )
    )
}*/
