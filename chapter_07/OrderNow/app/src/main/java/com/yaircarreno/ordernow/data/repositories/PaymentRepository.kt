package com.yaircarreno.ordernow.data.repositories

import com.yaircarreno.ordernow.data.datasources.PaymentDataSource
import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.PaymentResult
import com.yaircarreno.ordernow.domain.ports.PaymentRepositoryPort

class PaymentRepository(
    private val paymentDataSource: PaymentDataSource,
) : PaymentRepositoryPort {
    override suspend fun orderPayment(order: Order): PaymentResult {
        return paymentDataSource.doPayment(order)
    }
}