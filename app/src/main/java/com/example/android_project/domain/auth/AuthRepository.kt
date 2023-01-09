package com.example.android_project.domain.auth

import com.example.android_project.model.UserModel

interface AuthRepository {

    suspend  fun userLoggerIn(userName: String, userPassword: String)

    suspend  fun userLoggetOut()

    suspend fun doesUserExist(): Boolean

    suspend fun getUserCreds(): UserModel
}
