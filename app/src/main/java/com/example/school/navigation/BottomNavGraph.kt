package com.example.school.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.school.screens.testscreens.AddScreen
import com.example.school.screens.testscreens.InfoScreen
import com.example.school.viewmodel.MainViewModel
import com.example.school.screens.*
import com.example.school.screens.settings.AccountSettings
import com.example.school.screens.settings.NotificationSettings
import com.example.school.utils.Constants

@Composable
fun BottomNavGraph(navController: NavHostController, mainViewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Registration.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            NewHomeScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Registration.route) {
            RegistrationScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Login.route) {
            LoginScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.AddUser.route) {
            AddScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Info.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            InfoScreen(
                navController = navController, viewModel = mainViewModel,
                userId = backStackEntry.arguments?.getString(Constants.Keys.ID)
            )
        }
        composable(route = BottomBarScreen.SignUp.route) {
            SignUpScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.SendApplication.route) {
            SendApplication(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Chat.route) {
            Chat(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.ProfileSettings.route) {
            EditProfile(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.AllChats.route) {
            AllChatsScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.AccountSettings.route) {
            AccountSettings(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.NotificationSettings.route) {
            NotificationSettings(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.AboutApplications.route) {
            AboutApplications(navController = navController, viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.ApplicationInfo.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            ApplicationInfo(navController = navController, viewModel = mainViewModel,
                userId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }
}