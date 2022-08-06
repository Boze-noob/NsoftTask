package com.applid.nsofttask.ui.screens.repositories_screen.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.domain.use_cases.GetAllRepositoriesUseCase
import com.applid.nsofttask.domain.use_cases.GetRepositoriesByNameUseCase
import com.applid.nsofttask.ui.screens.common.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesListViewModel @Inject constructor(
    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase,
    private val getRepositoriesByNameUseCase: GetRepositoriesByNameUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RepositoriesListState())
    val state: State<RepositoriesListState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var searchTxt by mutableStateOf("")

    init {
        onEvent(RepositoriesListEvent.Init)
    }

    fun onEvent(event: RepositoriesListEvent) {
        when (event) {
            is RepositoriesListEvent.Init -> {
                getAllRepositories()
            }
            is RepositoriesListEvent.GetByName -> {
                if (searchTxt.isNotEmpty())
                    getByName()
                else sendUiEvent(
                    UiEvent.ShowSnackBar(
                        message = "Please enter text first!"
                    )
                )
            }
        }
    }

    private fun getAllRepositories() {
        getAllRepositoriesUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = RepositoriesListState(
                        error = result.message ?: "An unexpected error happen", isLoading = false
                    )
                    viewModelScope.launch {
                        sendUiEvent(
                            UiEvent.ShowSnackBar(
                                message = state.value.error
                            )
                        )
                        return@launch
                    }
                }
                is Resource.Loading -> _state.value = RepositoriesListState(isLoading = true)
                is Resource.Success -> _state.value =
                    RepositoriesListState(isLoading = false, repositoriesList = result.data)
            }
        }.launchIn(viewModelScope)
    }

    private fun getByName() {

        getRepositoriesByNameUseCase(name = searchTxt).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = RepositoriesListState(
                        error = result.message ?: "An unexpected error happen", isLoading = false
                    )
                    viewModelScope.launch {
                        sendUiEvent(
                            UiEvent.ShowSnackBar(
                                message = state.value.error
                            )
                        )
                        return@launch
                    }
                }
                is Resource.Loading -> _state.value = RepositoriesListState(isLoading = true)
                is Resource.Success -> _state.value =
                    RepositoriesListState(isLoading = false, repositoriesList = result.data)
            }
        }.launchIn(viewModelScope)
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}