package com.example.myufms.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class UserModel(
        val id: String,
        val name: String
)