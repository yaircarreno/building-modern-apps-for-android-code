package com.yaircarreno.ordernow.ui.composables.quantifier

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.ui.theme.lightBlack
import com.yaircarreno.ordernow.ui.theme.orange

@Composable
fun Quantity(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
    price: Double
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        QuantitySelector(
            count = count,
            decreaseItemCount = decreaseItemCount,
            increaseItemCount = increaseItemCount
        )

        PriceView(price)
    }
}

@Composable
fun QuantitySelector(
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = decreaseItemCount) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null,
                    tint = lightBlack
                )
            }
            Text(
                text = "$count",
                color = lightBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            IconButton(onClick = increaseItemCount) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    tint = lightBlack
                )
            }
        }
    }
}


@Composable
fun PriceView(price: Double) {
    Text(
        text = "$ $price",
        color = orange,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun PreviewQuantity() {
    Quantity(1, {}, {}, PreviewData.product.price)
}

@Preview
@Composable
fun PreviewQuantitySelector() {
    QuantitySelector(1, {}, {})
}

@Preview
@Composable
fun PreviewPriceView() {
    PriceView(price = PreviewData.product.price)
}