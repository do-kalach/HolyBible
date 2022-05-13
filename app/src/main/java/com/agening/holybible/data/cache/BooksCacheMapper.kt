package com.agening.holybible.data.cache

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>): List<Book>

    class Base(private val mapper:BookCacheMapper):BooksCacheMapper{
        override fun map(books: List<BookDb>) = books.map {bookDb->
            bookDb.map(mapper)
        }
    }
}