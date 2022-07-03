package com.yaircarreno.groupingevents.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.dp
import com.yaircarreno.groupingevents.ui.theme.GroupingEventsTheme

@Composable
fun OrderScreen(viewModel: OrderViewModel = viewModel()) {

    ContactInformation(
        name = viewModel.formUiState.name,
        onNameChange = { viewModel.onFormEvent(FormUiEvent.OnNameChange(it)) },
        phone = viewModel.formUiState.phone,
        onPhoneChange = { viewModel.onFormEvent(FormUiEvent.OnPhoneChange(it)) },
        payOrder = { viewModel.onFormEvent(FormUiEvent.PayOrderClicked) },
        isValidPayOrder = viewModel.formUiState.successValidated
    )
}

@Composable
fun ContactInformation(
    name: String,
    onNameChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit,
    payOrder: () -> Unit,
    isValidPayOrder: Boolean
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = {
                Text("User name")
            },
            value = name,
            onValueChange = onNameChange
        )
        Spacer(Modifier.padding(5.dp))
        TextField(
            label = {
                Text("Phone number")
            },
            value = phone,
            onValueChange = onPhoneChange
        )
        Spacer(Modifier.padding(5.dp))
        Button(
            onClick = payOrder,
            enabled = isValidPayOrder
        ) {
            Text("Pay order")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GroupingEventsTheme {
        OrderScreen()
    }
}