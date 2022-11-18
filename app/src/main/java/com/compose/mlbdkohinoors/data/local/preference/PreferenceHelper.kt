package com.compose.mlbdkohinoors.data.local.preference

interface PreferenceHelper {
    fun saveUserName(name: String)

    fun getUserName(key: String): String?
}