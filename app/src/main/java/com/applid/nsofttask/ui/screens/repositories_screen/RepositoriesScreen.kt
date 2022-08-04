package com.applid.nsofttask.ui.screens.repositories_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.repositories_screen.components.ListItem
import com.applid.nsofttask.ui.screens.repositories_screen.viewModel.RepositoriesListViewModel

@Composable
fun RepositoriesScreen(
    viewModel: RepositoriesListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if(state.isLoading)
        CircularProgressIndicator()
    else if (state.repositoriesList.isNullOrEmpty())
        CustomText(text = "No data to show")

    else
        LazyColumn {
            items(state.repositoriesList) {
                ListItem(it)
            }
        }
}