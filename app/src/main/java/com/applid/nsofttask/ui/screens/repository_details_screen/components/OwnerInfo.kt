package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.nsofttask.R
import com.applid.nsofttask.ui.screens.common.ScreenSize

@Composable
fun OwnerInfo() {
    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight / 3.5).dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Card(
                modifier = Modifier.size(80.dp),
                border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
                shape = CircleShape,
                elevation = 2.dp,
            )
            {
                Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("User name")
        }
    }
}