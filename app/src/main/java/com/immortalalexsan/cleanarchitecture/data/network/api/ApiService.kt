package com.immortalalexsan.cleanarchitecture.data.network.api

import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    fun getBook(@Query("id") id: Long): Single<RemoteBook>

    /**
     * @param offset Must be a positive integer.
     * @param limit Must be a positive integer.
     */
    @GET("/")
    fun getBooks(
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null
    ): Single<List<RemoteBook>>
}
