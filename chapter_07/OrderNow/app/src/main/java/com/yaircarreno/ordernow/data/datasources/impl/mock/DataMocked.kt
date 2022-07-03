package com.yaircarreno.ordernow.data.datasources.impl.mock

import com.yaircarreno.ordernow.domain.models.CartItem
import com.yaircarreno.ordernow.domain.models.Category
import com.yaircarreno.ordernow.domain.models.Product

class DataMocked {

    companion object Data {

        // Categories data mocked
        val category1 = Category(
            "100",
            "Clothes",
            "Clothes",
            "https://storage.googleapis.com/order_now_store_bucket/category-list/category_1.png"
        )
        val category2 = Category(
            "101",
            "Technology",
            "Technology",
            "https://storage.googleapis.com/order_now_store_bucket/category-list/category_2.png"
        )
        val category3 = Category(
            "102",
            "Furniture",
            "Furniture",
            "https://storage.googleapis.com/order_now_store_bucket/category-list/category_3.png"
        )
        val category4 = Category(
            "103",
            "Accessories",
            "Accessories",
            "https://storage.googleapis.com/order_now_store_bucket/category-list/category_4.png"
        )

        // Products data mocked
        val product1 = Product(
            "11",
            "Neck T-Shirt",
            "Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_1.png",
            16.0,
            category1
        )
        val product2 = Product(
            "21",
            "iPhone Black",
            "Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_2.png",
            200.5,
            category2
        )
        val product3 = Product(
            "31",
            "iWatch SE",
            "Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_3.png",
            130.5,
            category4
        )
        val product4 = Product(
            "41",
            "Gaming Headset",
            "Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_4.png",
            12.5,
            category2
        )
        val product5 = Product(
            "51",
            "Padded Jacket",
            "Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_5.png",
            78.0,
            category1
        )
        val product6 = Product(
            "61",
            "Solid Backpack",
            "Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_6.png",
            27.7,
            category4
        )
        val product7 = Product(
            "71",
            "Fit Sport Shorts",
            "Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_7.png",
            35.0,
            category1
        )
        val product8 = Product(
            "81",
            "Interior Chair",
            "Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_8.png",
            30.5,
            category3
        )
        val product9 = Product(
            "91",
            "AirPods Apple",
            "3 Generation. Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_9.png",
            200.5,
            category2
        )
        val product10 = Product(
            "101",
            "Case for MacBook Pro",
            "13 HardShell. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_10.png",
            12.5,
            category4
        )
        val product11 = Product(
            "201",
            "Case for MacBook Pro",
            "13 HardShell. Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_11.png",
            100.5,
            category2
        )
        val product12 = Product(
            "301",
            "Thermostat",
            "Digital Ecologic. Personal setup available. Buy now with free delivery.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_12.png",
            50.5,
            category3
        )
        val product13 = Product(
            "401",
            "Top Sneakers",
            "Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_13.png",
            20.9,
            category1
        )
        val product14 = Product(
            "501",
            "Jacket Men",
            "Brown Slit. Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_14.png",
            30.2,
            category1
        )
        val product15 = Product(
            "601",
            "H&M Polo Shirt",
            "Slim Fit. Price and other details may vary based on product size and color.",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_15.png",
            40.3,
            category1
        )
        // CartItem data mocked
        val cartItem1 = CartItem(
            1,
            product1
        )
        val cartItem2 = CartItem(
            3,
            product2
        )
        val cartItem3 = CartItem(
            2,
            product3
        )
    }
}