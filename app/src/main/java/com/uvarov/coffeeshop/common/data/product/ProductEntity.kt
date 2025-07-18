package com.uvarov.coffeeshop.common.data.product

import androidx.annotation.DrawableRes
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.domain.product.ProductSize
import com.uvarov.coffeeshop.common.domain.product.ProductVariant

data class ProductEntity(
    val id: Int,
    val name: String,
    val category: ProductCategory,
    @DrawableRes val image: Int,
    val variants: List<ProductVariantEntity>,
    val rating: Float,
    val description: String,
)

data class ProductVariantEntity(
    val id: Int,
    val size: ProductSizeEntity,
    val price: Float,
)

fun ProductVariantEntity.toDomain(): ProductVariant {
    return ProductVariant(
        id = id,
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
        rating = rating,
        description = description
    )
}