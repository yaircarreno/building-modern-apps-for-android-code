package com.yaircarreno.ordernow.domain.usecases.product

import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.domain.ports.ProductRepositoryPort
import kotlinx.coroutines.flow.Flow

class GetProductList(
    private val repository: ProductRepositoryPort
) {

    fun getProducts(): Flow<List<Product>> {
        return repository.getProducts()
    }

    fun getProducts(category: Category): Flow<List<Product>> {
        return repository.getProducts(category)
    }
}