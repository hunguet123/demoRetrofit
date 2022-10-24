package com.example.demoretrofit.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSingleton {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
    fun create(): ApiRequests {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiRequests::class.java)
    }
}