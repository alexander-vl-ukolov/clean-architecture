package com.immortalalexsan.cleanarchitecture.di.modules

import android.content.Context
import com.immortalalexsan.cleanarchitecture.core.di.modules.DatabaseModule
import com.immortalalexsan.cleanarchitecture.data.database.AppDatabase
import com.immortalalexsan.cleanarchitecture.data.database.TestDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class TestDatabaseModule : DatabaseModule() {

    @Provides
    @Singleton
    @Named("TestDatabase")
    fun testDatabase(appContext: Context): AppDatabase = TestDatabase.getInstance(appContext)
}
