package com.immortalalexsan.cleanarchitecture.data.repositories

import com.immortalalexsan.cleanarchitecture.data.network.api.ApiService
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import com.immortalalexsan.cleanarchitecture.domain.entities.EntityBook
import com.immortalalexsan.cleanarchitecture.domain.mappers.Mapper
import javax.inject.Inject
import javax.inject.Named

@Named("TestBooksRepository")
class TestBooksRepository @Inject constructor(
    @Named("TestApiService") apiService: ApiService,
    mapper: Mapper<RemoteBook, EntityBook>
) : BooksRepository(apiService, mapper)
