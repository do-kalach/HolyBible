package com.agening.holybible.data.cache

import com.agening.holybible.core.Book

interface BooksCacheDataSource {

    fun fetchBooks(): List<BookDb>

    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> =
            realmProvider.provide().use { realm ->
                val booksDb = realm.where(BookDb::class.java).findAll() ?: emptyList()
                realm.copyFromRealm(booksDb)
            }

        override fun saveBooks(books: List<Book>) {
            realmProvider.provide().use { realm ->
                books.forEach {book->
                    realm.executeTransaction {
                        val bookDb = it.createObject(BookDb::class.java, book.id)
                        bookDb.name = book.name
                    }
                }
            }
        }
    }

}