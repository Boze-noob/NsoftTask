package com.applid.nsofttask.ui.screens.repository_details_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.R
import com.applid.nsofttask.ui.screens.common.AutoSizeText

@Composable
fun ContributorItem() {
    Card(
        modifier = Modifier.size(80.dp),
        border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
        shape = CircleShape,
        elevation = 2.dp,
    )
    {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
    }
    Spacer(modifier = Modifier.height(8.dp))
    AutoSizeText(text = "This is contributor name", textStyle = TextStyle(fontSize = 18.sp))
}