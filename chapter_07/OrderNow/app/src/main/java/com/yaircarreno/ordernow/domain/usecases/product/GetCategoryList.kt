package com.yaircarreno.ordernow.domain.usecases.product

import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.ports.CategoryRepositoryPort
import kotlinx.coroutines.flow.Flow

class GetCategoryList(
    private val repository: CategoryRepositoryPort
) {

    fun getCategories(): Flow<List<Category>> {
        return repository.getCategories()
    }
}