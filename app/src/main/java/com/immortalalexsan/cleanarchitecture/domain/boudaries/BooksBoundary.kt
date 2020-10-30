package com.immortalalexsan.cleanarchitecture.domain.boudaries

import com.immortalalexsan.cleanarchitecture.domain.entities.EntityBook
import io.reactivex.rxjava3.core.Single

interface BooksBoundary {

    fun getBook(id: Long): Single<EntityBook>

    fun getBooks(offset: Int? = null, limit: Int? = null): Single<List<EntityBook>>
}
