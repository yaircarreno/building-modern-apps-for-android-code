package com.yaircarreno.viewmodelassourceoftruth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.yaircarreno.viewmodelassourceoftruth.ui.OrderScreen
import com.yaircarreno.viewmodelassourceoftruth.ui.theme.ViewModelAsSourceOfTruthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelAsSourceOfTruthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OrderScreen()
                }
            }
        }
    }
}