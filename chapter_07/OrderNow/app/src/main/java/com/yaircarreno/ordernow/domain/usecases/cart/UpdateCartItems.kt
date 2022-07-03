package com.yaircarreno.ordernow.domain.usecases.cart

import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class UpdateCartItems(
    private val repository: CartRepositoryPort
) {
    fun updateCartItems(cartItems: CartItem, operator: Int): Flow<List<CartItem>> {
        return repository.updateCartItems(cartItems, operator)
    }
}