package com.applid.nsofttask.ui.screens.repository_details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applid.nsofttask.ui.screens.common.CustomText
import com.applid.nsofttask.ui.screens.repository_details_screen.components.ContributorItem
import com.applid.nsofttask.ui.screens.repository_details_screen.components.OwnerInfo
import com.applid.nsofttask.ui.screens.repository_details_screen.components.RepoInfo

@Composable
fun RepositoryDetailsScreen(
    navController: NavController
) {
    LazyColumn {

        item {
            OwnerInfo()
            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.Blue, thickness = 1.dp)
        }

        item {
            RepoInfo()
            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.Blue, thickness = 1.dp)
        }

        item {
            CustomText(text = "Contributors details")
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(5) { index ->
            ContributorItem()
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click me")
            }
        }
    }
}
