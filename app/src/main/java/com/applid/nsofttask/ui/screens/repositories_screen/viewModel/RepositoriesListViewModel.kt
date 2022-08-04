package com.applid.nsofttask.ui.screens.repositories_screen.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class RepositoriesListViewModel {

    private val _state = mutableStateOf(RepositoriesListState())
    val state: State<RepositoriesListState> = _state

    fun onEvent(event : RepositoriesListEvent) {
        when(event) {
            RepositoriesListEvent.Init -> {
                getAllRepositories()
            }
        }
    }

    fun getAllRepositories() {

    }
}