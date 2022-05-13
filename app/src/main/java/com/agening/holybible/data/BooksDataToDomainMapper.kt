package com.agening.holybible.data

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book
import com.agening.holybible.data.net.BookCloud
import com.agening.holybible.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(books: List<Book>): BookDomain
    fun map(e: Exception): BookDomain

}