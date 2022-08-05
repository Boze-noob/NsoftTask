package com.applid.nsofttask.ui.screens.repository_details_screen.viewModel

import com.applid.nsofttask.domain.models.RepositoryDetailsModel

data class RepositoryDetailsState(
    val isLoading : Boolean = false,
    val repositoryDetailsModel : RepositoryDetailsModel? = null,
    val error : String = "",
)
