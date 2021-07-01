package com.example.myufms.model

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class UserSignupModel(
    val email: String,
    val password: String,
    val completeName: String,
    @SerializedName("phoneNumber")
    val phone: Int,
    val birthdate: String
)