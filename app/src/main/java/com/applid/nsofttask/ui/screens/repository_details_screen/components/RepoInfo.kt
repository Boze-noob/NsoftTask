package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.nsofttask.ui.screens.common.CustomText

@Composable
fun RepoInfo() {
    CustomText(text = "Repository details")
    Spacer(modifier = Modifier.height(10.dp))

    //I could make list of an object and list of description to reduce boilerplate code but I choose safe way
    CustomText(text = "Repository name: Name")
    CustomText(text = "Description: description")
    CustomText(text = "Language: language")
    CustomText(text = "Stargazers count: Count")
    CustomText(text = "Forks count: Count")
    CustomText(text = "Open issues: count")
    CustomText(text = "Watcher count: count")
    CustomText(text = "Default branch: branch")
    CustomText(text = "Created at: Date")
    CustomText(text = "Updated at: Date")


}