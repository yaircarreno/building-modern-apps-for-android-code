package com.yaircarreno.ordernow.data.repositories

import com.yaircarreno.ordernow.data.datasources.ProductDataSource
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.domain.ports.ProductRepositoryPort
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val productDataSource: ProductDataSource
) : ProductRepositoryPort {

    override fun getProducts(): Flow<List<Product>> {
        return productDataSource.getProducts()
    }

    override fun getProducts(category: Category): Flow<List<Product>> {
        return productDataSource.getProducts(category)
    }
}