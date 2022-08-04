package com.applid.nsofttask.ui.screens.repositories_screen.viewModel

import com.applid.nsofttask.domain.models.RepositoryModel

data class RepositoriesListState(
    val isLoading : Boolean = false,
    val repositoriesList: List<RepositoryModel>? = null,
    val error : String = "",
)
