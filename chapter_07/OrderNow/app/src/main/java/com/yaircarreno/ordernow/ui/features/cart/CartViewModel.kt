package com.yaircarreno.ordernow.ui.features.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.models.order.SummaryTotals
import com.yaircarreno.ordernow.domain.usecases.cart.CartUseCases
import com.yaircarreno.ordernow.ui.features.cart.states.CartState
import com.yaircarreno.ordernow.ui.features.cart.states.OrderSummaryState
import com.yaircarreno.ordernow.ui.features.cart.states.allTotal
import com.yaircarreno.ordernow.ui.features.cart.states.itemsTotal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCases: CartUseCases,
) : ViewModel() {

    var cartState by mutableStateOf(CartState())
        private set

    var orderSummaryState by mutableStateOf(OrderSummaryState())
        private set

    init {
        viewModelScope.launch {
            cartUseCases.getCartItems
                .getCartItems().collect {
                    updateStates(cartItems = it)
                }
        }
    }

    fun removeItem(): (CartItem) -> Unit = { cartItem ->
        viewModelScope.launch {
            cartUseCases.removeItemCart
                .removeItemCart(cartItem).collect {
                    updateStates(cartItems = it)
                }
        }
    }

    fun updateQuantity(): (CartItem, Int) -> Unit = { cartItem, operator ->
        if (!(operator < 0 && cartItem.quantity == 1)) {
            viewModelScope.launch {
                cartUseCases.updateCartItems
                    .updateCartItems(cartItem, operator).collect {
                        updateStates(cartItems = it)
                    }
            }
        }
    }

    private fun updateStates(cartItems: List<CartItem>) {
        cartState = cartState.copy(cartItems = cartItems)
        orderSummaryState = orderSummaryState.copy(cartItems = cartItems)
    }

    fun getSummaryOrder(): SummaryTotals {
        return summaryStateToModel(orderSummaryState)
    }

    private fun summaryStateToModel(
        orderSummaryState: OrderSummaryState,
    ): SummaryTotals {
        return SummaryTotals(
            numberItems = orderSummaryState.cartItems.size,
            totalItems = orderSummaryState.itemsTotal,
            shippingCost = orderSummaryState.shipping,
            taxCost = orderSummaryState.tax,
            total = orderSummaryState.allTotal
        )
    }
}