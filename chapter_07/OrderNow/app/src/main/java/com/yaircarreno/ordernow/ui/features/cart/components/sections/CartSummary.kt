package com.yaircarreno.ordernow.ui.features.cart.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.composables.summary.Summary
import com.yaircarreno.ordernow.ui.theme.*

@Composable
fun CartSummary(
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(color = lightGrey, thickness = 2.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Summary(
            numberItems = numberItems,
            totalItems = totalItems,
            shippingCost = shippingCost,
            taxCost = taxCost,
            total = total
        )
    }
}

@Preview
@Composable
fun PreviewCartSummary() {
    CartSummary(
        numberItems = 3,
        totalItems = 12.00,
        shippingCost = 10.00,
        taxCost = 2.00,
        total = 24.00
    )
}