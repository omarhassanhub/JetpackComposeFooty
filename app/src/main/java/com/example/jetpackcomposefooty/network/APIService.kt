package com.example.jetpackcomposefooty.network

import com.example.jetpackcomposefooty.domain.model.Match

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.soccersapi.com/v2.2/"
    }

    @GET("countries")
    suspend fun getData(@Query("user") user: String, @Query("token") token: String, @Query("t") t: String): Match
}
