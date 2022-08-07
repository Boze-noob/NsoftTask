package com.applid.nsofttask.ui.screens.repository_details_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applid.nsofttask.ui.screens.common.*
import com.applid.nsofttask.ui.screens.repository_details_screen.components.ContributorItem
import com.applid.nsofttask.ui.screens.repository_details_screen.components.OwnerInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.components.RepoInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsViewModel
import com.applid.nsofttask.ui.theme.*


@Composable
fun RepositoryDetailsScreen(
    viewModel: RepositoryDetailsViewModel = hiltViewModel(),
    navController: NavController
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
        topBar = {
            AppBar(
                title = "Repository details",
                leadingIcon = Icons.Default.ArrowBack,
                onLeadingIconClick = {
                    navController.navigateUp()
                })
        }
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
            val dividerColor = MaterialTheme.colors.primaryVariant
            LazyColumn(modifier = Modifier.padding(horizontal = 5.dp)) {

                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    OwnerInfo(repositoryDetailsModel = repositoryDetailsModel)
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    RepoInfo(repositoryDetailsModel = repositoryDetailsModel)
                    Spacer(modifier = Modifier.height(20.dp))
                    Divider(color = dividerColor, thickness = 1.dp)
                }

                item {
                    CustomText(text = "Contributors", size = 20.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                }

                if (repositoryDetailsModel.contributors.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CustomText(text = "No contributors", size = 18.sp)
                        }
                    }
                } else {
                    item {
                        LazyRow {
                            items(repositoryDetailsModel.contributors) {
                                ContributorItem(repositoryContributorModel = it)
                            }
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                uriHandler.openUri(repositoryDetailsModel.htmlUrl)
                            },
                            border = BorderStroke(1.dp, DarkBlue),
                            colors = ButtonDefaults.outlinedButtonColors(
                                backgroundColor = Color.Transparent
                            )
                        ) {
                            AutoSizeText(
                                text = "Go to github",
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontFamily = MaterialTheme.typography.body1.fontFamily
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


