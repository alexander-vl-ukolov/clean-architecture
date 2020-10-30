package com.immortalalexsan.cleanarchitecture.data.repositories

import com.immortalalexsan.cleanarchitecture.data.network.api.ApiService
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import com.immortalalexsan.cleanarchitecture.domain.boudaries.BooksBoundary
import com.immortalalexsan.cleanarchitecture.domain.entities.EntityBook
import com.immortalalexsan.cleanarchitecture.domain.mappers.ListMapperImpl
import com.immortalalexsan.cleanarchitecture.domain.mappers.Mapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

open class BooksRepository @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper<RemoteBook, EntityBook>
) : BooksBoundary {

    private val listMapper = ListMapperImpl(mapper)

    override fun getBook(id: Long): Single<EntityBook> {
        return apiService.getBook(id)
            .map { mapper.mapToOutput(it) }
    }

    override fun getBooks(offset: Int?, limit: Int?): Single<List<EntityBook>> {
        return apiService.getBooks(offset, limit)
            .map { listMapper.mapToOutput(it) }
    }
}
