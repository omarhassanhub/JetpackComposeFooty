package com.example.jetpackcomposefooty.di

import android.app.Application
import android.content.Context
import com.example.jetpackcomposefooty.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun providesApplicationContext(@ApplicationContext appContext: Context): Context = appContext

    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi, context: Context): ApiService =
        Retrofit.Builder()
            .run {
                baseUrl(ApiService.BASE_URL)
//                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                    .build()
            }.create(ApiService::class.java)

}