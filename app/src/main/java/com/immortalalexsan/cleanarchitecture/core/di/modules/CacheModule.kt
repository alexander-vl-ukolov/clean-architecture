package com.immortalalexsan.cleanarchitecture.core.di.modules

import dagger.Module
import dagger.Provides
import io.paperdb.Book
import io.paperdb.Paper
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun paperBook(): Book = Paper.book()
}
