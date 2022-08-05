package com.applid.nsofttask.ui.screens.repository_details_screen.viewModel

sealed class RepositoryDetailsEvent {
    data class GetRepositoryDetails(val owner: String, val name: String) : RepositoryDetailsEvent()
}
