package com.yaircarreno.ordernow.domain.models.order

data class SummaryTotals(
    val numberItems: Int = 0,
    val totalItems: Double = 00.00,
    val shippingCost: Double = 00.00,
    val taxCost: Double = 0.00,
    val total: Double = 00.00,
)