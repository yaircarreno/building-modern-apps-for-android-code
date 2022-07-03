package com.yaircarreno.ordernow.domain.usecases.cart

import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class SaveItemCart(
    private val repository: CartRepositoryPort
) {
    fun saveItem(cartItem: CartItem): Flow<List<CartItem>> {
        return repository.saveItemCart(cartItem)
    }
}