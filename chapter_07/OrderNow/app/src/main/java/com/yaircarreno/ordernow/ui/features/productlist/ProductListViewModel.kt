package com.yaircarreno.ordernow.ui.features.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.usecases.product.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
) : ViewModel() {

    val productListState = { category: Category ->
        productUseCases.getProducts.getProducts(category)
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    }
}