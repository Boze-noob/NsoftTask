package com.applid.nsofttask.ui.screens.repositories_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.ScreenSize
import com.applid.nsofttask.ui.screens.repositories_screen.components.ListItem
import com.applid.nsofttask.ui.screens.repositories_screen.viewModel.RepositoriesListViewModel

@Composable
fun RepositoriesScreen(
    viewModel: RepositoriesListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val screenWidth = ScreenSize(context = LocalContext.current).getScreenWidth()

    if (state.isLoading)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 5.dp,
                modifier = Modifier.width((screenWidth / 2.5).dp)
            )
        }
    else if (state.repositoriesList.isNullOrEmpty())
        CustomText(text = "No data to show")
    else
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {
            LazyColumn {
                items(state.repositoriesList) {
                    ListItem(it)
                }
            }
        }
}