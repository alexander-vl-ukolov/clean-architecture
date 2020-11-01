package com.immortalalexsan.cleanarchitecture.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.immortalalexsan.cleanarchitecture.data.database.dao.base.BaseDao
import com.immortalalexsan.cleanarchitecture.data.database.entities.LocalBook
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface BookDao : BaseDao<LocalBook> {

    @Query("SELECT * FROM local_book")
    override fun select(): Single<List<LocalBook>>

    @Query("SELECT * FROM local_book LIMIT :limit OFFSET :offset")
    override fun select(limit: Int, offset: Int): Single<List<LocalBook>>

    @Query("DELETE FROM local_book")
    override fun clear(): Completable
}
