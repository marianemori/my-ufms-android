package com.example.myufms.api

import com.example.myufms.model.SignupUserModel
import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signup")
    fun createNewUser(@Body userModel: SignupUserModel): Call<ResponseBody>

}