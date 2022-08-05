package com.applid.nsofttask.ui.screens.repository_details_screen

import android.util.Log
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.ScreenSize
import com.applid.nsofttask.ui.screens.common.SnackBar
import com.applid.nsofttask.ui.screens.common.UiEvent
import com.applid.nsofttask.ui.screens.repository_details_screen.components.ContributorItem
import com.applid.nsofttask.ui.screens.repository_details_screen.components.OwnerInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.components.RepoInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsEvent
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsViewModel

@Composable
fun RepositoryDetailsScreen(
    viewModel: RepositoryDetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val uriHandler = LocalUriHandler.current
    val scaffoldState = rememberScaffoldState()
    val screenWidth = ScreenSize(context = LocalContext.current).getScreenWidth()

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
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    strokeWidth = 5.dp,
                    color = Color.White,
                    modifier = Modifier.width((screenWidth / 2.5).dp)
                )
            }
        } else if (state.repositoryDetailsModel == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                contentAlignment = Alignment.Center
            ) {
                CustomText(text = "No data to show", size = 30.sp)
            }
        } else {
            val repositoryDetailsModel = state.repositoryDetailsModel
            LazyColumn {

                item {
                    OwnerInfo(repositoryDetailsModel = repositoryDetailsModel)
                    Spacer(modifier = Modifier.height(20.dp))
                    Divider(color = Color.Blue, thickness = 1.dp)
                }

                item {
                    RepoInfo(repositoryDetailsModel = repositoryDetailsModel)
                    Spacer(modifier = Modifier.height(20.dp))
                    Divider(color = Color.Blue, thickness = 1.dp)
                }

                item {
                    CustomText(text = "Contributors", size = 20.sp)
                    Spacer(modifier = Modifier.height(15.dp))
                }

                items(repositoryDetailsModel.contributors) {
                    ContributorItem(repositoryContributorModel = it)
                }

                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(
                            onClick = {
                                uriHandler.openUri(repositoryDetailsModel.htmlUrl)
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        ) {
                            CustomText(text = "Go to github", color = Color.Magenta, size = 20.sp)
                        }
                    }
                }
            }
        }
    }
}
