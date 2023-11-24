package com.montisgal.zombicide.domain.character

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.montisgal.zombicide.domain.product.Product

data class Character(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val product: Product,
)