package com.montisgal.zombicide.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.montisgal.zombicide.data.player.Player
import com.montisgal.zombicide.data.player.PlayerDao
import com.montisgal.zombicide.data.player_saved_game.PlayerSavedGameCrossRef
import com.montisgal.zombicide.data.saved_game.SavedGameEntity
import com.montisgal.zombicide.data.saved_game.SavedGameDao

@Database(
    version = 2,
    exportSchema = false,
    entities = [
        SavedGameEntity::class,
        Player::class,
        PlayerSavedGameCrossRef::class,
    ],
)
abstract class ZombicideDatabase : RoomDatabase() {
    abstract fun savedGameDao(): SavedGameDao
    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        private var Instance: ZombicideDatabase? = null

        fun getDatabase(context: Context): ZombicideDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ZombicideDatabase::class.java, "zombicide_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}