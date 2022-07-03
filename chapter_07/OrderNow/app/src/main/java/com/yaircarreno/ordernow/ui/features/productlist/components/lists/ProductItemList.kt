package com.yaircarreno.ordernow.ui.features.productlist.components.lists

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.ui.composables.items.ProductItem

@Composable
fun ProductItemList(
    products: List<Product>,
    productSelected: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(products, key = { it.id }) { product ->
            ProductItem(product, productSelected)
        }
    }
}

@Preview
@Composable
fun PreviewProductListScreen() {
    ProductItemList(
        products = PreviewData.products(),
        productSelected = {}
    )
}