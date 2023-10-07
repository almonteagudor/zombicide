package com.montisgal.zombicide.data.saved_game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.montisgal.zombicide.data.campaign.Campaign

@Entity(tableName = "saved_game")
data class SavedGame(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "saved_game_id")
    val savedGameId: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "campaign")
    val campaign: Campaign,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
)