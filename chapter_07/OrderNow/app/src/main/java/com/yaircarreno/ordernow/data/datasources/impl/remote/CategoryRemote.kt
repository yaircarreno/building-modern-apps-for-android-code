package com.yaircarreno.ordernow.data.datasources.impl.remote

import com.yaircarreno.ordernow.data.datasources.CategoryDataSource
import com.yaircarreno.ordernow.domain.models.Category
import kotlinx.coroutines.flow.Flow

class CategoryRemote: CategoryDataSource {
    override fun getCategories(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }
}