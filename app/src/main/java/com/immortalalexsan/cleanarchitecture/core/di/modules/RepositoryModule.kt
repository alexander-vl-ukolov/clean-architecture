package com.immortalalexsan.cleanarchitecture.core.di.modules

import com.immortalalexsan.cleanarchitecture.data.repositories.BooksRepository
import com.immortalalexsan.cleanarchitecture.domain.boudaries.BooksBoundary
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun booksRepository(repository: BooksRepository): BooksBoundary
}
