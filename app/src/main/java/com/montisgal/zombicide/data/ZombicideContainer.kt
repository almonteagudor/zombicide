package com.montisgal.zombicide.data

import android.content.Context
import com.montisgal.zombicide.data.player.OfflinePlayerRepository
import com.montisgal.zombicide.data.player.PlayerRepository
import com.montisgal.zombicide.data.saved_game.OfflineSavedGameRepository
import com.montisgal.zombicide.data.saved_game.SavedGameRepository

interface ZombicideContainer {
    val savedGameRepository: SavedGameRepository
    val playerRepository: PlayerRepository
}

class ZombicideDataContainer(private val context: Context) : ZombicideContainer {
    override val savedGameRepository: SavedGameRepository by lazy {
        OfflineSavedGameRepository(ZombicideDatabase.getDatabase(context).savedGameDao())
    }
    override val playerRepository: PlayerRepository by lazy {
        OfflinePlayerRepository(ZombicideDatabase.getDatabase(context).playerDao())
    }
}