package com.yaircarreno.ordernow.common.navigation

sealed class OrderNowScreenRoute (val route: String) {

    companion object {
        val withArrowBack = listOf(
            ProductDetail,
            Checkout,
            PlaceOrder
        )
    }

    object Home : OrderNowScreenRoute("home")
    object Cart : OrderNowScreenRoute("cart")
    object ProductList : OrderNowScreenRoute("product_list")
    object ProductDetail : OrderNowScreenRoute("product_detail")
    object Checkout : OrderNowScreenRoute("checkout")
    object PlaceOrder : OrderNowScreenRoute("place_order")
}