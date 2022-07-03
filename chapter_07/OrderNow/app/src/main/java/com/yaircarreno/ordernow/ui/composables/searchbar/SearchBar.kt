package com.yaircarreno.ordernow.ui.composables.searchbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yaircarreno.ordernow.ui.theme.lightBlack
import com.yaircarreno.ordernow.ui.theme.lightGrey
import com.yaircarreno.ordernow.ui.theme.lightbox

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var search by remember { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = lightbox,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        value = search,
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        onValueChange = { search = it },
        placeholder = {
            Text(
                text = "Search Products",
                color = lightGrey
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                tint = lightBlack
            )
        }
    )
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar()
}