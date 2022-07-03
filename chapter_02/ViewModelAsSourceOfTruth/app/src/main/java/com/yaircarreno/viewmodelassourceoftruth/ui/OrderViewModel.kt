package com.yaircarreno.viewmodelassourceoftruth.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    // UI's states
    var name by mutableStateOf("")
        private set
    var phone by mutableStateOf("")
        private set

    //UI's Events
    fun onNameChange(): (String) -> Unit = {
        name = it
    }

    fun onPhoneChange(): (String) -> Unit = {
        phone = it
    }

    fun payOrder(): () -> Unit = {
        println("Order generated for $name and phone $phone")
    }
}