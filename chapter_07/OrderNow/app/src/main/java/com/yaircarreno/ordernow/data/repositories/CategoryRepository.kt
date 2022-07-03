package com.yaircarreno.ordernow.data.repositories

import com.yaircarreno.ordernow.data.datasources.CategoryDataSource
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.ports.CategoryRepositoryPort
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepositoryPort {

    override fun getCategories(): Flow<List<Category>> {
        return categoryDataSource.getCategories()
    }
}