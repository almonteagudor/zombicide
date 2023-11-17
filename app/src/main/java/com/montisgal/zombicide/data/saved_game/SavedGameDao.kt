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
    suspend fun insert(savedGame: SavedGameEntity)

    @Update
    suspend fun update(savedGame: SavedGameEntity)

    @Delete
    suspend fun delete(savedGame: SavedGameEntity)

    @Query("SELECT * FROM saved_games WHERE id = :id")
    fun get(id: Int): Flow<SavedGameEntity>

    @Query("SELECT * FROM saved_games")
    fun getAll(): Flow<List<SavedGameEntity>>
}