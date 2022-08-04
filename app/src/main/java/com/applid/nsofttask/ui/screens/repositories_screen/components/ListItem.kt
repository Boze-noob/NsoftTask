package com.applid.nsofttask.ui.screens.repositories_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.nsofttask.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.ui.screens.common.CustomText

@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .clickable {  },
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OwnerInfo()
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RepositoryDetails()
            }
        }
    }
}

@Composable
fun OwnerInfo() {
    Card(
        modifier = Modifier.size(60.dp),
        border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
        shape = CircleShape,
        elevation = 2.dp,
    )
    {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    Spacer(modifier = Modifier.width(10.dp))
    CustomText(text = "Owner name", size = 18.sp)
}

@Composable
fun RepositoryDetails() {
    CustomText(text = "Text")
    CustomText(text = "Text")
    CustomText(text = "Text")
    Spacer(modifier = Modifier.height(20.dp))

    CustomText(text = "Text")
    CustomText(text = "Text")
    CustomText(text = "Text")
    CustomText(text = "Text")
}

