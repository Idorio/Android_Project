package com.example.android_project.data.SheredPref

import android.content.SharedPreferences
import com.example.android_project.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences :SharedPreferences) {

    fun saveUserName(name: String?){
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?){
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds():UserModel{
        val name = sharedPreferences.getString(USER_NAME, "") ?: ""
        val pass = sharedPreferences.getString(USER_PASSWORD , "") ?: ""
        return UserModel(name,pass)
    }
    fun checkUserExist(): Boolean{
        val name = sharedPreferences.getString(USER_NAME, "") ?: ""
        val pass = sharedPreferences.getString(USER_PASSWORD , "") ?: ""
        return (!name.isNullOrEmpty()&& !pass.isNullOrEmpty())
    }

    fun logoutUser(){
        saveUserName(null)
        saveUserPassword(null)
    }





    companion object{
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"

    }

}