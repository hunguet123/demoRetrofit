package com.example.demoretrofit.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {
    @GET("/users")
    fun getUser() : Call<List<User>>
}