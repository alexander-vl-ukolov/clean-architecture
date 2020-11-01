package com.immortalalexsan.cleanarchitecture.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.immortalalexsan.cleanarchitecture.BuildConfig
import com.immortalalexsan.cleanarchitecture.data.database.dao.AuthorDao
import com.immortalalexsan.cleanarchitecture.data.database.dao.BookDao
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
abstract class AppDatabase : RoomDatabase() {

    abstract val bookDao: BookDao

    abstract val authorDao: AuthorDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return instance!!
            }
        }
    }
}
