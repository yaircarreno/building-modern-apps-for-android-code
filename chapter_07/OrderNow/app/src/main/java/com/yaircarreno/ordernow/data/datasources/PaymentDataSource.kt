package com.yaircarreno.ordernow.data.datasources

import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.PaymentResult

interface PaymentDataSource {
    suspend fun doPayment(order: Order): PaymentResult
}