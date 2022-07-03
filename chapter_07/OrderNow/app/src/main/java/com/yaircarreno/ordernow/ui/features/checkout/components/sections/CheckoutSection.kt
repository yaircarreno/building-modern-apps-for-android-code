package com.yaircarreno.ordernow.ui.features.checkout.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.features.checkout.components.ContactInformation
import com.yaircarreno.ordernow.ui.features.checkout.components.PaymentInformation
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.ui.utils.StateVsEvent

@Composable
fun CheckoutSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = orange,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
        }
        content()
    }
}

@Preview
@Composable
fun PreviewContactInformation() {
    CheckoutSection(
        title = "Contact information"
    ) {
        ContactInformation(
            nameStateVsEvent = StateVsEvent(),
            phoneStateVsEvent = StateVsEvent(),
            addressStateVsEvent = StateVsEvent()
        )
    }
}

@Preview
@Composable
fun PreviewPaymentInformation() {
    CheckoutSection(
        title = "Payment information"
    ) {
        PaymentInformation(
            nameStateVsEvent = StateVsEvent(),
            numberStateVsEvent = StateVsEvent(),
            monthStateVsEvent = StateVsEvent(),
            yearStateVsEvent = StateVsEvent(),
            codeStateVsEvent = StateVsEvent(),
        )
    }
}