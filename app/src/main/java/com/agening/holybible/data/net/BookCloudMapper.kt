package com.agening.holybible.data.net

import com.agening.holybible.core.Abstract
import com.agening.holybible.core.Book

interface BookCloudMapper:Abstract.Mapper {

    fun map(id:Int, name:String): Book

    class Base():BookCloudMapper{
        override fun map(id: Int, name: String): Book = Book(id, name)
    }
}
