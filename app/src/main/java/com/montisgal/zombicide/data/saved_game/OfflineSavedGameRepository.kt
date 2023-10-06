package com.montisgal.zombicide.data.saved_game

import kotlinx.coroutines.flow.Flow

class OfflineSavedGameRepository(private val savedGameDao: SavedGameDao) : SavedGameRepository {
    override suspend fun insert(savedGame: SavedGame) = savedGameDao.insert(savedGame)

    override suspend fun update(savedGame: SavedGame) = savedGameDao.update(savedGame)

    override suspend fun delete(savedGame: SavedGame) = savedGameDao.delete(savedGame)

    override fun get(id: Int): Flow<SavedGame?> = savedGameDao.get(id)

    override fun getAll(): Flow<List<SavedGame>> = savedGameDao.getAll()
}