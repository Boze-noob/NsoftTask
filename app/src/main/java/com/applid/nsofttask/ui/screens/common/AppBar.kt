package com.applid.nsofttask.ui.screens.common


import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun AppBar(
    title: String,
    leadingIcon: ImageVector,
    actionIcon: ImageVector? = null,
    onLeadingIconClick: () -> Unit,
    onActionIconClick: () -> Unit = {},
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primaryVariant
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onLeadingIconClick() }) {
                Icon(imageVector = leadingIcon, contentDescription = "")
            }
            CustomText(text = title, size = 21.sp, color = Color.White)
            if (actionIcon != null)
                IconButton(onClick = { onActionIconClick() }) {
                    Icon(imageVector = actionIcon, contentDescription = "")
                }
            else Box(modifier = Modifier.size(24.dp)) {}
        }
    }
}
