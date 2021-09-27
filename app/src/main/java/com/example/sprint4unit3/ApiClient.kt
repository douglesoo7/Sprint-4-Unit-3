package com.example.sprint4unit3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search")
    fun getSongs(@Query("term") term:String): Call<ResponseDTO>
}