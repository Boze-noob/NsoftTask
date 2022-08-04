package com.applid.nsofttask.ui.screens.common


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun CustomText(text : String, size: TextUnit = 14.sp) {
    Text(text = text, style = TextStyle(fontSize = size))
}