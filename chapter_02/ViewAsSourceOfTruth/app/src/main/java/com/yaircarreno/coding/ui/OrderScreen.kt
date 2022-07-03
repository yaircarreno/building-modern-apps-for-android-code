package com.yaircarreno.coding.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.coding.ui.theme.ViewAsSourceOfTruthTheme

@Composable
fun OrderScreen() {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    ContactInformation(
        name = name,
        onNameChange = { name = it },
        phone = phone,
        onPhoneChange = { phone = it }
    )
}

@Composable
fun ContactInformation(
    name: String,
    onNameChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
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
            onClick = {
                println("Order generated for $name and phone $phone")
            },
            enabled = name.length > 3 && phone.length > 4
        ) {
            Text("Pay order")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewAsSourceOfTruthTheme {
        OrderScreen()
    }
}