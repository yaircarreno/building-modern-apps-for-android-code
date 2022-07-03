package com.yaircarreno.groupingevents.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    // UI's states
    var formUiState by mutableStateOf(FormUiState())
        private set

    //UI's Events
    fun onFormEvent(formEvent: FormUiEvent) {
        when (formEvent) {
            is FormUiEvent.OnNameChange -> {
                formUiState = formUiState.copy(name = formEvent.name)
            }
            is FormUiEvent.OnPhoneChange -> {
                formUiState = formUiState.copy(phone = formEvent.phone)
            }
            is FormUiEvent.PayOrderClicked -> {
                println("Sending form with parameters: ${formUiState.name} and ${formUiState.phone}")
            }
        }
    }

    // Business's logic or maybe some UI's logic for update the state
    companion object {
        fun applyLogicToValidateInputs(name: String, phone: String): Boolean {
            return name.length > 1 && phone.length > 3
        }
    }
}