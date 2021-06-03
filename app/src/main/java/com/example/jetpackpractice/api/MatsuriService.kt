package com.example.jetpackpractice.api

import com.example.jetpackpractice.data.Card
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MatsuriService {

    @GET("cards")
    suspend  fun searchCards(@Query(value = "idolId") id: Int): List<Card>

    companion object {
        private const val BASE_URL = "https://api.matsurihi.me/mltd/v1/"

        fun create(): MatsuriService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder().addInterceptor(logger).build()
            return retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client).build()
                .create(MatsuriService::class.java)
        }
    }


}