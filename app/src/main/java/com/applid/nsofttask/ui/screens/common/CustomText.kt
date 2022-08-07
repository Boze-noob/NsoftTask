package com.applid.nsofttask.ui.screens.common


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.R


@Composable
fun CustomText(
    text: String,
    size: TextUnit = 14.sp,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = Color.Black,
    maxNumberOfLines : Int = 100
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = size,
            color = color,
            fontFamily = MaterialTheme.typography.body1.fontFamily
        ),
        textAlign = textAlign,
        maxLines = maxNumberOfLines
    )
}