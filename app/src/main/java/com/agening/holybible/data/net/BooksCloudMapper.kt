package com.agening.holybible.data.net

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> = cloudList.map { bookCloud ->
            bookCloud.map(bookMapper)
        }
    }

}
