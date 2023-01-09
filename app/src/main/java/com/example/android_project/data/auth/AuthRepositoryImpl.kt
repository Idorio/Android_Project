package com.example.android_project.data.auth


import com.example.android_project.data.SheredPref.SharedPreferencesHelper
import com.example.android_project.domain.auth.AuthRepository
import com.example.android_project.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
):AuthRepository {
    override suspend fun userLoggerIn(userName: String, userPassword: String) {
        return withContext(Dispatchers.IO)
        {sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)}


    }

    override suspend fun userLoggetOut() {
       return withContext(Dispatchers.IO)
       {sharedPreferencesHelper.logoutUser()}


    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO)
        {sharedPreferencesHelper.checkUserExist()}
    }

    override suspend fun getUserCreds(): UserModel {
        return  withContext(Dispatchers.IO)
        {sharedPreferencesHelper.getUserCreds()}

    }

}