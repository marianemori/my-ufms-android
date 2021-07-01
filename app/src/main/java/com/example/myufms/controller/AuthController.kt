package com.example.myufms.controller

import android.util.Log
import com.example.myufms.model.ErrorResponseModel
import com.example.myufms.model.UserSignupModel
import com.example.myufms.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthController {
    private val authService = RetrofitClient().authService
    private val TAG = "Auth Service:"

    fun signupNewUser(newUser: UserSignupModel, onResult: (ErrorResponseModel?) -> Unit) {
        authService.createNewUser(newUser).enqueue(
            object : Callback<ErrorResponseModel> {

                override fun onResponse(
                    call: Call<ErrorResponseModel>,
                    response: Response<ErrorResponseModel>
                ) {
                    Log.d(TAG, "SignUp onResponse: ${response.body().toString()}")
                    onResult(response.body())
                }

                override fun onFailure(call: Call<ErrorResponseModel>, t: Throwable) {
                    onResult(null)
                    Log.d(TAG, "SignUp onFailure: ${t.message}")
                }
            }
        )
    }

    fun loginUser() {}

}