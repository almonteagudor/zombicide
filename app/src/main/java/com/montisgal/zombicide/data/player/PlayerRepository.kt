package com.montisgal.zombicide.data.player

import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    suspend fun insert(player: Player)

    suspend fun update(player: Player)

    suspend fun delete(player: Player)

    fun get(id: Int): Flow<Player?>

    fun getAll(): Flow<List<Player>>
}