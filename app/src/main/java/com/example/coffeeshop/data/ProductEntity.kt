package com.example.coffeeshop.data

import androidx.annotation.DrawableRes
import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.domain.ProductVariant
import com.example.coffeeshop.domain.ProductSize

data class ProductEntity(
    val id: Int,
    val name: String,
    val category: Category,
    @DrawableRes val image: Int,
    val variants: List<ProductVariantEntity>,
    val rating: Float,
)

data class ProductVariantEntity(
    val size: ProductSizeEntity,
    val price: Float,
)

fun ProductVariantEntity.toDomain(): ProductVariant {
    return ProductVariant(
        size = size.toDomain(),
        price = price
    )
}

enum class ProductSizeEntity {
    Small,
    Medium,
    Large
}

fun ProductSizeEntity.toDomain(): ProductSize {
    return when (this) {
        ProductSizeEntity.Small -> ProductSize.Small
        ProductSizeEntity.Medium -> ProductSize.Medium
        ProductSizeEntity.Large -> ProductSize.Large
    }
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        category = category,
        image = image,
        variants = variants.map { it.toDomain() },
        rating = rating
    )
}