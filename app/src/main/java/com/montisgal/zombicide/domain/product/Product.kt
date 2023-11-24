package com.montisgal.zombicide.domain.product

import androidx.annotation.StringRes
import com.montisgal.zombicide.R

enum class Product(val id: Int, @StringRes val title: Int) {
    Core(
        id = 1,
        title = R.string.product_title_core
    ),
    Washington(
        id = 2,
        title = R.string.product_title_washington
    ),
    Hendrix(
        id = 3,
        title = R.string.product_title_hendrix
    ),
    PaintSet(
        id = 4,
        title = R.string.product_title_paint_set
    );

    companion object {
        fun fromId(id: Int): Product? {
            return Product.values().find { it.id == id }
        }
    }
}