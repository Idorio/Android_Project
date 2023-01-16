package com.example.android_project.domain.auth

import com.example.android_project.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
  suspend fun loginUser(userName:String, userPassword:String){
       authRepository.userLoggerIn(userName,userPassword)
   }
    suspend  fun logoutUser(){
        authRepository.userLoggetOut()
    }
    suspend  fun doesUserExist(): Boolean {
        return authRepository.doesUserExist()
    }
    suspend fun getUserCreds(): UserModel {
        return authRepository.getUserCreds()
    }

}