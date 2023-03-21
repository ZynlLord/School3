package com.example.school.screens.testscreens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.school.R
import com.example.school.db.entities.User
import com.example.school.navigation.BottomBarScreen
import com.example.school.ui.theme.ElectricBlue
import com.example.school.ui.theme.Purple500
import com.example.school.viewmodel.MainViewModel
import com.example.school.utils.Constants.Keys.NONE
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController: NavController, viewModel: MainViewModel, userId: String?) {

    val users = viewModel.readAllUsers().observeAsState(listOf()).value
    val user = users.firstOrNull { it.ID_User == userId?.toInt() } ?: User(
        User_Login = NONE,
        User_Password = NONE,
        User_Name = NONE,
        User_Surname = NONE,
        User_LastName = NONE,
        User_Phone = NONE,
        User_Photo = NONE,
    )
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var userlogin by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var usersurname by remember { mutableStateOf("") }
    var userlastname by remember { mutableStateOf("") }
    var userphone by remember { mutableStateOf("") }

    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
            imageUri = it
        }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 32.dp)
                ) {
                    Text(
                        text = "Edit user",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = userlogin,
                        onValueChange = { userlogin = it },
                        label = { Text(text = "UserLogin") },
                        isError = userlogin.isEmpty()
                    )
                    OutlinedTextField(
                        value = userpassword,
                        onValueChange = { userpassword = it },
                        label = { Text(text = "UserPassword") },
                        isError = userpassword.isEmpty()
                    )
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "UserName") },
                        isError = username.isEmpty()
                    )
                    OutlinedTextField(
                        value = usersurname,
                        onValueChange = { usersurname = it },
                        label = { Text(text = "UserSurname") },
                        isError = usersurname.isEmpty()
                    )
                    OutlinedTextField(
                        value = userlastname,
                        onValueChange = { userlastname = it },
                        label = { Text(text = "UserLastname") }
                    )
                    OutlinedTextField(
                        value = userphone,
                        onValueChange = { userphone = it },
                        label = { Text(text = "UserPhone") },
                        isError = userphone.isEmpty()
                    )
                    Button(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(bottom = 20.dp),
                        onClick = {
                            viewModel.updateUser(
                                user = User(
                                    ID_User = user.ID_User,
                                    User_Login = userlogin,
                                    User_Password = userpassword,
                                    User_Name = username,
                                    User_Surname = usersurname,
                                    User_LastName = userlastname,
                                    User_Phone = userphone,
                                    User_Photo = "aaa"
                                )
                            ) {
                                navController.navigate(BottomBarScreen.Home.route)
                            }
                        }
                    ) {
                        Text(text = "Update user")
                    }
                }
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ElectricBlue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                        .background(ElectricBlue)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .background(ElectricBlue),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            IconButton(onClick = {

                            }, Modifier.background(ElectricBlue)) {
                                Image(
                                    painterResource(id = R.drawable.unavatar),
                                    contentDescription = "NONE",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(CircleShape)
                                        .border(2.dp, Purple500, CircleShape)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = user.User_Surname,
                                fontSize = 25.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.width(30.dp))
                            Text(
                                text = user.User_Name,
                                fontSize = 25.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "Должность: ",
                                fontSize = 25.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.width(30.dp))
                            Text(
                                text = "User.Post",
                                fontSize = 25.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Button(onClick = {
                                coroutineScope.launch {
                                    userlogin = user.User_Login
                                    userpassword = user.User_Password
                                    username = user.User_Name
                                    usersurname = user.User_Surname
                                    userlastname = user.User_LastName
                                    userphone = user.User_Phone
                                    bottomSheetState.show()
                                }
                            }) {
                                Text(text = "UPDATE")
                            }
                            Button(onClick = {
                                viewModel.deleteUser(user = user) {
                                    navController.navigate(BottomBarScreen.Home.route)
                                }
                            }) {
                                Text(text = "DELETE")
                            }
                        }
                        Button(onClick = {
                            navController.navigate(BottomBarScreen.Home.route)
                        }) {
                            Text(text = "Back")
                        }
                        Spacer(modifier = Modifier.height(110.dp))
                        Button(
                            onClick = { navController.navigate(BottomBarScreen.SendApplication.route) },
                            Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                        ) {
                            Text(text = "Отправить заявку")
                        }
                    }
                }
            }
        }
    }
}