package com.example.android_project.domain.auth

import com.example.android_project.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
   fun userLoggedIn(userName:String, userPassword:String){
       authRepository.userLoggerIn(userName,userPassword)
   }
    fun userLoggerOut(){
        authRepository.userLoggetOut()
    }
    fun doesUserExist(): Boolean {
        return authRepository.doesUserExist()
    }
    fun getUserCreds(): UserModel {
        return authRepository.getUserCreds()
    }

}