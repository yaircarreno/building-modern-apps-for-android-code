package com.yaircarreno.ordernow.ui.composables.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.ui.composables.quantifier.Quantity
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.ui.theme.titleTextColor

@Composable
fun CartViewItem(
    cartItem: CartItem,
    removeItem: (CartItem) -> Unit,
    count: Int,
    decreaseItemCount: () -> Unit,
    increaseItemCount: () -> Unit,
    backgroundColor: Color = Color.Transparent
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.2f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(cartItem.product.urlImage)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder_product),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = cartItem.product.name,
                    fontSize = 18.sp,
                    color = titleTextColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    titleTextColor
                                )
                            ) {
                                append("$ " + cartItem.product.price + "/per item")
                            }
                        },
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier,
                        fontSize = 16.sp

                    )
                    Box(
                        modifier = Modifier
                            .size(35.dp, 35.dp)
                            .clip(CircleShape)
                            .background(backgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { removeItem(cartItem) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                tint = orange
                            )
                        }
                    }
                }
            }
        }
        Quantity(
            count = count,
            decreaseItemCount = decreaseItemCount,
            increaseItemCount = increaseItemCount,
            price = cartItem.product.price * cartItem.quantity
        )
    }
}

@Preview
@Composable
fun PreviewCartViewItem() {
    CartViewItem(
        cartItem = PreviewData.cart_product_1,
        removeItem = {},
        count = 1,
        decreaseItemCount = {},
        increaseItemCount = {}
    )
}