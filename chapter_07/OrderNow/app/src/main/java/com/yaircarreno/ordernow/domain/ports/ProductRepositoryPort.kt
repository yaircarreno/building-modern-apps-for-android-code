package com.yaircarreno.ordernow.domain.ports

import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepositoryPort {
    fun getProducts(): Flow<List<Product>>
    fun getProducts(category: Category): Flow<List<Product>>
}