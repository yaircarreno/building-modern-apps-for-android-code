package com.yaircarreno.ordernow.ui.composables.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.ui.theme.titleTextColor
import com.yaircarreno.ordernow.ui.theme.white

@Composable
fun ProductItem(
    product: Product,
    productSelected: (Product) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { productSelected(product) }
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(120.dp)
                .height(120.dp)
                .fillMaxWidth(0.2f)
                .clip(RoundedCornerShape(20.dp))
                .background(white),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.urlImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder_product),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {

            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = titleTextColor
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            orange,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("$ " + product.price)
                    }
                },
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier,
                fontSize = 16.sp
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp)
                .align(Alignment.Top)
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = orange
            )
        }
    }
}

@Preview
@Composable
fun PreviewProductItem() {
    ProductItem(
        product = PreviewData.product,
        productSelected = {}
    )
}