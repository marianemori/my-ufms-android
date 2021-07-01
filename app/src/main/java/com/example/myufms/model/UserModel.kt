package com.example.myufms.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    val id: String,
    val email: String,
    val password: String,
    val phoneNumber: Int,
    val updated_At: String,
    val created_At: String,
)