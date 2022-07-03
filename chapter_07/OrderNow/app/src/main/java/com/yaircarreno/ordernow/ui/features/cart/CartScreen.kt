package com.yaircarreno.ordernow.ui.features.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.models.order.SummaryTotals
import com.yaircarreno.ordernow.ui.composables.items.CartViewItem
import com.yaircarreno.ordernow.ui.composables.screens.Empty
import com.yaircarreno.ordernow.ui.features.cart.components.sections.CartBottom
import com.yaircarreno.ordernow.ui.features.cart.components.sections.CartSummary
import com.yaircarreno.ordernow.ui.features.cart.states.*
import com.yaircarreno.ordernow.ui.theme.lightGrayBackground

@Composable
fun CartScreen(
    goToCheckout: (SummaryTotals) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel(),
) {
    CartUI(
        cartState = viewModel.cartState,
        orderSummaryState = viewModel.orderSummaryState,
        updateQuantity = viewModel.updateQuantity(),
        removeItem = viewModel.removeItem(),
        checkoutSelected = { goToCheckout(viewModel.getSummaryOrder()) },
        modifier = modifier
            .fillMaxSize()
            .background(lightGrayBackground)
    )
}

@Composable
fun CartUI(
    cartState: CartState,
    orderSummaryState: OrderSummaryState,
    updateQuantity: (CartItem, Int) -> Unit,
    removeItem: (CartItem) -> Unit,
    checkoutSelected: () -> Unit,
    modifier: Modifier,
) {
    if (cartState.cartItems.isEmpty()) {
        Empty("No cart items found")
    } else {
        CartElements(
            cartItems = cartState.cartItems,
            numberItems = cartState.cartItems.size,
            totalItems = orderSummaryState.itemsTotal,
            shippingCost = orderSummaryState.shipping,
            taxCost = orderSummaryState.tax,
            total = orderSummaryState.allTotal,
            checkoutSelected = checkoutSelected,
            checkoutReady = cartState.readyForCheckout,
            removeItem = removeItem,
            decreaseItemCount = updateQuantity,
            increaseItemCount = updateQuantity,
            modifier = modifier
        )
    }
}

@Composable
fun CartElements(
    cartItems: List<CartItem>,
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double,
    checkoutSelected: () -> Unit,
    checkoutReady: Boolean,
    removeItem: (CartItem) -> Unit,
    decreaseItemCount: (CartItem, Int) -> Unit,
    increaseItemCount: (CartItem, Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(10.dp),
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(cartItems, key = { it.product.id }) { cartItem ->
            CartViewItem(
                cartItem = cartItem,
                removeItem = removeItem,
                count = cartItem.quantity,
                decreaseItemCount = { decreaseItemCount(cartItem, -1) },
                increaseItemCount = { increaseItemCount(cartItem, 1) }
            )
        }
        item {
            CartSummary(
                numberItems = numberItems,
                totalItems = totalItems,
                shippingCost = shippingCost,
                taxCost = taxCost,
                total = total
            )
            CartBottom(
                checkoutSelected = checkoutSelected,
                checkoutReady = checkoutReady
            )
        }
    }
}


@Preview
@Composable
fun CartScreenPreview() {
    CartElements(
        cartItems = PreviewData.cartProducts(),
        numberItems = 3,
        totalItems = 12.00,
        shippingCost = 10.00,
        taxCost = 2.00,
        total = 24.00,
        checkoutSelected = {},
        checkoutReady = true,
        removeItem = {},
        decreaseItemCount = { _, _ -> },
        increaseItemCount = { _, _ -> }
    )
}