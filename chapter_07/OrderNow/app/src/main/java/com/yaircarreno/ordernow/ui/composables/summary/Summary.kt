package com.yaircarreno.ordernow.ui.composables.summary

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yaircarreno.ordernow.ui.theme.lightBlack
import com.yaircarreno.ordernow.ui.theme.titleTextColor

@Composable
fun Summary(
    numberItems: Int,
    totalItems: Double,
    shippingCost: Double,
    taxCost: Double,
    total: Double
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        SummaryText(
            label = "Items($numberItems):",
            value = "$ $totalItems"
        )
        SummaryText(
            label = "Shipping:",
            value = "$ $shippingCost"
        )
        SummaryText(
            label = "Tax:",
            value = "$ $taxCost"
        )
        SummaryText(
            label = "Total:",
            value = "$ $total",
            fontSizeLabel = 16.sp,
            fontSizeValue = 18.sp
        )
    }
}

@Composable
fun SummaryText(
    label: String,
    value: String,
    fontSizeLabel: TextUnit = 14.sp,
    fontSizeValue: TextUnit = 16.sp,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = fontSizeLabel,
            color = lightBlack
        )

        Text(
            text = value,
            fontSize = fontSizeValue,
            color = titleTextColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PreviewSummary() {
    Summary(
        numberItems = 3,
        totalItems = 12.00,
        shippingCost = 10.00,
        taxCost = 2.00,
        total = 24.00
    )
}