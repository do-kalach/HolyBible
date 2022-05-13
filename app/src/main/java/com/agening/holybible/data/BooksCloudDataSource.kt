package com.agening.holybible.data

import com.agening.holybible.data.net.BookServerModel
import com.agening.holybible.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks():List<BookServerModel>

    class Base(private val service: BooksService):BooksCloudDataSource{
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }

    }

}