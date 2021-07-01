package com.example.myufms.api

import com.example.myufms.model.ErrorResponseModel
import com.example.myufms.model.ProfileModel
import com.example.myufms.model.UserModel
import com.example.myufms.model.UserSignupModel
import retrofit2.Call

import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

interface AuthService {

    @POST("auth/signup")
    fun createNewUser(@Body userModel: UserSignupModel): Call<ProfileModel>


    @POST("auth/signin")
    fun loginUser(@Body login: UserModel): Call<Objects>
}