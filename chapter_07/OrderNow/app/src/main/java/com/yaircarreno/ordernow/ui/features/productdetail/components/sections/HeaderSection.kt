package com.yaircarreno.ordernow.ui.features.productdetail.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.ui.theme.lightBlack
import com.yaircarreno.ordernow.ui.theme.titleTextColor
import com.yaircarreno.ordernow.ui.theme.white

@Composable
fun HeaderSection(product: Product) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = white,
            modifier = Modifier
                .height(5.dp)
                .width(30.dp)
        )
    }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = product.category.name,
            fontSize = 16.sp,
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.name,
            fontSize = 24.sp,
            color = lightBlack,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        titleTextColor
                    )
                ) {
                    append("$ " + product.price + "/per item")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier,
            fontSize = 16.sp

        )
        Spacer(modifier = Modifier.height(4.dp))
        product.description?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = it,
                fontSize = 18.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewHeaderSection() {
    HeaderSection(product = PreviewData.product)
}