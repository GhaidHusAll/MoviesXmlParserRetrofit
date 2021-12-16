package com.example.xmlparseretrofit

import com.example.xmlparseretrofit.feedModel.Feed
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @get:GET("topMovies/xml")
    val feed: Call<Feed>?

    companion object{
        const val THE_URL = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/"
    }
}