package com.yaircarreno.ordernow.ui.features.cart.states

import com.yaircarreno.ordernow.domain.models.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList()
)

val CartState.readyForCheckout: Boolean
    get() = cartItems.isNotEmpty()