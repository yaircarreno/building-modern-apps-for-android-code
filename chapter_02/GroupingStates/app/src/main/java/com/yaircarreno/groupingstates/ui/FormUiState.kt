package com.yaircarreno.groupingstates.ui

data class FormUiState(
    val name: String = "",
    val phone: String = ""
)

val FormUiState.successValidated: Boolean get() = name.length > 3 && phone.length > 4