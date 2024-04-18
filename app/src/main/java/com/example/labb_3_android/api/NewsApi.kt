package com.example.labb_3_android.api

import retrofit2.Call
import retrofit2.http.GET


interface NewsApi {

    @GET("/api/v1/war/news")
    fun getNews(): Call<List<NewsItem>>

}