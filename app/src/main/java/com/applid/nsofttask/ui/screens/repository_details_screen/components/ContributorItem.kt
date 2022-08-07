package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.domain.models.RepositoryContributorModel
import com.applid.nsofttask.ui.screens.common.AutoSizeText
import com.applid.nsofttask.ui.screens.common.NetworkImage

@Composable
fun ContributorItem(
    repositoryContributorModel: RepositoryContributorModel
) {
    Column(
        modifier = Modifier.padding(vertical = 15.dp, horizontal = 5.dp).size(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.size(60.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.secondary),
            shape = CircleShape,
            elevation = 2.dp,
        )
        {
            NetworkImage(url = repositoryContributorModel.avatarUrl)
        }
        Spacer(modifier = Modifier.width(15.dp))
        AutoSizeText(
            text = repositoryContributorModel.login,
            textStyle = TextStyle(fontSize = 16.sp)
        )
    }
}