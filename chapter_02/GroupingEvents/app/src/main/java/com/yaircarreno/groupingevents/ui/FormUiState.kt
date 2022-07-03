package com.yaircarreno.groupingevents.ui

data class FormUiState(
    val name: String = "",
    val phone: String = ""
)

val FormUiState.successValidated: Boolean get() = OrderViewModel.applyLogicToValidateInputs(name, phone)