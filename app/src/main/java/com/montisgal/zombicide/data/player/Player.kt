package com.montisgal.zombicide.data.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "player_id")
    val playerId: Int = 0,

    @ColumnInfo(name = "name")
    val name: String
)
