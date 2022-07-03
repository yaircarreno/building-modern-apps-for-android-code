package com.yaircarreno.ordernow.data.datasources

import com.yaircarreno.ordernow.domain.models.CartItem
import kotlinx.coroutines.flow.Flow

interface CartDataSource {
    fun getCartItems(): Flow<List<CartItem>>
    fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>>
    fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>>
}