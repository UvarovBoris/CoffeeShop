package com.uvarov.coffeeshop.common.data

import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.data.product.ProductEntity
import com.uvarov.coffeeshop.common.data.product.ProductSizeEntity.Large
import com.uvarov.coffeeshop.common.data.product.ProductSizeEntity.Medium
import com.uvarov.coffeeshop.common.data.product.ProductSizeEntity.Small
import com.uvarov.coffeeshop.common.data.product.ProductVariantEntity

val testProducts = listOf(
    ProductEntity(
        id = 0,
        name = "Caffe Mocha",
        category = ProductCategory.Mocha,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(0, Small, 3.53f),
            ProductVariantEntity(1, Medium, 4.53f),
            ProductVariantEntity(2, Large, 5.53f)
        ),
        rating = 4.8f,
        description = "A rich and creamy coffee drink made with espresso, steamed milk, and chocolate syrup."
    ),
    ProductEntity(
        id = 1,
        name = "Flat White",
        category = ProductCategory.Latte,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(0, Small, 2.53f),
            ProductVariantEntity(1, Medium, 3.53f),
            ProductVariantEntity(2, Large, 4.53f)
        ),
        rating = 4.8f,
        description = "A velvety coffee drink made with espresso and microfoam milk, offering a perfect balance of strength and creaminess."
    ),
    ProductEntity(
        id = 2,
        name = "Mocha Fusi",
        category = ProductCategory.Mocha,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(0, Small, 6.53f),
            ProductVariantEntity(1, Medium, 7.53f),
            ProductVariantEntity(2, Large, 8.53f)
        ),
        rating = 4.6f,
        description = "A fusion of rich mocha flavors with a hint of spice, served with a creamy finish."
    ),
    ProductEntity(
        id = 3,
        name = "Caffe Panna",
        category = ProductCategory.Macchiato,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(0, Small, 4.53f),
            ProductVariantEntity(1, Medium, 5.53f),
            ProductVariantEntity(2, Large, 6.53f)
        ),
        rating = 4.6f,
        description = "A delightful macchiato topped with a dollop of whipped cream, offering a sweet and creamy coffee experience."
    ),
    ProductEntity(
        id = 4,
        name = "Irish Cream",
        category = ProductCategory.Cappuccino,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(0, Small, 3.53f),
            ProductVariantEntity(1, Medium, 4.53f),
            ProductVariantEntity(2, Large, 5.53f)
        ),
        rating = 4.8f,
        description = "A classic cappuccino with a rich mocha twist, combining espresso, steamed milk, and chocolate."
    ),
    ProductEntity(
        id = 5,
        name = "Caramel Dream",
        category = ProductCategory.Americano,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(0, Small, 2.53f),
            ProductVariantEntity(1, Medium, 3.53f),
            ProductVariantEntity(2, Large, 4.53f)
        ),
        rating = 4.8f,
        description = "A smooth and strong coffee drink made with espresso and steamed milk, perfect for coffee lovers."
    ),
    ProductEntity(
        id = 6,
        name = "Vanilla Cloud",
        category = ProductCategory.Macchiato,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(0, Small, 6.53f),
            ProductVariantEntity(1, Medium, 7.53f),
            ProductVariantEntity(2, Large, 8.53f)
        ),
        rating = 4.6f,
        description = "A unique macchiato with a mocha twist, blending espresso with chocolate and topped with foam."
    ),
    ProductEntity(
        id = 7,
        name = "Almond Joy",
        category = ProductCategory.Americano,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(0, Small, 4.53f),
            ProductVariantEntity(1, Medium, 5.53f),
            ProductVariantEntity(2, Large, 6.53f)
        ),
        rating = 4.6f,
        description = "A rich and creamy americano topped with whipped cream, offering a delightful coffee experience."
    ),
    ProductEntity(
        id = 8,
        name = "Hazelnut Heaven",
        category = ProductCategory.Cappuccino,
        image = R.drawable.product_0,
        variants = listOf(
            ProductVariantEntity(0, Small, 3.53f),
            ProductVariantEntity(1, Medium, 4.53f),
            ProductVariantEntity(2, Large, 5.53f)
        ),
        rating = 4.8f,
        description = "A rich and creamy cappuccino with a mocha flavor, combining espresso, steamed milk, and chocolate."
    ),
    ProductEntity(
        id = 9,
        name = "Cinnamon Swirl",
        category = ProductCategory.Macchiato,
        image = R.drawable.product_1,
        variants = listOf(
            ProductVariantEntity(0, Small, 2.53f),
            ProductVariantEntity(1, Medium, 3.53f),
            ProductVariantEntity(2, Large, 4.53f)
        ),
        rating = 4.8f,
        description = "A velvety flat white made with espresso and microfoam milk, offering a perfect balance of strength and creaminess."
    ),
    ProductEntity(
        id = 10,
        name = "Honey Latte",
        category = ProductCategory.Latte,
        image = R.drawable.product_2,
        variants = listOf(
            ProductVariantEntity(0, Small, 6.53f),
            ProductVariantEntity(1, Medium, 7.53f),
            ProductVariantEntity(2, Large, 8.53f)
        ),
        rating = 4.6f,
        description = "A fusion of rich mocha flavors with a hint of spice, served with a creamy finish."
    ),
    ProductEntity(
        id = 11,
        name = "Espresso Bliss",
        category = ProductCategory.Espresso,
        image = R.drawable.product_3,
        variants = listOf(
            ProductVariantEntity(0, Small, 4.53f),
            ProductVariantEntity(1, Medium, 5.53f),
            ProductVariantEntity(2, Large, 6.53f)
        ),
        rating = 4.6f,
        description = "A delightful espresso topped with a dollop of whipped cream, offering a sweet and creamy coffee experience."
    )
)