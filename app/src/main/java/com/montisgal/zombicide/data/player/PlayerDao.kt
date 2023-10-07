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
    suspend fun insert(player: Player)

    @Update
    suspend fun update(player: Player)

    @Delete
    suspend fun delete(player: Player)

    @Query("SELECT * FROM player WHERE player_id = :id")
    fun get(id: Int): Flow<Player>

    @Query("SELECT * FROM player")
    fun getAll(): Flow<List<Player>>
}
