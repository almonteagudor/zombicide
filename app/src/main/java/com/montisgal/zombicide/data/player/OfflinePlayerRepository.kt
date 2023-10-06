package com.montisgal.zombicide.data.player

import kotlinx.coroutines.flow.Flow

class OfflinePlayerRepository(private val playerDao: PlayerDao) : PlayerRepository {
    override suspend fun insert(player: Player) = playerDao.insert(player)

    override suspend fun update(player: Player) = playerDao.update(player)

    override suspend fun delete(player: Player) = playerDao.delete(player)

    override fun get(id: Int): Flow<Player?> = playerDao.get(id)

    override fun getAll(): Flow<List<Player>> = playerDao.getAll()
}