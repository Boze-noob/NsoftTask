package com.applid.nsofttask.ui.screens.navigation

sealed class Screen(val route : String) {
    object RepositoriesScreen : Screen("repositories_screen")
    object RepositoryDetailsScreen : Screen("repository_details_screen")
}
