package com.yaircarreno.ordernow.ui.features.home.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.ui.composables.images.mirroringIcon
import com.yaircarreno.ordernow.ui.theme.orange

@Composable
fun HomeSection(
    title: String,
    withArrow: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = orange,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            if (withArrow) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = mirroringIcon(
                            ltrIcon = Icons.Outlined.ArrowForward,
                            rtlIcon = Icons.Outlined.ArrowBack
                        ),
                        tint = orange,
                        contentDescription = null
                    )
                }
            }
        }
        content()
    }
}

@Preview
@Composable
fun HomeSectionWithoutArrowPreview() {
    HomeSection(title = "Categories", withArrow = false) {
        CategorySection(
            categories = PreviewData.categories(),
            categorySelected = {})
    }
}

@Preview
@Composable
fun HomeSectionWithArrowPreview() {
    HomeSection(title = "Recommended", withArrow = true) {
        ProductSection(
            products = PreviewData.products(),
            productSelected = {}
        )
    }
}