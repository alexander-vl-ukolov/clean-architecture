package com.immortalalexsan.cleanarchitecture.core.di.modules

import android.content.Context
import com.immortalalexsan.cleanarchitecture.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DatabaseModule {

    @Provides
    @Singleton
    fun appDatabase(appContext: Context): AppDatabase = AppDatabase.getInstance(appContext)
}
