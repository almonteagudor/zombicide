package com.montisgal.zombicide.data.player_saved_game

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.montisgal.zombicide.data.player.Player
import com.montisgal.zombicide.data.saved_game.SavedGame

@Entity(primaryKeys = ["player_id", "saved_game_id"], tableName = "player_saved_game" )
data class PlayerSavedGameCrossRef(
    @ColumnInfo(name = "player_id")
    val playerId: Int,

    @ColumnInfo(name = "saved_game_id")
    val savedGameId: Int,
)

data class SavedGameWithPlayers(
    @Embedded
    val savedGame:SavedGame,

    @Relation (
        parentColumn = "saved_game_id",
        entityColumn =  "player_id",
        associateBy = Junction( PlayerSavedGameCrossRef::class),
    )
    val players:List<Player>
)