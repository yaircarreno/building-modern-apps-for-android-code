package com.yaircarreno.ordernow.ui.utils

data class StateVsEvent(
    val value: String = "",
    val onValueChange: (String) -> Unit = {}
)