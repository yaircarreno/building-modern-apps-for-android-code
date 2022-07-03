package com.yaircarreno.ordernow.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.R.string as AppText

@Composable
fun HomeScreen(
    goToProductList: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = AppText.home),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.padding(50.dp))
        Button(
            onClick = goToProductList,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = orange,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(id = AppText.to_product_list_screen))
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(goToProductList = {})
}