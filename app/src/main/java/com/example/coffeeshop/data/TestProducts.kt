package com.example.coffeeshop.data

import com.example.coffeeshop.R
import com.example.coffeeshop.data.ProductSizeEntity.Large
import com.example.coffeeshop.data.ProductSizeEntity.Medium
import com.example.coffeeshop.data.ProductSizeEntity.Small

val testProducts = listOf(
    ProductEntity(
        id = 0,
        name = "Caffe Mocha",
        category = Category.Mocha,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(Small, 3.53f),
            ProductVariantEntity(Medium, 4.53f),
            ProductVariantEntity(Large, 5.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 1,
        name = "Flat White",
        category = Category.Latte,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(Small, 2.53f),
            ProductVariantEntity(Medium, 3.53f),
            ProductVariantEntity(Large, 4.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 2,
        name = "Mocha Fusi",
        category = Category.Mocha,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(Small, 6.53f),
            ProductVariantEntity(Medium, 7.53f),
            ProductVariantEntity(Large, 8.53f)
        ),
        rating = 4.6f
    ),
    ProductEntity(
        id = 3,
        name = "Caffe Panna",
        category = Category.Macchiato,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(Small, 4.53f),
            ProductVariantEntity(Medium, 5.53f),
            ProductVariantEntity(Large, 6.53f)
        ),
        rating = 4.6f
    ),
    ProductEntity(
        id = 4,
        name = "Caffe Mocha",
        category = Category.Cappuccino,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(Small, 3.53f),
            ProductVariantEntity(Medium, 4.53f),
            ProductVariantEntity(Large, 5.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 5,
        name = "Flat White",
        category = Category.Americano,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(Small, 2.53f),
            ProductVariantEntity(Medium, 3.53f),
            ProductVariantEntity(Large, 4.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 6,
        name = "Mocha Fusi",
        category = Category.Macchiato,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(Small, 6.53f),
            ProductVariantEntity(Medium, 7.53f),
            ProductVariantEntity(Large, 8.53f)
        ),
        rating = 4.6f
    ),
    ProductEntity(
        id = 7,
        name = "Caffe Panna",
        category = Category.Americano,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(Small, 4.53f),
            ProductVariantEntity(Medium, 5.53f),
            ProductVariantEntity(Large, 6.53f)
        ),
        rating = 4.6f
    ),
    ProductEntity(
        id = 8,
        name = "Caffe Mocha",
        category = Category.Cappuccino,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(Small, 3.53f),
            ProductVariantEntity(Medium, 4.53f),
            ProductVariantEntity(Large, 5.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 9,
        name = "Flat White",
        category = Category.Macchiato,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(Small, 2.53f),
            ProductVariantEntity(Medium, 3.53f),
            ProductVariantEntity(Large, 4.53f)
        ),
        rating = 4.8f
    ),
    ProductEntity(
        id = 10,
        name = "Mocha Fusi",
        category = Category.Latte,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(Small, 6.53f),
            ProductVariantEntity(Medium, 7.53f),
            ProductVariantEntity(Large, 8.53f)
        ),
        rating = 4.6f
    ),
    ProductEntity(
        id = 11,
        name = "Caffe Panna",
        category = Category.Espresso,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(Small, 4.53f),
            ProductVariantEntity(Medium, 5.53f),
            ProductVariantEntity(Large, 6.53f)
        ),
        rating = 4.6f
    )
)