package com.applid.nsofttask.ui.screens.repositories_screen.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.domain.use_cases.GetAllRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class RepositoriesListViewModel @Inject constructor(
    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RepositoriesListState())
    val state: State<RepositoriesListState> = _state

    fun onEvent(event : RepositoriesListEvent) {
        when(event) {
            is RepositoriesListEvent.Init -> {
                getAllRepositories()
            }
        }
    }

    private fun getAllRepositories() {
       getAllRepositoriesUseCase().onEach { result ->
           when(result) {
               is Resource.Error -> TODO()
               is Resource.Loading -> TODO()
               is Resource.Success -> TODO()
           }
       }.launchIn(viewModelScope)
    }
}