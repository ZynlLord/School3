package com.example.school.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestBuilder {
    private const val URL: String = "https://localhost:7055/api/"
    private val okHttpClient = OkHttpClient.Builder()
        .build()


    val retrofit: RetrofitInterface by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .client(okHttpClient)
            .build()
            .create(RetrofitInterface::class.java)
    }
}