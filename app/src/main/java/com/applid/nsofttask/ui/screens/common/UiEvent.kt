package com.applid.nsofttask.ui.screens.common

sealed class UiEvent {
    data class ShowSnackBar(
        val message : String
    ) : UiEvent()
}
