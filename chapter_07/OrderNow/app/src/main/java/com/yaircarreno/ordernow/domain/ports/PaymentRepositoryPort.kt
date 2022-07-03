package com.yaircarreno.ordernow.domain.ports

import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.PaymentResult

interface PaymentRepositoryPort {
    suspend fun orderPayment(order: Order): PaymentResult
}