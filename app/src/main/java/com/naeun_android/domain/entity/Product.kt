package com.naeun_android.domain.entity

data class Product(
    val productId: Int,
    val image: String,
    val brand: String,
    val name: String,
    val price: String,
    val reviewScore: Float,
    val reviewNumber: Int,
    val heart: Boolean?
)
