package com.agening.holybible.data

import com.agening.holybible.data.net.BookCloud
import com.agening.holybible.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks():List<BookCloud>

    class Base(private val service: BooksService):BooksCloudDataSource{
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }

    }

}