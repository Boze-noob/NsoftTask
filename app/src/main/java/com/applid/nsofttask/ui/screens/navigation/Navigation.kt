package com.applid.nsofttask.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applid.nsofttask.ui.screens.repositories_screen.RepositoriesScreen
import com.applid.nsofttask.ui.screens.repository_details_screen.RepositoryDetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RepositoriesScreen.route) {
        composable(route = Screen.RepositoriesScreen.route) {
            RepositoriesScreen(navController = navController)
        }
        composable(route = Screen.RepositoryDetailsScreen.route) {
            RepositoryDetailsScreen(navController = navController)
        }
    }
}

