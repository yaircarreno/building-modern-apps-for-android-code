package com.yaircarreno.ordernow.ui.features.checkout.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.utils.StateVsEvent

@Composable
fun ContactInformation(
    nameStateVsEvent: StateVsEvent,
    phoneStateVsEvent: StateVsEvent,
    addressStateVsEvent: StateVsEvent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ContactField(
            label = "User name",
            value = nameStateVsEvent.value,
            onValueChange = nameStateVsEvent.onValueChange
        )
        Spacer(Modifier.padding(5.dp))
        ContactField(
            label = "Phone number",
            value = phoneStateVsEvent.value,
            onValueChange = phoneStateVsEvent.onValueChange
        )
        Spacer(Modifier.padding(5.dp))
        ContactField(
            label = "Address",
            value = addressStateVsEvent.value,
            onValueChange = addressStateVsEvent.onValueChange
        )
    }
}

@Composable
fun ContactField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun PreviewContactInformation(

) {
    ContactInformation(
        nameStateVsEvent = StateVsEvent(),
        phoneStateVsEvent = StateVsEvent(),
        addressStateVsEvent = StateVsEvent()
    )
}