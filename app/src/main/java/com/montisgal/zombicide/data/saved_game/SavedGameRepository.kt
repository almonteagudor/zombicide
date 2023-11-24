package com.montisgal.zombicide.data.saved_game

import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.SavedGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SavedGameRepository(
    private val dao: SavedGameDao,
    private val mapper: SavedGameMapper
) : SavedGameRepository {
    override suspend fun insert(savedGame: SavedGame) {
        return dao.insert(mapper.fromDomainToEntity(savedGame))
    }

    override suspend fun update(savedGame: SavedGame) {
        return dao.update(mapper.fromDomainToEntity(savedGame))
    }

    override suspend fun delete(savedGame: SavedGame) {
        return dao.delete(mapper.fromDomainToEntity(savedGame))
    }

    override fun get(id: Int): Flow<SavedGame?> {
        return dao.get(id).map {
            mapper.fromEntityToDomain(it)
        }
    }

    override fun getAll(): Flow<List<SavedGame>> {
        return dao.getAll().map { entities ->
            entities.map {
                mapper.fromEntityToDomain(it)
            }
        }
    }
}