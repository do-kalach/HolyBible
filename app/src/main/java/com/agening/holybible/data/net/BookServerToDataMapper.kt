package com.agening.holybible.data.net

import com.agening.holybible.core.Abstract
import com.agening.holybible.data.BookData

interface BookServerToDataMapper:Abstract.Mapper {

    fun map(id:Int, name:String):BookData
}
