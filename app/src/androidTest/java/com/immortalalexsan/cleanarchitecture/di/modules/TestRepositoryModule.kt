package com.immortalalexsan.cleanarchitecture.di.modules

import com.immortalalexsan.cleanarchitecture.core.di.modules.RepositoryModule
import com.immortalalexsan.cleanarchitecture.data.repositories.TestBooksRepository
import com.immortalalexsan.cleanarchitecture.domain.boudaries.BooksBoundary
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
interface TestRepositoryModule : RepositoryModule {

    @Binds
    @Named("TestBooksRepository")
    fun testBooksRepository(repository: TestBooksRepository): BooksBoundary
}
