package com.montisgal.zombicide.domain.character

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.product.Product

enum class Character(
    val id: Int,
    @StringRes val characterName: Int,
    @DrawableRes val image: Int,
    val product: Product,
) {

    Amy(
        id = 1,
        characterName = R.string.character_name_amy,
        image = R.drawable.character_image_amy,
        product = Product.Core
    ),
    Angelo(
        id = 2,
        characterName = R.string.character_name_angelo,
        image = R.drawable.character_image_angelo,
        product = Product.Washington
    ),
    Anton(
        id = 3,
        characterName = R.string.character_name_anton,
        image = R.drawable.character_image_anton,
        product = Product.Washington
    ),
    Ashley(
        id = 4,
        characterName = R.string.character_name_ashley,
        image = R.drawable.character_image_ashley,
        product = Product.Washington
    ),
    BunnyG(
        id = 5,
        characterName = R.string.character_name_bunny_g,
        image = R.drawable.character_image_bunny_g,
        product = Product.Core
    ),
    Doug(
        id = 6,
        characterName = R.string.character_name_doug,
        image = R.drawable.character_image_doug,
        product = Product.Core
    ),
    Elle(
        id = 7,
        characterName = R.string.character_name_elle,
        image = R.drawable.character_image_elle,
        product = Product.Core
    ),
    Javier(
        id = 8,
        characterName = R.string.character_name_javier,
        image = R.drawable.character_image_javier,
        product = Product.Hendrix
    ),
    Josh(
        id = 9,
        characterName = R.string.character_name_josh,
        image = R.drawable.character_image_josh,
        product = Product.Core
    ),
    Justin(
        id = 10,
        characterName = R.string.character_name_justin,
        image = R.drawable.character_image_justin,
        product = Product.Washington
    ),
    Karl(
        id = 11,
        characterName = R.string.character_name_karl,
        image = R.drawable.character_image_karl,
        product = Product.Hendrix
    ),
    Lili(
        id = 12,
        characterName = R.string.character_name_lili,
        image = R.drawable.character_image_lili,
        product = Product.Core
    ),
    Lou(
        id = 13,
        characterName = R.string.character_name_lou,
        image = R.drawable.character_image_lou,
        product = Product.Core
    ),
    Marian(
        id = 14,
        characterName = R.string.character_name_marian,
        image = R.drawable.character_image_marian,
        product = Product.Hendrix
    ),
    Michelle(
        id = 15,
        characterName = R.string.character_name_michelle,
        image = R.drawable.character_image_michelle,
        product = Product.Hendrix
    ),
    Mindy(
        id = 16,
        characterName = R.string.character_name_mindy,
        image = R.drawable.character_image_mindy,
        product = Product.Washington
    ),
    Ned(
        id = 17,
        characterName = R.string.character_name_ned,
        image = R.drawable.character_image_ned,
        product = Product.Core
    ),
    Odin(
        id = 18,
        characterName = R.string.character_name_odin,
        image = R.drawable.character_image_odin,
        product = Product.Core
    ),
    Ostara(
        id = 19,
        characterName = R.string.character_name_ostara,
        image = R.drawable.character_image_ostara,
        product = Product.Core
    ),
    Phil(
        id = 20,
        characterName = R.string.character_name_phil,
        image = R.drawable.character_image_phil,
        product = Product.PaintSet
    ),
    Riley(
        id = 21,
        characterName = R.string.character_name_riley,
        image = R.drawable.character_image_riley,
        product = Product.Hendrix
    ),
    Tess(
        id = 22,
        characterName = R.string.character_name_tess,
        image = R.drawable.character_image_tess,
        product = Product.Washington
    ),
    TigerSam(
        id = 23,
        characterName = R.string.character_name_tiger_sam,
        image = R.drawable.character_image_tiger_sam,
        product = Product.Core
    ),
    Wanda(
        id = 24,
        characterName = R.string.character_name_wanda,
        image = R.drawable.character_image_wanda,
        product = Product.Core
    ),
    Wayne(
        id = 25,
        characterName = R.string.character_name_wayne,
        image = R.drawable.character_image_wayne,
        product = Product.Hendrix
    );

    companion object {
        fun fromId(id: Int): Character? {
            return Character.values().find { it.id == id }
        }

        fun fromProducts(products: Array<Product> = Product.values()): List<Character> {
            return Character.values().filter { products.contains(it.product) }
        }
    }
}