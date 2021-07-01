package com.example.myufms.model

data class ProfileModel (
    val biography: Any,
    val birthdate: String,
    val completeName: String,
    val created_At: String,
    val id: String,
    val photo: Any,
    val updated_At: String,
    val user: UserModel)
