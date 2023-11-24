package com.montisgal.zombicide.data.player

import com.montisgal.zombicide.domain.player.Player
import com.montisgal.zombicide.domain.player.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlayerRepository(
    private val dao: PlayerDao,
    private val mapper: PlayerMapper,
) : PlayerRepository {
    override suspend fun insert(player: Player) {
        return dao.insert(mapper.fromDomainToEntity(player))
    }

    override suspend fun update(player: Player) {
        return dao.update(mapper.fromDomainToEntity(player))
    }

    override suspend fun delete(player: Player) {
        return dao.delete(mapper.fromDomainToEntity(player))
    }

    override fun get(id: Int): Flow<Player?> {
        return dao.get(id).map {
            mapper.fromEntityToDomain(it)
        }
    }

    override fun getAll(): Flow<List<Player>> {
        return dao.getAll().map { entities ->
            entities.map {
                mapper.fromEntityToDomain(it)
            }
        }
    }
}