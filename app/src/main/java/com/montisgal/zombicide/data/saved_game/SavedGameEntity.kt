package com.montisgal.zombicide.data.saved_game

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_games")
data class SavedGameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val campaignId: Int,
    val updatedAt: String,
)