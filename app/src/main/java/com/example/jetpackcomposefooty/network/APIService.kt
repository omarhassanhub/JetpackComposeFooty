package com.example.jetpackcomposefooty.network

import com.example.jetpackcomposefooty.domain.model.Fixtures
import com.example.jetpackcomposefooty.domain.model.Match
import com.example.jetpackcomposefooty.domain.model.Transfers

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.soccersapi.com/v2.2/"
    }

    @GET("countries")
    suspend fun getData(@Query("user") user: String, @Query("token") token: String, @Query("t") t: String): Match

    @GET("fixtures")
    suspend fun getFixturesData(@Query("user") user: String, @Query("token") token: String, @Query("t") t: String, @Query("d") d: String): Fixtures

    @GET("teams")
    suspend fun getTransfersData(@Query("user") user: String, @Query("token") token: String, @Query("t") t: String, @Query("id") d: String): Transfers
}
