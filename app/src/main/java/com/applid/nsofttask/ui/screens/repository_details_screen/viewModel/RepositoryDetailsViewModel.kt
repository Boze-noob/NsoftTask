package com.applid.nsofttask.ui.screens.repository_details_screen.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.domain.use_cases.GetRepositoryDetailsUseCase
import com.applid.nsofttask.ui.screens.common.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailsViewModel @Inject constructor(
    private val getRepositoryDetailsUseCase: GetRepositoryDetailsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(RepositoryDetailsState())
    val state: State<RepositoryDetailsState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent  = _uiEvent.receiveAsFlow()

    fun onEvent(event : RepositoryDetailsEvent) {
        when(event) {
            is RepositoryDetailsEvent.GetRepositoryDetails -> getRepositoryDetails(event = event)
        }
    }

    private fun getRepositoryDetails(event : RepositoryDetailsEvent.GetRepositoryDetails) {
        getRepositoryDetailsUseCase(owner = event.owner, name = event.name).onEach { result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = RepositoryDetailsState(error = result.message ?: "An unexpected error happen", isLoading = false)
                    viewModelScope.launch {
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = state.value.error
                        ))
                        return@launch
                    }
                }
                is Resource.Loading -> _state.value = RepositoryDetailsState(isLoading = true)
                is Resource.Success -> _state.value = RepositoryDetailsState(isLoading = false, repositoryDetailsModel = result.data)
            }
        }.launchIn(viewModelScope)
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}