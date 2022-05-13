package com.agening.holybible.domain

import com.agening.holybible.core.Abstract
import com.agening.holybible.data.net.BookServerModel
import com.agening.holybible.presentation.BookUi

sealed class BookDomain: Abstract.Object<BookUi, Abstract.Mapper.Empty>() {
    class Success():BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }
    class Fail(private val errorType:Int):BookDomain(){
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }
}