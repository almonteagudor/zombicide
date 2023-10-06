package com.montisgal.zombicide.data.product

import androidx.annotation.StringRes
import com.montisgal.zombicide.R

enum class Product(@StringRes val title: Int) {
    Core(title = R.string.product_title_core),
    Washington(title = R.string.product_title_washington),
    Hendrix(title = R.string.product_title_hendrix),
    PaintSet(title = R.string.product_title_paint_set),
}