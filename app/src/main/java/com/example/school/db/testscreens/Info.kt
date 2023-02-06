package com.example.school.db.testscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.school.db.User
import com.example.school.graphs.BottomBarScreen
import com.example.school.model.MainViewModel
import com.example.school.utils.Constants.Keys.NONE
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController: NavController, viewModel: MainViewModel, userId: String?) {

    val users = viewModel.readAllNotes().observeAsState(listOf()).value
    val user = users.firstOrNull { it.User_ID == userId?.toInt() } ?: User(
        User_Login = NONE,
        User_Password = NONE,
        User_Name = NONE,
        User_Surname = NONE,
        User_LastName = NONE,
        User_Phone = NONE
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
                        text = "Edit note",
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
                                    User_ID = user.User_ID,
                                    User_Login = userlogin,
                                    User_Password = userpassword,
                                    User_Name = username,
                                    User_Surname = usersurname,
                                    User_LastName = userlastname,
                                    User_Phone = userphone
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
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = user.User_Login,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 32.dp)
                        )
                        Text(
                            text = user.User_Password,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = user.User_Name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = user.User_Surname,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = user.User_LastName,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Text(
                            text = user.User_Phone,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 16.dp)
                        )

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
                    }
                }
            }
        }
    }
}