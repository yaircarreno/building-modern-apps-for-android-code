package com.yaircarreno.ordernow.ui.features.placeorder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.ui.composables.buttons.StandardButton
import com.yaircarreno.ordernow.ui.composables.cards.SummaryCard
import com.yaircarreno.ordernow.ui.composables.screens.Loading
import com.yaircarreno.ordernow.ui.composables.screens.Results
import com.yaircarreno.ordernow.ui.features.placeorder.components.OrderInformation
import com.yaircarreno.ordernow.ui.features.placeorder.states.PaymentState
import com.yaircarreno.ordernow.ui.theme.lightGrayBackground

@Composable
fun PlaceOrderScreen(
    order: Order,
    modifier: Modifier = Modifier,
    viewModel: PlaceOrderViewModel = hiltViewModel(),
) {
    OrderUI(
        order = order,
        paymentUiState = viewModel.paymentUiState,
        onPlaceOrder = { viewModel.makePayment() },
        modifier = modifier
            .fillMaxSize()
            .background(lightGrayBackground)
    )
}

@Composable
fun OrderUI(
    order: Order,
    paymentUiState: PaymentState,
    onPlaceOrder: () -> Unit,
    modifier: Modifier,
) {
    if (paymentUiState.isLoading) {
        Loading()
    } else {
        Column {
            if (paymentUiState.paymentResult != null) {
                val successful = paymentUiState.paymentResult.status
                if (successful) {
                    Results(userMessage = "Thanks for your purchase.") {
                        OrderSummary(
                            order = order
                        )
                    }
                }
            } else {
                OrderElements(
                    order = order,
                    onPlaceOrder = onPlaceOrder,
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
fun OrderElements(
    order: Order,
    onPlaceOrder: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OrderSummary(
            order = order,
            modifier = modifier
        )
        StandardButton(
            text = stringResource(R.string.pay_order, order.summary.total.toString()),
            onClicked = onPlaceOrder
        )
    }
}

@Composable
fun OrderSummary(
    order: Order,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OrderInformation(
            order = order
        )
        SummaryCard(
            numberItems = order.summary.numberItems,
            totalItems = order.summary.totalItems,
            shippingCost = order.summary.shippingCost,
            taxCost = order.summary.taxCost,
            total = order.summary.total,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun PreviewPlaceOrderScreen() {
    OrderElements(
        order = PreviewData.order,
        onPlaceOrder = {}
    )
}

@Preview
@Composable
fun PreviewOrderInformation() {
    OrderSummary(
        order = PreviewData.order
    )
}