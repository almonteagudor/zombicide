package com.montisgal.zombicide.domain.character

import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.product.Product

class CharacterRepository {
    fun get(id: Int): Character? {
        return characters.find { it.id == id }
    }

    fun getByProducts(products: Array<Product> = Product.values()): List<Character> {
        return characters.filter { products.contains(it.product) }
    }

    private val characters: List<Character> = listOf(
        Character(
            id = 1,
            name = R.string.character_name_amy,
            image = R.drawable.character_image_amy,
            product = Product.Core
        ),
        Character(
            id = 2,
            name = R.string.character_name_angelo,
            image = R.drawable.character_image_angelo,
            product = Product.Washington
        ),
        Character(
            id = 3,
            name = R.string.character_name_anton,
            image = R.drawable.character_image_anton,
            product = Product.Washington
        ),
        Character(
            id = 4,
            name = R.string.character_name_ashley,
            image = R.drawable.character_image_ashley,
            product = Product.Washington
        ),
        Character(
            id = 5,
            name = R.string.character_name_bunny_g,
            image = R.drawable.character_image_bunny_g,
            product = Product.Core
        ),
        Character(
            id = 6,
            name = R.string.character_name_doug,
            image = R.drawable.character_image_doug,
            product = Product.Core
        ),
        Character(
            id = 7,
            name = R.string.character_name_elle,
            image = R.drawable.character_image_elle,
            product = Product.Core
        ),
        Character(
            id = 8,
            name = R.string.character_name_javier,
            image = R.drawable.character_image_javier,
            product = Product.Hendrix
        ),
        Character(
            id = 9,
            name = R.string.character_name_josh,
            image = R.drawable.character_image_josh,
            product = Product.Core
        ),
        Character(
            id = 10,
            name = R.string.character_name_justin,
            image = R.drawable.character_image_justin,
            product = Product.Washington
        ),
        Character(
            id = 11,
            name = R.string.character_name_karl,
            image = R.drawable.character_image_karl,
            product = Product.Hendrix
        ),
        Character(
            id = 12,
            name = R.string.character_name_lili,
            image = R.drawable.character_image_lili,
            product = Product.Core
        ),
        Character(
            id = 13,
            name = R.string.character_name_lou,
            image = R.drawable.character_image_lou,
            product = Product.Core
        ),
        Character(
            id = 14,
            name = R.string.character_name_marian,
            image = R.drawable.character_image_marian,
            product = Product.Hendrix
        ),
        Character(
            id = 15,
            name = R.string.character_name_michelle,
            image = R.drawable.character_image_michelle,
            product = Product.Hendrix
        ),
        Character(
            id = 16,
            name = R.string.character_name_mindy,
            image = R.drawable.character_image_mindy,
            product = Product.Washington
        ),
        Character(
            id = 17,
            name = R.string.character_name_ned,
            image = R.drawable.character_image_ned,
            product = Product.Core
        ),
        Character(
            id = 18,
            name = R.string.character_name_odin,
            image = R.drawable.character_image_odin,
            product = Product.Core
        ),
        Character(
            id = 19,
            name = R.string.character_name_ostara,
            image = R.drawable.character_image_ostara,
            product = Product.Core
        ),
        Character(
            id = 20,
            name = R.string.character_name_phil,
            image = R.drawable.character_image_phil,
            product = Product.PaintSet
        ),
        Character(
            id = 21,
            name = R.string.character_name_riley,
            image = R.drawable.character_image_riley,
            product = Product.Hendrix
        ),
        Character(
            id = 22,
            name = R.string.character_name_tess,
            image = R.drawable.character_image_tess,
            product = Product.Washington
        ),
        Character(
            id = 23,
            name = R.string.character_name_tiger_sam,
            image = R.drawable.character_image_tiger_sam,
            product = Product.Core
        ),
        Character(
            id = 24,
            name = R.string.character_name_wanda,
            image = R.drawable.character_image_wanda,
            product = Product.Core
        ),
        Character(
            id = 25,
            name = R.string.character_name_wayne,
            image = R.drawable.character_image_wayne,
            product = Product.Hendrix
        ),
    )
}