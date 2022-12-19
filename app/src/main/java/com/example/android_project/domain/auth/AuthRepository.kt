package com.example.android_project.domain.auth

import com.example.android_project.model.UserModel

interface AuthRepository {

    fun userLoggerIn(userName: String, userPassword: String)

    fun userLoggetOut()

    fun doesUserExist(): Boolean

    fun getUserCreds(): UserModel
}
