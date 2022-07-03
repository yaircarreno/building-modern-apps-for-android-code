package com.yaircarreno.ordernow.common.previews

import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.order.Order
import com.yaircarreno.ordernow.domain.models.Product
import com.yaircarreno.ordernow.domain.models.order.CardInformation
import com.yaircarreno.ordernow.domain.models.order.SummaryTotals

class PreviewData {

    companion object PreviewList {

        val category = Category(
            "1",
            "Clothes",
            "Clothes",
            "category_1.png"
        )

        private val category_2 = Category(
            "2",
            "Clothes",
            "Clothes",
            "category_1.png"
        )

        private val category_3 = Category(
            "3",
            "Clothes",
            "Clothes",
            "category_1.png"
        )

        val product = Product(
            "1",
            "Neck T-Shirt",
            "Price and other details may vary based on product size and color.",
            "product_1.png",
            16.0,
            category
        )

        private val product_2 = Product(
            "2",
            "Neck T-Shirt",
            "Price and other details may vary based on product size and color.",
            "product_1.png",
            16.0,
            category_2
        )
        val cart_product_1 = CartItem(
            3,
            product
        )
        val cart_product_2 = CartItem(
            2,
            product_2
        )
        val cardInformation = CardInformation(
            name = "Yair Carreno",
            number = "1234-1111-3333-4444",
            month = "11",
            year = "12",
            code = "123")
        val summary = SummaryTotals(
            numberItems = 3,
            totalItems = 12.00,
            shippingCost = 10.00,
            taxCost = 2.00,
            total = 24.00
        )
        val order = Order(
            name = "Yair Carreno",
            phone = "3118340212",
            address = "Cll 39 # 45-32",
            cardInformation = cardInformation,
            summary = summary
        )

        fun products(): List<Product> = listOf(product, product_2)
        fun categories(): List<Category> = listOf(category, category_2, category_3)
        fun cartProducts(): List<CartItem> = listOf(cart_product_1, cart_product_2)
    }
}