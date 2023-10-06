package com.montisgal.zombicide.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.montisgal.zombicide.data.saved_game.SavedGame
import com.montisgal.zombicide.data.saved_game.SavedGameDao

@Database(entities = [SavedGame::class], version = 1, exportSchema = false)
abstract class ZombicideDatabase : RoomDatabase() {
    abstract fun savedGameDao(): SavedGameDao

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