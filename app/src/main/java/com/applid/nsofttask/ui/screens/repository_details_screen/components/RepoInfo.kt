package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.domain.models.RepositoryDetailsModel
import com.applid.nsofttask.ui.screens.common.CustomText

@Composable
fun RepoInfo(
    repositoryDetailsModel: RepositoryDetailsModel
) {
    CustomText(text = "Repository details", size = 20.sp)
    Spacer(modifier = Modifier.height(10.dp))

    //I could make list of an object and list of description to reduce boilerplate code but I choose safe way
    CustomText(text = "Repository name: ${repositoryDetailsModel.name}")
    CustomText(text = "Description: ${repositoryDetailsModel.description}")
    CustomText(text = "Language: ${repositoryDetailsModel.language}")
    CustomText(text = "Stargazers count: ${repositoryDetailsModel.stargazersCount}")
    CustomText(text = "Forks count: ${repositoryDetailsModel.forksCount}")
    CustomText(text = "Open issues: ${repositoryDetailsModel.openIssues}")
    CustomText(text = "Watcher count: ${repositoryDetailsModel.watchersCount}")
    CustomText(text = "Default branch: ${repositoryDetailsModel.defaultBranch}")
    CustomText(text = "Created at: ${repositoryDetailsModel.createdAt}")
    CustomText(text = "Updated at: ${repositoryDetailsModel.updatedAt}")


}