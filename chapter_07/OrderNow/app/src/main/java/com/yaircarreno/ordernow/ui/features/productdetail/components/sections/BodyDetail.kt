package com.yaircarreno.ordernow.ui.features.productdetail.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yaircarreno.ordernow.R
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.ui.composables.quantifier.Quantity
import com.yaircarreno.ordernow.ui.theme.lightGrayBackground
import com.yaircarreno.ordernow.ui.theme.lightGrey
import com.yaircarreno.ordernow.ui.theme.orange
import com.yaircarreno.ordernow.ui.theme.white
import com.yaircarreno.ordernow.R.string as AppText

@Composable
fun BodyDetail(
    product: Product,
    addToCart: (Int) -> Unit,
    showAlert: Boolean,
    onGoToCart: () -> Unit,
    onPopupDismissed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {

            val (ProductImage, BuyForm) = createRefs()
            val (count, updateCount) = remember { mutableStateOf(1) }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(280.dp)
                    .constrainAs(ProductImage) {
                        top.linkTo(BuyForm.top)
                        bottom.linkTo(BuyForm.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                HeaderView(product)
            }
            Surface(
                color = lightGrayBackground,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
                    .constrainAs(BuyForm) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    HeaderSection(product)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Divider(color = lightGrey, thickness = 2.dp)
                    Quantity(
                        count = count,
                        decreaseItemCount = { if (count > 1) updateCount(count - 1) },
                        increaseItemCount = { updateCount(count + 1) },
                        price = product.price * count
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    BottomSection(onBuyClicked = { addToCart(count) })
                }
            }
        }
    }
    if (showAlert) {
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            title = {
                Text(text = stringResource(AppText.title_detail_alert))
            },
            text = {
                Text(text = stringResource(AppText.text_detail_alert))
            },
            confirmButton = {
                Button(
                    onClick = onGoToCart,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = orange
                    )
                ) {
                    Text(
                        text = stringResource(AppText.go_to_cart),
                        color = white
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = onPopupDismissed,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = orange
                    )
                ) {
                    Text(
                        text = stringResource(AppText.continue_shopping),
                        color = white
                    )
                }
            })
    }
}

@Composable
fun HeaderView(product: Product) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(white)
            .padding(top = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.urlImage)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                placeholder = painterResource(R.drawable.placeholder_product),
                contentDescription = "",
                modifier = Modifier.size(230.dp),
            )
        }
    }
}

@Preview
@Composable
fun PreviewBodyDetail() {
    BodyDetail(
        product = PreviewData.product,
        addToCart = {},
        showAlert = false,
        onGoToCart = {},
        onPopupDismissed = {}
    )
}




