package com.yaircarreno.initialskeleton.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yaircarreno.initialskeleton.ui.patterns.OrderNowBottomBar
import com.yaircarreno.initialskeleton.ui.patterns.OrderNowTopBar
import com.yaircarreno.initialskeleton.ui.theme.InitialSkeletonTheme

@Composable
fun OrderNowScreen() {
    InitialSkeletonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = { OrderNowTopBar() },
                bottomBar = { OrderNowBottomBar() }
            ) { innerPaddingModifier ->
                println(innerPaddingModifier)
            }
        }
    }
}