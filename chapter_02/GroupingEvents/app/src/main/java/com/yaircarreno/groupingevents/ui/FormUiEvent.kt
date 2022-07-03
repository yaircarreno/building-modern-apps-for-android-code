package com.yaircarreno.groupingevents.ui

sealed class FormUiEvent {
    data class OnNameChange(val name: String): FormUiEvent()
    data class OnPhoneChange(val phone: String): FormUiEvent()
    object PayOrderClicked: FormUiEvent()
}