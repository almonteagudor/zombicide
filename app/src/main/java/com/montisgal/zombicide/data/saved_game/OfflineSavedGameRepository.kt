package com.montisgal.zombicide.data.saved_game

import com.montisgal.zombicide.domain.saved_game.SavedGame
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineSavedGameRepository(
    private val savedGameDao: SavedGameDao,
    private val mapper: SavedGameMapper
) : SavedGameRepository {
    override suspend fun insert(savedGame: SavedGame) {
        return savedGameDao.insert(mapper.fromDomainToEntity(savedGame))
    }

    override suspend fun update(savedGame: SavedGame) {
        return savedGameDao.update(mapper.fromDomainToEntity(savedGame))
    }

    override suspend fun delete(savedGame: SavedGame) {
        return savedGameDao.delete(mapper.fromDomainToEntity(savedGame))
    }

    override fun get(id: Int): Flow<SavedGame?> {
        return savedGameDao.get(id).map {
            mapper.fromEntityToDomain(it)
        }
    }

    override fun getAll(): Flow<List<SavedGame>> {
        return savedGameDao.getAll().map { entities ->
            entities.map {
                mapper.fromEntityToDomain(it)
            }
        }
    }
}