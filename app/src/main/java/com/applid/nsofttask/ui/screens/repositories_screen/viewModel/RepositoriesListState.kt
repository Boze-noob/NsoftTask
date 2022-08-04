package com.applid.nsofttask.ui.screens.repositories_screen.viewModel

import com.applid.nsofttask.domain.models.RepositoryModel

data class RepositoriesListState(
    val isLoading : Boolean = false,
    val repositoryModel: RepositoryModel? = null,
    val error : String = "",
)
