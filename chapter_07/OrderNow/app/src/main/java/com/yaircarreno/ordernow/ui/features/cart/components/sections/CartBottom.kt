package com.yaircarreno.ordernow.ui.features.cart.components.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.ui.composables.buttons.StandardButton
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.ui.theme.white
import com.yaircarreno.ordernow.R.string as AppText

@Composable
fun CartBottom(
    checkoutSelected: () -> Unit,
    checkoutReady: Boolean
) {
    StandardButton(
        text = stringResource(id = AppText.checkout),
        onClicked = checkoutSelected,
        enabled = checkoutReady
    )
}

@Preview
@Composable
fun PreviewCartBottom() {
    CartBottom(
        checkoutSelected = {},
        checkoutReady = true
    )
}