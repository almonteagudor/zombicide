package com.montisgal.zombicide.data.saved_game

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedGameDao {
    @Insert
    suspend fun insert(savedGame: SavedGame)

    @Update
    suspend fun update(savedGame: SavedGame)

    @Delete
    suspend fun delete(savedGame: SavedGame)

    @Query("SELECT * FROM saved_game WHERE id = :id")
    fun get(id: Int): Flow<SavedGame>

    @Query("SELECT * FROM saved_game")
    fun getAll(): Flow<List<SavedGame>>
}