package com.example.demoretrofit.data

import com.google.gson.annotations.SerializedName

data class Geo(
    @SerializedName("lat")
    val lat : Float,
    @SerializedName("lng")
    val lng : Float
)
