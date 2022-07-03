package com.yaircarreno.groupingstates.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    // UI's states
    var formUiState by mutableStateOf(FormUiState())
        private set

    //UI's Events
    fun onNameChange(): (String) -> Unit = {
        formUiState = formUiState.copy(name = it)
    }

    fun onPhoneChange(): (String) -> Unit = {
        formUiState = formUiState.copy(phone = it)
    }

    fun payOrder(): () -> Unit = {
        println("Order generated for ${formUiState.name} and phone ${formUiState.phone}")
    }
}