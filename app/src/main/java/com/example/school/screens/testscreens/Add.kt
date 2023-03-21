package com.example.school.screens.testscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.school.db.entities.User
import com.example.school.navigation.BottomBarScreen
import com.example.school.viewmodel.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavController, viewModel: MainViewModel) {

    var userlogin by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var usersurname by remember { mutableStateOf("") }
    var userlastname by remember { mutableStateOf("") }
    var userphone by remember { mutableStateOf("") }
    var isbuttonenabled by remember { mutableStateOf(false) }

    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add new User",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = userlogin,
                onValueChange = {
                    userlogin = it
                    isbuttonenabled =
                        userlogin.isNotEmpty() && userpassword.isNotEmpty() && userphone.isNotEmpty()
                },
                label = {
                    Text(text = "User Login")
                },
                isError = userlogin.isEmpty(),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
            OutlinedTextField(
                value = userpassword,
                onValueChange = {
                    userpassword = it
                    isbuttonenabled =
                        userlogin.isNotEmpty() && userpassword.isNotEmpty() && username.isNotEmpty() && userphone.isNotEmpty()
                },
                label = {
                    Text(text = "User Password")
                },
                isError = userpassword.isEmpty(),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                    isbuttonenabled =
                        userlogin.isNotEmpty() && userpassword.isNotEmpty() && username.isNotEmpty() && userphone.isNotEmpty()
                },
                label = {
                    Text(text = "User Name")
                },
                isError = username.isEmpty(),
                maxLines = 1,
                singleLine = true,
            )
            OutlinedTextField(
                value = usersurname,
                onValueChange = {
                    usersurname = it
                    isbuttonenabled =
                        userlogin.isNotEmpty() && userpassword.isNotEmpty() && username.isNotEmpty() && userphone.isNotEmpty()
                },
                label = {
                    Text(text = "User Surname")
                },
                isError = usersurname.isEmpty(),
                maxLines = 1,
                singleLine = true,
            )
            OutlinedTextField(value = userlastname, onValueChange = {
                userlastname = it
                isbuttonenabled =
                    userlogin.isNotEmpty() && userpassword.isNotEmpty() && username.isNotEmpty() && userphone.isNotEmpty()
            }, label = {
                Text(text = "User Lastname")
            },
                maxLines = 1,
                singleLine = true
            )
            OutlinedTextField(value = userphone,
                onValueChange = {
                    if (userphone.length <
                        11
                    ) {
                        userphone = it
                    }
                    isbuttonenabled =
                        userlogin.isNotEmpty() && userpassword.isNotEmpty() && username.isNotEmpty() && userphone.isNotEmpty()
                }, label = {
                    Text(text = "User Phone")
                },
                isError = userphone.isEmpty(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                ),
                maxLines = 1,
                singleLine = true
            )
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isbuttonenabled,
                onClick = {
                    viewModel.addUser(
                        user = User(
                            User_Login = userlogin,
                            User_Password = userpassword,
                            User_Name = username,
                            User_Surname = usersurname,
                            User_LastName = userlastname,
                            User_Phone = userphone,
                            User_Photo = "none"
                        )
                    ) {
                        navController.navigate(BottomBarScreen.Home.route)
                    }
                }) {
                Text(text = "Add User")
            }
        }
    }
}