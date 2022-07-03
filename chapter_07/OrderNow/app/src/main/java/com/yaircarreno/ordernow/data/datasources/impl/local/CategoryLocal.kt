package com.yaircarreno.ordernow.data.datasources.impl.local

import com.yaircarreno.ordernow.data.datasources.CategoryDataSource
import com.yaircarreno.ordernow.domain.models.Category
import kotlinx.coroutines.flow.Flow

class CategoryLocal: CategoryDataSource {
    override fun getCategories(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }
}