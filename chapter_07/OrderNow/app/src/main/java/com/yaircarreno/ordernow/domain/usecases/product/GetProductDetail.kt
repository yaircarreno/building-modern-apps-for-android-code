package com.yaircarreno.ordernow.domain.usecases.product

import com.yaircarreno.ordernow.domain.ports.ProductRepositoryPort

class GetProductDetail(
    private val repository: ProductRepositoryPort
)