package com.yaircarreno.ordernow.domain.ports

import com.yaircarreno.ordernow.domain.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepositoryPort {
    fun getCategories(): Flow<List<Category>>
}