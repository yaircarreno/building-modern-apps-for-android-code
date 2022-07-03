package com.yaircarreno.ordernow.ui.features.placeorder.states

import com.yaircarreno.ordernow.domain.models.order.Payment
import com.yaircarreno.ordernow.domain.models.order.PaymentResult

data class PaymentState(
    val paymentInformation: Payment = Payment(),
    val isLoading: Boolean = false,
    val paymentResult: PaymentResult? = null,
    val errorMessage: String? = null
)