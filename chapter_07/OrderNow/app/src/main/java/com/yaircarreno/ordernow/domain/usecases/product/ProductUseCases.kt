package com.yaircarreno.ordernow.domain.usecases.product

data class ProductUseCases(
    val getProducts: GetProductList,
    val getProduct: GetProductDetail,
    val getCategories: GetCategoryList
)