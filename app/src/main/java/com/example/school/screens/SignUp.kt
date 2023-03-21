package com.example.school.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.school.viewmodel.MainViewModel
import com.example.school.utils.Constants.Words.LASTNAME
import com.example.school.utils.Constants.Words.NAME
import com.example.school.utils.Constants.Words.PHONE_RU
import com.example.school.utils.Constants.Words.SIGNUP_RU
import com.example.school.utils.Constants.Words.SURNAME

@Composable
fun SignUpScreen(viewModel: MainViewModel, navController: NavHostController) {

    var username by remember { mutableStateOf("") }
    var usersurname by remember { mutableStateOf("") }
    var userlastname by remember { mutableStateOf("") }
    var userphone by remember { mutableStateOf("") }
    var isbuttonenabled by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Cyan
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            OutlinedTextField(value = username, onValueChange = {
                username = it
                isbuttonenabled =
                    username.isNotEmpty() && usersurname.isNotEmpty() && userphone.isNotEmpty()
            },
                label = { Text(text = NAME) })
            OutlinedTextField(value = usersurname, onValueChange = {
                usersurname = it
                isbuttonenabled =
                    username.isNotEmpty() && usersurname.isNotEmpty() && userphone.isNotEmpty()
            },
                label = { Text(text = SURNAME) })
            OutlinedTextField(value = userlastname, onValueChange = {
                userlastname = it
                isbuttonenabled =
                    username.isNotEmpty() && usersurname.isNotEmpty() && userphone.isNotEmpty()
            },
                label = { Text(text = LASTNAME) })
            OutlinedTextField(value = userphone, onValueChange = {
                userphone = it
                isbuttonenabled =
                    username.isNotEmpty() && usersurname.isNotEmpty() && userphone.isNotEmpty()
            },
                label = { Text(text = PHONE_RU) })
            Button(
                onClick = {

                },
                enabled = isbuttonenabled
            ) {
                Text(text = SIGNUP_RU)
            }
        }

    }
}