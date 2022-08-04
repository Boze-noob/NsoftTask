package com.applid.nsofttask.ui.screens.common

import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SnackBar(data : SnackbarData) {
    return Snackbar(
        snackbarData = data,
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}