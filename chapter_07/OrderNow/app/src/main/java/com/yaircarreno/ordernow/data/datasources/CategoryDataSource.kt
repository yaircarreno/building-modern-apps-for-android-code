package com.yaircarreno.ordernow.data.datasources

import com.yaircarreno.ordernow.domain.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    fun getCategories(): Flow<List<Category>>
}