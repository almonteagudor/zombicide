package com.montisgal.zombicide.data.player_saved_game

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "player_saved_game", primaryKeys = ["player_id", "saved_game_id"])
data class PlayerSavedGameCrossRef(
    @ColumnInfo(name = "player_id")
    val playerId: Int,

    @ColumnInfo(name = "saved_game_id")
    val savedGameId: Int,
)