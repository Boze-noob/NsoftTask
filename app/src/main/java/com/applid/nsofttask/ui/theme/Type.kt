package com.applid.nsofttask.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.applid.nsofttask.R

private val sourceCodeProFontFamily = FontFamily(
    Font(R.font.sourcecodepro_light, FontWeight.Light),
    Font(R.font.sourcecodepro_medium, FontWeight.Medium),
    Font(R.font.sourcecodepro_regular, FontWeight.Normal),
    Font(R.font.sourcecodepro_bold, FontWeight.Bold),
    Font(R.font.sourcecodepro_black, FontWeight.Black)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = sourceCodeProFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    defaultFontFamily = sourceCodeProFontFamily,
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)