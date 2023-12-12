package com.techullurgy.pollapp.storage

import android.content.Context

class SessionStorage(
    context: Context
) {
    private val sharedPreferences = context.getSharedPreferences("POLL_APP_SESSION", Context.MODE_PRIVATE)

    fun getUserAccessToken(): String = sharedPreferences.getString("USER_ACCESS_TOKEN", "")!!

    fun setUserAccessToken(token: String) {
        sharedPreferences.edit().putString("USER_ACCESS_TOKEN", token).apply()
    }
}