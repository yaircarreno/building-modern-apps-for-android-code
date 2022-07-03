package com.yaircarreno.ordernow.domain.models.order

data class PaymentResult(
    val status: Boolean,
    val payment: Payment
)