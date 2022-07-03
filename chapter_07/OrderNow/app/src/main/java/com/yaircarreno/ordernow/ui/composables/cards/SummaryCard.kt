package com.yaircarreno.ordernow.ui.composables.cards

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.composables.summary.Summary

@Composable
fun SummaryCard(
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 0.dp,
        modifier = modifier
    ) {
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
fun PreviewSummaryCard() {
    SummaryCard(
        numberItems = 3,
        totalItems = 12.00,
        shippingCost = 10.00,
        taxCost = 2.00,
        total = 24.00
    )
}