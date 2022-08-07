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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.applid.nsofttask.ui.theme.*
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applid.nsofttask.common.extensions.value
import com.applid.nsofttask.domain.models.RepositoryModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.AutoSizeText
import com.applid.nsofttask.ui.screens.common.NetworkImage
import com.applid.nsofttask.ui.navigation.Screen

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
        shape = CutCornerShape(topStart = 20.dp, bottomEnd = 20.dp),
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
    val lightGray = LightGray

    Card(
        modifier = Modifier.size(85.dp),
        border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
        shape = CircleShape,
        elevation = 2.dp,
    )
    {
        NetworkImage(url = repositoryModel.avatarUrl)
    }
    Spacer(modifier = Modifier.height(8.dp))
    AutoSizeText(
        text = repositoryModel.login,
        textStyle = TextStyle(
            fontSize = 22.sp,
            fontFamily = MaterialTheme.typography.body1.fontFamily
        )
    )

    Spacer(modifier = Modifier.height(15.dp))
    CustomText(text = "Repo name:", size = 13.sp, color = lightGray)
    CustomText(text = repositoryModel.name, size = 18.sp)
}

@Composable
fun RepositoryDetails(repositoryModel: RepositoryModel) {

    val lightGray = Color(0xFF949393)

    CustomText(text = "Description:", size = 13.sp, color = lightGray)
    CustomText(text = repositoryModel.description, textAlign = TextAlign.Center, size = 16.sp, maxNumberOfLines = 4)
    Spacer(modifier = Modifier.height(18.dp))
    CustomText(text = "Language: " + repositoryModel.language, color = lightGray, size = 12.sp)
    CustomText(
        text = "Stargazers: " + repositoryModel.stargazersCount.toString().value(),
        color = lightGray,
        size = 12.sp
    )
    CustomText(
        text = "Forks: " + repositoryModel.forksCount.toString().value(),
        color = lightGray,
        size = 12.sp
    )
    CustomText(
        text = "Issues: " + repositoryModel.openIssues.toString().value(),
        color = lightGray,
        size = 12.sp
    )
    CustomText(
        text = "Watchers: " + repositoryModel.watchersCount.toString().value(),
        color = lightGray,
        size = 12.sp
    )
}

