package com.yaircarreno.ordernow.domain.usecases.cart

import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class RemoveItemCart(
    private val repository: CartRepositoryPort
) {
    fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return repository.removeItemCart(cartItem)
    }
}