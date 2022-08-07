package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.common.extensions.value
import com.applid.nsofttask.domain.models.RepositoryDetailsModel
import com.applid.nsofttask.ui.screens.common.AutoSizeText
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.theme.*

@Composable
fun RepoInfo(
    repositoryDetailsModel: RepositoryDetailsModel
) {
    val dividerColor = DarkBlue
    
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        AutoSizeText(
            text = repositoryDetailsModel.name,
            textStyle = TextStyle(
                fontSize = 42.sp,
                fontFamily = MaterialTheme.typography.body1.fontFamily,
                fontWeight = FontWeight.Bold
            )
        )
    }

    Spacer(modifier = Modifier.height(20.dp))
    Divider(color = dividerColor, thickness = 1.dp)

    CustomText(text = "Details", size = 22.sp)
    Spacer(modifier = Modifier.height(10.dp))

    //I could make list of an object and list of description to reduce boilerplate code but I choose safe way
    CustomText(text = "Description: ${repositoryDetailsModel.description}", size = 18.sp)
    Spacer(modifier = Modifier.height(10.dp))
    CustomText(text = "Language: ${repositoryDetailsModel.language}")
    CustomText(
        text = "Stargazers count: ${
            repositoryDetailsModel.stargazersCount.toString().value()
        }"
    )
    CustomText(text = "Forks count: ${repositoryDetailsModel.forksCount.toString().value()}")
    CustomText(text = "Open issues: ${repositoryDetailsModel.openIssues.toString().value()}")
    CustomText(text = "Watcher count: ${repositoryDetailsModel.watchersCount.toString().value()}")
    CustomText(text = "Default branch: ${repositoryDetailsModel.defaultBranch}")
    CustomText(text = "Created at: ${repositoryDetailsModel.createdAt}")
    CustomText(text = "Updated at: ${repositoryDetailsModel.updatedAt}")
}