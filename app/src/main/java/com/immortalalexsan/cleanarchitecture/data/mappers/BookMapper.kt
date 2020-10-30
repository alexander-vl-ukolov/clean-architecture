package com.immortalalexsan.cleanarchitecture.data.mappers

import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteAuthor
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import com.immortalalexsan.cleanarchitecture.domain.entities.EntityAuthor
import com.immortalalexsan.cleanarchitecture.domain.entities.EntityBook
import com.immortalalexsan.cleanarchitecture.domain.mappers.Mapper
import javax.inject.Inject

class BookMapper @Inject constructor() : Mapper<RemoteBook, EntityBook> {

    override fun mapToOutput(input: RemoteBook): EntityBook {
        return with(input) {
            val author = EntityAuthor(author.name, author.surname)
            EntityBook(id, title, description, author)
        }
    }

    override fun mapToInput(output: EntityBook): RemoteBook {
        return with(output) {
            val author = RemoteAuthor(author.name, author.surname)
            RemoteBook(id, title, description, author)
        }
    }
}
