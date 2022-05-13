package com.agening.holybible.data

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book
import com.agening.holybible.domain.BookDomain

sealed class BooksData:Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)

    }

    class Fail(private val e:Exception):BooksData(){
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)

    }

    //class Success(private val books:List<BookServerModel>): BookData()

}