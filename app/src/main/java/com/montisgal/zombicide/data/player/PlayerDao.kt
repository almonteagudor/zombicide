package com.montisgal.zombicide.data.player

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert
    suspend fun insert(player: PlayerEntity)

    @Update
    suspend fun update(player: PlayerEntity)

    @Delete
    suspend fun delete(player: PlayerEntity)

    @Query("SELECT * FROM player WHERE id = :id")
    fun get(id: Int): Flow<PlayerEntity>

    @Query("SELECT * FROM player")
    fun getAll(): Flow<List<PlayerEntity>>
}
