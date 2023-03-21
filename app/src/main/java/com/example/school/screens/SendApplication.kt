package com.example.school.screens

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.school.db.entities.Application
import com.example.school.navigation.BottomBarScreen
import com.example.school.ui.theme.ElectricBlue
import com.example.school.ui.theme.Purple700
import com.example.school.viewmodel.MainViewModel

@Composable
fun SendApplication(viewModel: MainViewModel, navController: NavHostController) {
    var applicationname by remember { mutableStateOf("") }
    var applicationdesc by remember { mutableStateOf("") }

    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }


    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
            imageUri = it
        }


    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ElectricBlue)
            ) {
                TextField(
                    value = applicationname,
                    onValueChange = { applicationname = it },
                    label = {
                        Text(text = "Тема заявки")
                    },
                    placeholder = {
                        Text("Заявка на тему...")
                    },
                    maxLines = 4,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .background(Purple700)
            ) {
                TextField(
                    modifier = Modifier.fillMaxSize(),
                    value = applicationdesc,
                    onValueChange = {
                        applicationdesc = it
                    },
                    label = {
                        Text(
                            text = "Текст заявки",
                            fontSize = 20.sp
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Укажите проблему...",
                            fontSize = 20.sp
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            launcher.launch("image/*")
                        }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Pick up image icon"
                            )
                        }
                    }
                )
            }
            Row(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .background(Color.Blue)
            ) {
                imageUri?.let {
                    bitmap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                    } else {
                        val source = ImageDecoder.createSource(context.contentResolver, it)
                        ImageDecoder.decodeBitmap(source)
                    }
                    Image(bitmap = bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp))
                }
            }
            Row(modifier = Modifier.fillMaxSize()) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    onClick = {
                        viewModel.addApplication(
                            application = Application(
                                ID_Application = 0,
                                Cabinet = applicationname,
                                Address = 1,
                                Application_Description = applicationdesc,
                                Department_ID = 1,
                                User_ID = 1
                            )
                        ) {
                            navController.navigate(BottomBarScreen.Chat.route)
                        }
                    }
                ) {
                    Text(text = "Отправить")
                }
            }
        }
    }
}

