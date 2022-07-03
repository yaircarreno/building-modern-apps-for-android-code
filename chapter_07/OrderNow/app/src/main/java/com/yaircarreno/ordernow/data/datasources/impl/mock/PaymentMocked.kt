package com.yaircarreno.ordernow.data.datasources.impl.mock

import com.yaircarreno.ordernow.data.datasources.PaymentDataSource
import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.Payment
import com.yaircarreno.ordernow.domain.models.order.PaymentResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PaymentMocked : PaymentDataSource {

    override suspend fun doPayment(order: Order): PaymentResult {
        return withContext(Dispatchers.IO) {
            delay(4000)
            PaymentResult(
                status = true,
                payment = Payment(
                    status = "SUCCESS",
                    reference = "123ABC")
            )
        }
    }
}