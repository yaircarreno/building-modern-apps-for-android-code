package com.yaircarreno.ordernow.data.repositories

import com.yaircarreno.ordernow.data.datasources.CartDataSource
import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.ports.CartRepositoryPort
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDataSource: CartDataSource
): CartRepositoryPort {
    override fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.saveItemCart(cartItem)
    }

    override fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        return cartDataSource.removeItemCart(cartItem)
    }

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDataSource.getCartItems()
    }

    override fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>> {
        return cartDataSource.updateCartItems(cartItem, operator)
    }
}