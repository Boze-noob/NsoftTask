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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.domain.models.RepositoryDetailsModel
import com.applid.nsofttask.ui.screens.common.AutoSizeText
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.common.NetworkImage
import com.applid.nsofttask.ui.screens.common.ScreenSize
import com.applid.nsofttask.ui.theme.*

@Composable
fun OwnerInfo(
    repositoryDetailsModel: RepositoryDetailsModel
) {
    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()
    val lightGray = LightGray

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight / 10).dp),

        ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Card(
                    modifier = Modifier.size((screenHeight / 12).dp),
                    border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
                    shape = CircleShape,
                    elevation = 2.dp,
                )
                {
                    NetworkImage(url = repositoryDetailsModel.avatarUrl)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    CustomText(text = "Owner name:", color = lightGray, size = 13.sp)
                    AutoSizeText(
                        text = repositoryDetailsModel.login,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 21.sp,
                            fontFamily = MaterialTheme.typography.body1.fontFamily
                        )
                    )
                }
            }
        }
    }
}