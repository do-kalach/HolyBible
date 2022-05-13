package com.agening.holybible.core

import android.app.Application
import com.agening.holybible.data.BooksCloudDataSource
import com.agening.holybible.data.BooksRepository
import com.agening.holybible.data.cache.BookCacheMapper
import com.agening.holybible.data.cache.BooksCacheDataSource
import com.agening.holybible.data.cache.BooksCacheMapper
import com.agening.holybible.data.cache.RealmProvider
import com.agening.holybible.data.net.BookCloudMapper
import com.agening.holybible.data.net.BooksCloudMapper
import com.agening.holybible.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())
        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
    }
}