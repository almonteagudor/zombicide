package com.montisgal.zombicide.data.campaign

import androidx.annotation.StringRes
import com.montisgal.zombicide.R
import com.montisgal.zombicide.data.product.Product

enum class Campaign(@StringRes val title: Int, val product: Product) {
    Washington(title = R.string.campaign_title_washington, product = Product.Washington),
    Hendrix(title = R.string.campaign_title_hendrix, product = Product.Hendrix),
}