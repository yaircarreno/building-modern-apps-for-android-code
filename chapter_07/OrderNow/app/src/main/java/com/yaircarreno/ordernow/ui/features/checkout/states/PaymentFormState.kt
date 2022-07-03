package com.yaircarreno.ordernow.ui.features.checkout.states

data class PaymentFormState(
    val name: String = "",
    val number: String = "",
    val month: String = "",
    val year: String = "",
    val code: String = ""
)

val PaymentFormState.successValidated: Boolean
    get() = name.length > 1
            && number.length > 1
            && month.length > 1
            && year.length > 1
            && code.length > 2