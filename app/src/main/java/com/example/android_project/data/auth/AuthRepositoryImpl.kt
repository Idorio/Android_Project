package com.example.android_project.data.auth


import com.example.android_project.data.SheredPref.SharedPreferencesHelper
import com.example.android_project.domain.auth.AuthRepository
import com.example.android_project.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
):AuthRepository {
    override fun userLoggerIn(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)

    }

    override fun userLoggetOut() {
        sharedPreferencesHelper.logoutUser()

    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExist()
    }

    override fun getUserCreds(): UserModel {
       return sharedPreferencesHelper.getUserCreds()
    }
}