package com.yaircarreno.ordernow.common.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.yaircarreno.ordernow.R.string as AppText

sealed class NavigationBarSection(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    companion object {
        val sections = listOf(
            Home,
            Cart
        )
    }

    object Home : NavigationBarSection(
        title = AppText.home,
        icon = Icons.Filled.Home,
        route = OrderNowScreenRoute.Home.route
    )

    object Cart : NavigationBarSection(
        title = AppText.cart,
        icon = Icons.Filled.ShoppingCart,
        route = OrderNowScreenRoute.Cart.route
    )
}