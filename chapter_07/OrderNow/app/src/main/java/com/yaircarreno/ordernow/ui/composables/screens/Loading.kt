package com.yaircarreno.ordernow.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.theme.lightGrayBackground
import com.yaircarreno.ordernow.ui.theme.orange

@Composable
fun Loading(

) {
    Column(
        Modifier.fillMaxSize().background(lightGrayBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = orange,
            strokeWidth = 5.dp
        )
    }
}

@Preview
@Composable
fun PreviewLoading() {
    Loading()
}