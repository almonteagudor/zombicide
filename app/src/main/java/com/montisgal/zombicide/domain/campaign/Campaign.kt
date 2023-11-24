package com.montisgal.zombicide.domain.campaign

import androidx.annotation.StringRes
import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.product.Product

enum class Campaign(val id: Int, @StringRes val title: Int, val product: Product) {
    Washington(id = 1, title = R.string.campaign_title_washington, product = Product.Washington),
    Hendrix(id = 2, title = R.string.campaign_title_hendrix, product = Product.Hendrix);

    companion object {
        fun fromId(id: Int): Campaign? {
            return values().find { it.id == id }
        }
    }
}