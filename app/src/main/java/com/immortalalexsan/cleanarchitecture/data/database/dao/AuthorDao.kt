package com.immortalalexsan.cleanarchitecture.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.immortalalexsan.cleanarchitecture.data.database.dao.base.BaseDao
import com.immortalalexsan.cleanarchitecture.data.database.entities.LocalAuthor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface AuthorDao : BaseDao<LocalAuthor> {

    @Query("SELECT * FROM local_author")
    override fun select(): Single<List<LocalAuthor>>

    @Query("SELECT * FROM local_author LIMIT :limit OFFSET :offset")
    override fun select(limit: Int, offset: Int): Single<List<LocalAuthor>>

    @Query("DELETE FROM local_author")
    override fun clear(): Completable
}
