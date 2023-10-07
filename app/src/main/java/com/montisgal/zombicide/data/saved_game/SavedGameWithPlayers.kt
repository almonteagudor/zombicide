package com.montisgal.zombicide.data.saved_game

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.montisgal.zombicide.data.player.Player
import com.montisgal.zombicide.data.player_saved_game.PlayerSavedGameCrossRef

data class SavedGameWithPlayers(
    @Embedded
    val savedGame: SavedGame,

    @Relation(
        parentColumn = "saved_game_id",
        entityColumn = "player_id",
        associateBy = Junction(PlayerSavedGameCrossRef::class),
    )
    val players: List<Player>
)