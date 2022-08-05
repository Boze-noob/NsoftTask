package com.applid.nsofttask.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.applid.nsofttask.ui.screens.repositories_screen.RepositoriesScreen
import com.applid.nsofttask.ui.screens.repository_details_screen.RepositoryDetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RepositoriesScreen.route) {
        composable(route = Screen.RepositoriesScreen.route) {
            RepositoriesScreen(navController = navController)
        }
        composable(route = Screen.RepositoryDetailsScreen.route
                + "?owner={owner}&name={name}",
            arguments = listOf(
                navArgument(
                    name = "owner"
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = "name"
                ) {
                    type = NavType.StringType
                }

            )
        ) {
            RepositoryDetailsScreen()
        }
    }
}

