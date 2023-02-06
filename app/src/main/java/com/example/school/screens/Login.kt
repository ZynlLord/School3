package com.example.school.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.school.R
import com.example.school.model.MainViewModel
import com.example.school.model.MainViewModelFactory
import com.example.school.ui.theme.DeepBlue
import com.example.school.ui.theme.DeepPurple
import com.example.school.ui.theme.SchoolTheme
import com.example.school.ui.theme.Shapes

@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
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
               LoginImageLayer()
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                LoginFirstEditLayer()
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                LoginSecondEditLayer()
            }
            Row {
                LoginRememberLayer()
            }
            Row {
                LoginButtonRegLayer()
            }
        }
    }
}

@Composable
fun LoginImageLayer() {
    Image(
        painter = painterResource(id = R.drawable.ic_main),
        contentDescription = "MainAppIcon",
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun LoginFirstEditLayer() {
    var mailtext by remember{ mutableStateOf("") }
    OutlinedTextField(
        value = mailtext,
        onValueChange = { newmailtext ->
            mailtext = newmailtext
        },
        label = {
            Text(text = "E-mail",
                color = Color.White,
                fontSize = 17.sp
            )
        },
        placeholder = {
            Text(text = "Enter E-mail...")
        },
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
            onNext = {

            }
        ),
    )
}

@Composable
fun LoginSecondEditLayer() {
    var password by rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false) }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.design_ic_visibility)
    }
    else {
        painterResource(id = R.drawable.design_visibility_off)
    }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = {
            Text(text = "Enter password...")
        },
        label = {
            Text(text = "Password",
                color = Color.White,
                fontSize = 17.sp)
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

@Composable
fun LoginRememberLayer() {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
        Text(text = "Запомнить пароль", fontSize = 25.sp, color = Color.White)
    }
}

@Composable
fun LoginButtonRegLayer() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = {

        }) {
            Text(text = "Войти")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            LoginImageLayer()
            //Spacer
        }
        Row {
            LoginFirstEditLayer()
        }
        Row {
            LoginSecondEditLayer()
        }
        Row {
            LoginRememberLayer()
        }
        Row {
            LoginButtonRegLayer()
        }
    }
}