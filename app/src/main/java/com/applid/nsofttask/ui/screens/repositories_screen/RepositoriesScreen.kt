package com.applid.nsofttask.ui.screens.repositories_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.applid.nsofttask.ui.screens.repositories_screen.components.ListItem

@Composable
fun RepositoriesScreen() {
    LazyColumn {
        items(5) {
            ListItem()
        }
    }
}