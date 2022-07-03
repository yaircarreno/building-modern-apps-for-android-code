package com.yaircarreno.ordernow.domain.usecases.payment

import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.PaymentResult
import com.yaircarreno.ordernow.domain.ports.PaymentRepositoryPort

class DoPayment(
    private val repository: PaymentRepositoryPort,
) {

    suspend fun doPayment(order: Order): PaymentResult {
        return repository.orderPayment(order)
    }
}