package com.applid.nsofttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.applid.nsofttask.ui.screens.repositories_screen.RepositoriesScreen
import com.applid.nsofttask.ui.theme.NsoftTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NsoftTaskTheme {
                RepositoriesScreen()
            }
        }
    }
}

