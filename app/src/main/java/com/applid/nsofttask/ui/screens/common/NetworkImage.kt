package com.applid.nsofttask.ui.screens.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.applid.nsofttask.R

@Composable
fun NetworkImage(url : String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "",
        error = painterResource(id = R.drawable.ic_launcher_foreground),
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}