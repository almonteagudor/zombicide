package com.montisgal.zombicide.data.character

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.montisgal.zombicide.data.product.Product

data class Character(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val product: Product,
)