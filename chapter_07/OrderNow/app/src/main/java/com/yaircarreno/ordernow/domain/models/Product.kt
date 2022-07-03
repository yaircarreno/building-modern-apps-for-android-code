package com.yaircarreno.ordernow.domain.models

data class Product(
    val id: String,
    val name: String,
    val description: String? = null,
    val urlImage: String,
    val price: Double,
    val category: Category
)