package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.domain.models.RepositoryDetailsModel
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.NetworkImage
import com.applid.nsofttask.ui.screens.common.ScreenSize

@Composable
fun OwnerInfo(
    repositoryDetailsModel: RepositoryDetailsModel
) {
    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight / 3.5).dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(120.dp),
                border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
                shape = CircleShape,
                elevation = 2.dp,
            )
            {
                NetworkImage(url = repositoryDetailsModel.avatarUrl)
            }
            Spacer(modifier = Modifier.height(8.dp))
            CustomText(
                text = repositoryDetailsModel.login,
                textAlign = TextAlign.Center,
                size = 22.sp
            )
        }
    }
}