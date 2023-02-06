package com.example.school.screens


import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.school.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.school.graphs.BottomBarScreen
import com.example.school.model.MainViewModel
import com.example.school.model.MainViewModelFactory
import com.example.school.ui.theme.DeepBlue
import com.example.school.ui.theme.DeepPurple
import com.example.school.ui.theme.SchoolTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    SchoolTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarProfile(context = LocalContext.current.applicationContext,
            navController = navController)

            ProfileEcommerce(navController = navController)
        }
    }
}



private val optionsList: ArrayList<OptionsData> = ArrayList()

@Composable
fun TopAppBarProfile(
    context: Context,
    navController: NavController
    )
{
    val contextForToast = LocalContext.current.applicationContext
    TopAppBar(
        title = {
            Text(text = "Профиль")
        },
        navigationIcon = {
            IconButton(onClick = {
                    navController.navigate(route = BottomBarScreen.Home.route)
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back From Profile Icon")
            }
        },
        backgroundColor = Color.White
    )
}

@Composable
fun ProfileEcommerce(context: Context = LocalContext.current.applicationContext,
navController: NavController
                     ) {

    // This indicates if the optionsList has data or not
    // Initially, the list is empty. So, its value is false.
    var listPrepared by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            optionsList.clear()
            // Add the data to optionsList
            prepareOptionsData()
            listPrepared = true
        }
    }
    if (listPrepared) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                UserDetails(context = context)
            }
            items(optionsList) { item ->
                OptionsItemStyle(item = item, context = context, navController = navController)
            }

        }
    }
}

@Composable
private fun UserDetails(context: Context = LocalContext.current.applicationContext) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(DeepPurple),
        verticalAlignment = Alignment.CenterVertically,

    ) {

        // User's image
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape),
            painter = painterResource(id = R.drawable.ic_compose),
            contentDescription = "Profile Image"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // User's name
                Text(
                    text = "Your Name",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily.Default,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                // User's email
                Text(
                    text = "example@email.com",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default,
                        color = Color.Gray,
                        letterSpacing = (0.8).sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Edit button
            IconButton(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                onClick = {
                    Toast.makeText(context, "Edit Button", Toast.LENGTH_SHORT).show()
                }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit Details",
                    tint = MaterialTheme.colors.primary
                )
            }

        }
    }
}

@Composable
private fun OptionsItemStyle(
    item: OptionsData,
    context: Context,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
                Toast
                    .makeText(context, item.title, Toast.LENGTH_SHORT)
                    .show()
                navController.navigate(route = item.route)
            }
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp),
            imageVector = item.icon,
            contentDescription = item.title,
            tint = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Default,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.subTitle,
                    style = TextStyle(
                        fontSize = 14.sp,
                        letterSpacing = (0.8).sp,
                        fontFamily = FontFamily.Default,
                        color = Color.Gray
                    )
                )

            }
            Icon(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = item.title,
                tint = Color.Black.copy(alpha = 0.70f)
            )
        }

    }
}

private fun prepareOptionsData() {

    val appIcons = Icons.Outlined

    optionsList.add(
        OptionsData(
            icon = appIcons.Person,
            route = "account",
            title = "Аккаунт",
            subTitle = "Смена пароля, должности..."
        )
    )
    optionsList.add(
        OptionsData(
            icon = appIcons.Settings,
            route = "settings",
            title = "Настройки",
            subTitle = "Смена темы, уведомления..."
        )
    )
    optionsList.add(
        OptionsData(
            icon = appIcons.Notifications,
            route = "notifications",
            title = "Уведомления",
            subTitle = "Настройки уведомлений"
        )
    )

}

data class OptionsData(
    val icon: ImageVector,
    val title: String,
    val subTitle: String,
    val route: String,
    )


