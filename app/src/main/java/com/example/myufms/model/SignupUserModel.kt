package com.example.myufms.model

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class SignupUserModel(
    val email: String,
    val password: String,
    val completeName: String,
    @SerializedName("phone_number")
    val phoneNumber: Int,
    val birthdate: String
)