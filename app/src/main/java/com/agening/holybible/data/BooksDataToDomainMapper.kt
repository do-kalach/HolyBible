package com.agening.holybible.data

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book
import com.agening.holybible.domain.BookDomain

interface BooksDataToDomainMapper: Abstract.Mapper {
    fun map(books: List<Book>): BookDomain
    fun map(e: Exception): BookDomain
}