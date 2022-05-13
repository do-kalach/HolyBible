package com.agening.holybible.data.cache

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb): Book

    class Base : BookCacheMapper {
        override fun map(bookDb: BookDb) = Book(bookDb.id, bookDb.name)
    }
}
