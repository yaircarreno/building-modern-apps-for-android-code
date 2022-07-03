package com.yaircarreno.initialskeleton.ui.patterns

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.yaircarreno.initialskeleton.R.string as AppString

@Composable
fun OrderNowTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = AppString.app_name),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    )
}