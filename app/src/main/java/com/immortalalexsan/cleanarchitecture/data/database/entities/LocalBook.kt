package com.immortalalexsan.cleanarchitecture.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.immortalalexsan.cleanarchitecture.data.database.convertors.OffsetDateTimeIsoConverter
import com.immortalalexsan.cleanarchitecture.data.database.entities.base.LocalBaseEntity
import org.threeten.bp.OffsetDateTime

@Entity(
    tableName = "local_book",
    indices = [
        Index(value = ["author_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = LocalAuthor::class,
            parentColumns = ["id"],
            childColumns = ["author_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
            deferred = false
        )
    ]
)
data class LocalBook(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,

    @ColumnInfo(name = "author_id")
    val authorId: Long,

    @field:TypeConverters(OffsetDateTimeIsoConverter::class)
    @ColumnInfo(name = "timestamp", typeAffinity = ColumnInfo.TEXT)
    val timestamp: OffsetDateTime? = null,

    @ColumnInfo(name = "remote_id")
    val remoteId: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String
) : LocalBaseEntity()
