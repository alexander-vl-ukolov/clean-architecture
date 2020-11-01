package com.immortalalexsan.cleanarchitecture.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.immortalalexsan.cleanarchitecture.data.database.convertors.OffsetDateTimeIsoConverter
import com.immortalalexsan.cleanarchitecture.data.database.entities.base.LocalBaseEntity
import org.threeten.bp.OffsetDateTime

@Entity(tableName = "local_author")
data class LocalAuthor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,

    @field:TypeConverters(OffsetDateTimeIsoConverter::class)
    @ColumnInfo(name = "timestamp", typeAffinity = ColumnInfo.TEXT)
    val timestamp: OffsetDateTime? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "surname")
    val surname: String
) : LocalBaseEntity()
