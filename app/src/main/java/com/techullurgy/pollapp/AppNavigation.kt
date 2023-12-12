package com.techullurgy.pollapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techullurgy.pollapp.screens.RegisterUserScreen
import com.techullurgy.pollapp.viewmodels.RegisterUserViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.RegisterUserScreen.route) {
        homeScreen(navController)
        registerUserScreen(navController)
    }
}

fun NavGraphBuilder.homeScreen(navController: NavController, route: String = AppScreen.HomeScreen.route) {
    composable(route = route) {

    }
}

fun NavGraphBuilder.registerUserScreen(navController: NavController, route: String = AppScreen.RegisterUserScreen.route) {
    composable(route = route) {
        val viewModel = viewModel<RegisterUserViewModel>()

        val onRegistrationSuccessNavigation: () -> Unit = {
            navController.navigate("login") {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

        RegisterUserScreen(
            viewModel = viewModel,
            onRegistrationSuccessNavigation = onRegistrationSuccessNavigation
        )
    }
}


sealed class AppScreen(val route: String) {
    object HomeScreen: AppScreen(route = "home")
    object RegisterUserScreen: AppScreen(route = "register")
}