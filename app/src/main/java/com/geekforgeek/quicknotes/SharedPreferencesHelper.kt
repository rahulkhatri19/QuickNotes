package com.geekforgeek.quicknotes

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {

    private const val SHARED_PREFERENCES = "Notes_preference"
    const val PROFILE_NAME = "profile_name"
    const val EMPTY_STRING = ""

    fun saveStringPref(key: String, value: String, sharedPreferences: SharedPreferences) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getStringPref(key: String, sharedPreferences: SharedPreferences): String {
        return sharedPreferences.getString(key, EMPTY_STRING) ?: EMPTY_STRING
    }

    fun instanceSharedPref(context: Context) : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

}