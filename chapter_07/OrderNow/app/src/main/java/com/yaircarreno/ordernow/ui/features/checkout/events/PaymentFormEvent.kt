package com.yaircarreno.ordernow.ui.features.checkout.events

sealed class PaymentFormEvent {
    data class OnNameChange(val name: String): PaymentFormEvent()
    data class OnNumberChange(val number: String): PaymentFormEvent()
    data class OnMonthChange(val month: String): PaymentFormEvent()
    data class OnYearChange(val year: String): PaymentFormEvent()
    data class OnCodeChange(val code: String): PaymentFormEvent()
}