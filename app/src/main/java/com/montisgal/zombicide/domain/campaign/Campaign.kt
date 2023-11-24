package com.montisgal.zombicide.domain.campaign

import androidx.annotation.StringRes
import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.product.Product

enum class Campaign(@StringRes val title: Int, val product: Product) {
    Washington(title = R.string.campaign_title_washington, product = Product.Washington),
    Hendrix(title = R.string.campaign_title_hendrix, product = Product.Hendrix);

    companion object {
        fun fromId(title: Int): Campaign? {
            return values().find { it.title == title }
        }
    }
}