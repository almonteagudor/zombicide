package com.montisgal.zombicide.data

import android.content.Context
import com.montisgal.zombicide.data.player.PlayerMapper
import com.montisgal.zombicide.data.saved_game.SavedGameMapper

interface ZombicideContainer {
    val savedGameRepository: com.montisgal.zombicide.domain.saved_game.SavedGameRepository
    val playerRepository: com.montisgal.zombicide.domain.player.PlayerRepository
}

class ZombicideDataContainer(private val context: Context) : ZombicideContainer {
    override val savedGameRepository: com.montisgal.zombicide.domain.saved_game.SavedGameRepository by lazy {
        com.montisgal.zombicide.data.saved_game.SavedGameRepository(ZombicideDatabase.getDatabase(context).savedGameDao(), SavedGameMapper())
    }

    override val playerRepository: com.montisgal.zombicide.domain.player.PlayerRepository by lazy {
        com.montisgal.zombicide.data.player.PlayerRepository(ZombicideDatabase.getDatabase(context).playerDao(), PlayerMapper())
    }
}