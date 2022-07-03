package com.yaircarreno.ordernow.data.datasources

import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    fun getProducts(): Flow<List<Product>>
    fun getProducts(category: Category): Flow<List<Product>>
}