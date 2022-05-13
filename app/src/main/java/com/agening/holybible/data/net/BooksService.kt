package com.agening.holybible.data.net

import retrofit2.http.GET

interface BooksService {
    @GET("books")
    suspend fun fetchBooks():List<BookServerModel>
}

//base url https://bible-go-api.rkeplin.com/v1/