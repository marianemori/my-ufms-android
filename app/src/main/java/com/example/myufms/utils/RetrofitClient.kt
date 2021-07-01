package com.example.myufms.utils

import com.example.myufms.api.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val BASE_URL = "http://192.168.15.10:4444/v1/"

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authService: AuthService = getRetrofitClient().create(AuthService::class.java)
}