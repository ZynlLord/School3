package com.example.school.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.school.R
import com.example.school.navigation.BottomBarScreen
import com.example.school.viewmodel.MainViewModel
import com.example.school.viewmodel.MainViewModelFactory
import com.example.school.ui.theme.DeepBlue
import com.example.school.ui.theme.SchoolTheme
import com.example.school.ui.theme.Shapes

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    var userlogin by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }
    var isbuttonenabled by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    SchoolTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_main),
                    contentDescription = "MainAppIcon",
                    modifier = Modifier.size(200.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = userlogin,
                    onValueChange = {
                        userlogin = it
                        isbuttonenabled = userlogin.isNotEmpty() && userpassword.isNotEmpty()
                    },
                    label = {
                        Text(
                            text = "E-mail",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    },
                    isError = userlogin.isEmpty(),
                    placeholder = { Text(text = "Enter E-mail...") },
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "E-mail TF Icon",
                            )
                        }
                    },
                    singleLine = true,
                    shape = Shapes.medium,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {}
                    ),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                var passwordVisibility by remember { mutableStateOf(false) }
                val icon = if (passwordVisibility) {
                    painterResource(id = R.drawable.design_ic_visibility)
                } else {
                    painterResource(id = R.drawable.design_visibility_off)
                }
                OutlinedTextField(
                    value = userpassword,
                    onValueChange = {
                        userpassword = it
                        isbuttonenabled = userlogin.isNotEmpty() && userpassword.isNotEmpty()
                    },
                    placeholder = {
                        Text(text = "Enter password...")
                    },
                    isError = userpassword.isEmpty(),
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = icon,
                                contentDescription = "Visibility of password"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
            }
            Row {
                var checkedState by remember { mutableStateOf(true) }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = { checkedState = it }
                    )
                    Text(text = "Запомнить пароль", fontSize = 25.sp, color = Color.White)
                }
            }
            Row {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = {
                            navController.navigate(BottomBarScreen.SignUp.route)
                        },
                        enabled = isbuttonenabled
                    ) {
                        Text(text = "Продолжить")
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(BottomBarScreen.SignUp.route)
                    }) {
                        Text(text = "Войти", Modifier.clickable {
                            navController.navigate(BottomBarScreen.Login.route)
                        })
                    }
            }
        }
    }
}