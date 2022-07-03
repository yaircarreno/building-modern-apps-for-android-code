package com.yaircarreno.ordernow.ui.patterns

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yaircarreno.ordernow.common.navigation.NavigationBarSection
import com.yaircarreno.ordernow.common.navigation.OrderNowScreenRoute
import com.yaircarreno.ordernow.common.navigation.navigateSaved
import com.yaircarreno.ordernow.common.navigation.popUp
import com.yaircarreno.ordernow.main.OrderNowState
import com.yaircarreno.ordernow.ui.features.cart.CartScreen
import com.yaircarreno.ordernow.ui.features.home.HomeScreen
import com.yaircarreno.ordernow.ui.features.productdetail.ProductDetailScreen
import com.yaircarreno.ordernow.ui.features.productlist.ProductListScreen

@Composable
fun OrderNowNavHost(
    appState: OrderNowState,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = appState.navController,
        startDestination = NavigationBarSection.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        appSoGraph(appState)
    }
}

fun NavGraphBuilder.appSoGraph(appState: OrderNowState) {

    val homeRoute = OrderNowScreenRoute.Home.route
    val listRoute = OrderNowScreenRoute.ProductList.route
    val detailRoute = OrderNowScreenRoute.ProductDetail.route

    val goToListFromHome: () -> Unit = {
        appState.navigateSaved(listRoute, homeRoute)
    }

    val goToDetailFromList: () -> Unit = {
        appState.navigateSaved(detailRoute, listRoute)
    }

    val goBack: () -> Unit = {
        appState.popUp()
    }

    // Home Screen Graph
    composable(NavigationBarSection.Home.route) {
        HomeScreen(goToProductList = goToListFromHome)
    }

    // Cart Screen Graph
    composable(NavigationBarSection.Cart.route) {
        CartScreen()
    }

    // Product List Screen Graph
    composable(OrderNowScreenRoute.ProductList.route) {
        ProductListScreen(goToProductDetail = goToDetailFromList)
    }

    // Product Detail Screen Graph
    composable(OrderNowScreenRoute.ProductDetail.route) {
        ProductDetailScreen(goToBack = goBack)
    }
}