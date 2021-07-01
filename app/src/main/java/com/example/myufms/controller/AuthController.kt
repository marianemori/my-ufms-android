package com.example.myufms.controller

import android.util.Log
import com.example.myufms.TAG
import com.example.myufms.model.SignupUserModel
import com.example.myufms.utils.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class AuthController {
    private val  authService= RetrofitClient().authService

    fun signupNewUser(newUser: SignupUserModel, onResult: (ResponseBody?) -> Unit) {
        authService.createNewUser(newUser).enqueue(
            object : retrofit2.Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    onResult(null)
                    Log.d(TAG, "Response Body Error: ${t.message}")
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val body = response.body()
                    Log.d(TAG, "Response Body onResponse: ${body.toString()}")
                    onResult(body)
                }
            }
        )
    }
}