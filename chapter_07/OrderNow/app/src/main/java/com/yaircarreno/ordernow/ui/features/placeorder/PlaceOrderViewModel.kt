package com.yaircarreno.ordernow.ui.features.placeorder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaircarreno.ordernow.common.previews.PreviewData
import com.yaircarreno.ordernow.domain.usecases.payment.PaymentUseCases
import com.yaircarreno.ordernow.ui.features.placeorder.states.PaymentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PlaceOrderViewModel @Inject constructor(
    private val paymentUseCases: PaymentUseCases,
) : ViewModel() {

    var paymentUiState by mutableStateOf(PaymentState())
        private set

    fun makePayment() {
        viewModelScope.launch {
            paymentUiState = paymentUiState.copy(isLoading = true)
            try {
                val paymentResult = paymentUseCases.doPayment
                    .doPayment(order = PreviewData.order)
                paymentUiState =
                    paymentUiState.copy(
                        isLoading = false,
                        paymentResult = paymentResult
                    )
                println(paymentResult)
            } catch (ioe: IOException) {
                paymentUiState = paymentUiState.copy(
                    isLoading = false,
                    errorMessage = "Error with the transaction"
                )
            }
        }
    }
}