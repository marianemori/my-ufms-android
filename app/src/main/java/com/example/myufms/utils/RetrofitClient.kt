package com.example.myufms.utils

import com.example.myufms.api.AuthService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val BASE_URL = "http://192.168.15.10:3333/v1/"
    private val logging = HttpLoggingInterceptor()
    private val httpClient = OkHttpClient.Builder()

    init {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
    }

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    val authService: AuthService = getRetrofitClient().create(AuthService::class.java)
}