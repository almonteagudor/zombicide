package com.montisgal.zombicide.data.saved_game

import kotlinx.coroutines.flow.Flow

interface SavedGameRepository {
    suspend fun insert(savedGame: SavedGame)

    suspend fun update(savedGame: SavedGame)

    suspend fun delete(savedGame: SavedGame)

    fun get(id: Int): Flow<SavedGame?>

    fun getAll(): Flow<List<SavedGame>>
}