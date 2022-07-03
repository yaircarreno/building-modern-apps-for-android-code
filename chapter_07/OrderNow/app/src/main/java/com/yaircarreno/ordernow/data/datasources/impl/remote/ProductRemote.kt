package com.yaircarreno.ordernow.data.datasources.impl.remote

import com.yaircarreno.ordernow.data.datasources.ProductDataSource
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import kotlinx.coroutines.flow.Flow

class ProductRemote: ProductDataSource {
    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun getProducts(category: Category): Flow<List<Product>> {
        TODO("Not yet implemented")
    }
}