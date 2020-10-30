package com.immortalalexsan.cleanarchitecture.core.di.modules

import com.immortalalexsan.cleanarchitecture.data.mappers.BookMapper
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import com.immortalalexsan.cleanarchitecture.domain.entities.EntityBook
import com.immortalalexsan.cleanarchitecture.domain.mappers.Mapper
import dagger.Binds
import dagger.Module

@Module
interface DataDomainMapperModule {

    @Binds
    fun bookMapper(mapper: BookMapper): Mapper<RemoteBook, EntityBook>
}
