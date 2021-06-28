package com.example.myufms.data

import com.example.myufms.data.model.UserModel

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var userModel: UserModel? = null
        private set

    val isLoggedIn: Boolean
        get() = userModel != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        userModel = null
    }

    fun logout() {
        userModel = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<UserModel> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(userModel: UserModel) {
        this.userModel = userModel
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}