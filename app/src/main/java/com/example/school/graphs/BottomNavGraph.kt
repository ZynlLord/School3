package com.example.school.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.school.db.testscreens.AddScreen
import com.example.school.db.testscreens.InfoScreen
import com.example.school.model.MainViewModel
import com.example.school.screens.*
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
            InfoScreen(navController = navController, viewModel = mainViewModel,
                userId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }

    }
}