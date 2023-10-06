package com.montisgal.zombicide.data

import android.content.Context
import com.montisgal.zombicide.data.saved_game.OfflineSavedGameRepository
import com.montisgal.zombicide.data.saved_game.SavedGameRepository

interface ZombicideContainer {
    val savedGameRepository: SavedGameRepository
}

class ZombicideDataContainer(private val context: Context) : ZombicideContainer {
    override val savedGameRepository: SavedGameRepository by lazy {
        OfflineSavedGameRepository(ZombicideDatabase.getDatabase(context).savedGameDao())
    }
}