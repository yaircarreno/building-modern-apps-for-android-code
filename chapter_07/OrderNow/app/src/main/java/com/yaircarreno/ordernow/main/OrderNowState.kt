package com.yaircarreno.ordernow.main

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yaircarreno.ordernow.common.navigation.OrderNowScreenRoute
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.order.SummaryTotals
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(
    scaffoldState,
    navController,
    resources,
    coroutineScope
) {
    OrderNowState(scaffoldState, navController, resources, coroutineScope)
}

class OrderNowState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val resources: Resources,
    coroutineScope: CoroutineScope
){
    private val screensWithArrowBack = OrderNowScreenRoute.withArrowBack.map { it.route }

    val shouldShowArrowBack: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in screensWithArrowBack

    lateinit var categorySelected: Category
    lateinit var productSelected: Product
    lateinit var summaryTotals: SummaryTotals
    lateinit var orderSelected: Order
}