package com.yaircarreno.ordernow.ui.features.checkout.events

sealed class ContactFormEvent {
    data class OnNameChange(val name: String): ContactFormEvent()
    data class OnPhoneChange(val phone: String): ContactFormEvent()
    data class OnAddressChange(val address: String): ContactFormEvent()
}