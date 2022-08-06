package com.applid.nsofttask.ui.screens.repositories_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applid.nsofttask.common.extensions.value
import com.applid.nsofttask.domain.models.RepositoryModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.AutoSizeText
import com.applid.nsofttask.ui.screens.common.NetworkImage
import com.applid.nsofttask.ui.screens.navigation.Screen
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsViewModel
import com.applid.nsofttask.ui.screens.repository_details_screen.viewModel.RepositoryDetailsEvent

@Composable
fun ListItem(
    repositoryModel: RepositoryModel,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .clickable {
                navController.navigate(Screen.RepositoryDetailsScreen.route + "?owner=${repositoryModel.login}&name=${repositoryModel.name}")
            },
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OwnerInfo(repositoryModel = repositoryModel)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RepositoryDetails(repositoryModel = repositoryModel)
            }
        }
    }
}

@Composable
fun OwnerInfo(repositoryModel: RepositoryModel) {
    Card(
        modifier = Modifier.size(80.dp),
        border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
        shape = CircleShape,
        elevation = 2.dp,
    )
    {
        NetworkImage(url = repositoryModel.avatarUrl)
    }
    Spacer(modifier = Modifier.height(8.dp))
    AutoSizeText(text = repositoryModel.login, textStyle = TextStyle(fontSize = 18.sp))

}

@Composable
fun RepositoryDetails(repositoryModel: RepositoryModel) {
    CustomText(text = "Repo name:", size = 18.sp)
    CustomText(text = repositoryModel.name)
    Spacer(modifier = Modifier.height(8.dp))
    CustomText(text = "Description:", size = 17.sp)
    CustomText(text = repositoryModel.description, textAlign = TextAlign.Center)

    Spacer(modifier = Modifier.height(20.dp))

    CustomText(text = "Language: " + repositoryModel.language)
    CustomText(text = "Stargazers: " + repositoryModel.stargazersCount.toString().value())
    CustomText(text = "Forks: " + repositoryModel.forksCount.toString().value())
    CustomText(text = "Issues: " + repositoryModel.openIssues.toString().value())
    CustomText(text = "Watchers: " + repositoryModel.watchersCount.toString().value())
}

