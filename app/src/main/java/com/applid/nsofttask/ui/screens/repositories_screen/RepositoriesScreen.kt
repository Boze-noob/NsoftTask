package com.applid.nsofttask.ui.screens.repositories_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applid.nsofttask.ui.screens.common.*
import com.applid.nsofttask.ui.screens.repositories_screen.components.ListItem
import com.applid.nsofttask.ui.screens.repositories_screen.components.SearchBar
import com.applid.nsofttask.ui.screens.repositories_screen.viewModel.RepositoriesListEvent
import com.applid.nsofttask.ui.screens.repositories_screen.viewModel.RepositoriesListViewModel

@Composable
fun RepositoriesScreen(
    viewModel: RepositoriesListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    val screenWidth = ScreenSize(context = LocalContext.current).getScreenWidth()
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(it) { data ->
                SnackBar(data = data)
            }
        },
        topBar = {
            SearchBar(
                onTextChange = {
                    viewModel.searchTxt = it
                    viewModel.onEvent(RepositoriesListEvent.GetByName)
                },
                onCloseClicked = {
                    viewModel.searchTxt = ""
                    viewModel.onEvent(RepositoriesListEvent.Init)
                },
                onSearchClicked = { viewModel.onEvent(RepositoriesListEvent.GetByName) },
                text = viewModel.searchTxt
            )
        }
    ) {
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                contentAlignment = Alignment.Center
            ) {
                AutoSizeText(
                    text = "No data to show",
                    textStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                )
            }
        else
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                Column() {
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn {
                        items(state.repositoriesList) {
                            ListItem(repositoryModel = it, navController = navController)
                        }
                    }
                }
            }
    }
}