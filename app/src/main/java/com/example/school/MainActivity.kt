package com.example.school

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.school.navigation.MainScreen
import com.example.school.viewmodel.MainViewModel
import com.example.school.viewmodel.MainViewModelFactory
import com.example.school.ui.theme.SchoolTheme
import com.example.school.utils.TYPE_ROOM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val mViewModel: MainViewModel =
                viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
            mViewModel.initDatabase(TYPE_ROOM) {

            }
            SchoolTheme {
                MainScreen()
            }
        }
    }
}


