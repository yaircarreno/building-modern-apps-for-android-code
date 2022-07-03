package com.yaircarreno.ordernow.ui.features.checkout.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.ui.theme.lightBlack
import com.yaircarreno.ordernow.ui.utils.StateVsEvent

@Composable
fun PaymentInformation(
    nameStateVsEvent: StateVsEvent,
    numberStateVsEvent: StateVsEvent,
    monthStateVsEvent: StateVsEvent,
    yearStateVsEvent: StateVsEvent,
    codeStateVsEvent: StateVsEvent,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        CardField(
            label = "Name on card",
            value = nameStateVsEvent.value,
            onValueChange = nameStateVsEvent.onValueChange,
            idIcon = R.drawable.ic_baseline_person_24
        )
        Spacer(Modifier.padding(5.dp))
        CardField(
            label = "0000-0000-0000-0000",
            value = numberStateVsEvent.value,
            onValueChange = numberStateVsEvent.onValueChange,
            idIcon = R.drawable.ic_baseline_credit_card_24
        )
        Spacer(Modifier.padding(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DateCard(
                label = "MM",
                value = monthStateVsEvent.value,
                onValueChange = monthStateVsEvent.onValueChange,
                modifier = modifier.weight(0.3f)
            )
            DateCard(
                label = "YY",
                value = yearStateVsEvent.value,
                onValueChange = yearStateVsEvent.onValueChange,
                modifier = modifier.weight(0.3f)
            )
            DateCard(
                label = "CVV",
                value = codeStateVsEvent.value,
                onValueChange = codeStateVsEvent.onValueChange,
                modifier = modifier.weight(0.3f)
            )
        }
    }
}

@Composable
fun CardField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    idIcon: Int,
    modifier: Modifier = Modifier,
) {
    TextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = idIcon),
                contentDescription = null,
                tint = lightBlack
            )
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun DateCard(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
) {
    TextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewPaymentInformation(

) {
    PaymentInformation(
        nameStateVsEvent = StateVsEvent(),
        numberStateVsEvent = StateVsEvent(),
        monthStateVsEvent = StateVsEvent(),
        yearStateVsEvent = StateVsEvent(),
        codeStateVsEvent = StateVsEvent(),
    )
}