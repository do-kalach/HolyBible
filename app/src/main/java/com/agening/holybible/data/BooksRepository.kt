package com.agening.holybible.data

interface BooksRepository {

    suspend fun fetchBooks(): BookData

    class Base(private val cacheDataSource: BooksCloudDataSource) : BooksRepository {
        override suspend fun fetchBooks() = try {
            BookData.Success(cacheDataSource.fetchBooks())
        } catch (e: Exception) {
            BookData.Fail(e)
        }
    }
}