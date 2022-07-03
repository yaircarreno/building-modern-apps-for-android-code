package com.yaircarreno.viewmodelassourceoftruth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yaircarreno.viewmodelassourceoftruth.ui.theme.ViewModelAsSourceOfTruthTheme

@Composable
fun OrderScreen(viewModel: OrderViewModel = viewModel()) {

    ContactInformation(
        name = viewModel.name,
        onNameChange = viewModel.onNameChange(),
        phone = viewModel.phone,
        onPhoneChange = viewModel.onPhoneChange(),
        payOrder = viewModel.payOrder()
    )
}

@Composable
fun ContactInformation(
    name: String,
    onNameChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit,
    payOrder: () -> Unit
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
            enabled = name.length > 3 && phone.length > 4
        ) {
            Text("Pay order")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewModelAsSourceOfTruthTheme {
        OrderScreen()
    }
}