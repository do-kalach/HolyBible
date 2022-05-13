package com.agening.holybible.data

import com.agening.holybible.core.Abstract
import com.agening.holybible.data.net.BookServerModel
import com.agening.holybible.domain.BookDomain

sealed class BookData:Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }

    }

    class Fail(private val e:Exception):BookData(){
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(e)
        }

    }

    //class Success(private val books:List<BookServerModel>): BookData()

}