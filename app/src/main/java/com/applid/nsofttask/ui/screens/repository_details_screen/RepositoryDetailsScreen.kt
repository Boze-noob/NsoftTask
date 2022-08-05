package com.applid.nsofttask.ui.screens.repository_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.repository_details_screen.components.ContributorItem
import com.applid.nsofttask.ui.screens.repository_details_screen.components.OwnerInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.components.RepoInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsViewModel

@Composable
fun RepositoryDetailsScreen(
    viewModel: RepositoryDetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val uriHandler = LocalUriHandler.current

    if(state.isLoading) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {
            CircularProgressIndicator(strokeWidth = 5.dp, color = Color.White)
        }
    } else if(state.repositoryDetailsModel == null) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {
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
                CustomText(text = "Contributors details")
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(repositoryDetailsModel.contributors) {
                ContributorItem(repositoryContributorModel = it)
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {

                    uriHandler.openUri(repositoryDetailsModel.htmlUrl) }) {
                    Text(text = "Click me")
                }
            }
        }
    }
}
