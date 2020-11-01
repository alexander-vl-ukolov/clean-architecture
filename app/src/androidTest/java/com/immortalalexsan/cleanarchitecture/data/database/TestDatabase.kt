package com.immortalalexsan.cleanarchitecture.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.immortalalexsan.cleanarchitecture.data.database.entities.LocalAuthor
import com.immortalalexsan.cleanarchitecture.data.database.entities.LocalBook

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        LocalBook::class,
        LocalAuthor::class
    ]
)
abstract class TestDatabase : AppDatabase() {

    companion object {
        @Volatile
        private var instance: TestDatabase? = null

        fun getInstance(context: Context): TestDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance = Room.inMemoryDatabaseBuilder(context, TestDatabase::class.java)
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance!!
            }
        }
    }
}
