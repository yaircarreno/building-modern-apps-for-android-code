package com.yaircarreno.ordernow.data.datasources.impl.mock

import com.yaircarreno.ordernow.data.datasources.CartDataSource
import com.yaircarreno.ordernow.domain.models.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CartMocked : CartDataSource {

    private var cartItems =
        mutableListOf(
            DataMocked.cartItem1,
            DataMocked.cartItem2,
            DataMocked.cartItem3
        )

    override fun getCartItems(): Flow<List<CartItem>> {
        return flowOf(cartItems)
    }

    override fun saveItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        val item = cartItems.find { item -> item.product.id == cartItem.product.id }
        if (item != null) {
            val index = cartItems.indexOf(item)
            cartItems[index] = CartItem(
                quantity = item.quantity + cartItem.quantity,
                product = cartItem.product
            )
        } else {
            cartItems.add(cartItem)
        }
        return flowOf(cartItems)
    }

    override fun removeItemCart(cartItem: CartItem): Flow<List<CartItem>> {
        val listUpdated = mutableListOf<CartItem>()
        cartItems.forEach {
            if (it.product.id != cartItem.product.id) {
                listUpdated.add(it)
            }
        }
        cartItems = listUpdated
        return flowOf(listUpdated)
    }

    override fun updateCartItems(cartItem: CartItem, operator: Int): Flow<List<CartItem>> {
        val listUpdated = mutableListOf<CartItem>()
        cartItems.forEach {
            listUpdated.add(it)
            if (it.product.id == cartItem.product.id) {
                listUpdated[listUpdated.indexOf(it)] = CartItem(
                    quantity = cartItem.quantity + operator,
                    product = cartItem.product
                )
            }
        }
        cartItems = listUpdated
        return flowOf(listUpdated)
    }
}