package com.yaircarreno.ordernow.ui.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.ui.features.placeorder.OrderSummary
import com.yaircarreno.ordernow.ui.theme.lightGrayBackground
import com.yaircarreno.ordernow.ui.theme.orange

@Composable
fun Results(
    userMessage: String,
    content: @Composable () -> Unit
) {
    Column(
        Modifier
            .background(lightGrayBackground)
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_check_circle_24),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(color = orange)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = userMessage,
            style = MaterialTheme.typography.subtitle1,
            color = orange
        )
        Spacer(modifier = Modifier.height(20.dp))
        content()
    }
}

@Preview
@Composable
fun PreviewResults() {
    Results(userMessage = "Thanks for your purchase."){
        OrderSummary(
            order = PreviewData.order
        )
    }
}