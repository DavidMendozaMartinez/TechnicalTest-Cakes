package com.davidmendozamartinez.technicaltest.cakes.data.remote

import com.davidmendozamartinez.technicaltest.cakes.data.remote.model.CakeRemote
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun createCakesService(): CakesService {
    val logger = HttpLoggingInterceptor()
    logger.level = Level.BASIC

    val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(Routes.CAKES_API_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(CakesService::class.java)
}

interface CakesService {
    @GET(Routes.GET_CAKES)
    suspend fun getCakes(): List<CakeRemote>
}
