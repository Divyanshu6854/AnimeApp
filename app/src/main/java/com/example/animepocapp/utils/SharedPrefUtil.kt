package com.example.animepocapp.utils

import android.content.Context
import android.content.SharedPreferences

const val GSP_PREF: String = "ANIME_POC"

class SharedPrefUtil {
    private var context: Context
    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    constructor(context: Context) {
        this.context = context
        preferences = context.getSharedPreferences(GSP_PREF, Context.MODE_PRIVATE)
        editor = preferences.edit()
        loadValues()
    }

    fun getInt(prefName: String, defValue: Int): Int {
        return preferences.getInt(prefName, defValue)
    }

    fun putInt(prefName: String, prefValue: Int) {
        editor = preferences.edit()
        editor.putInt(prefName, prefValue)
        editor.apply()
    }

    private fun loadValues() {
        position = readposition()
    }


    //-----------
    private val PREF_POSITION = "PREF_POSITION"
    private var position = 0

    private fun readposition(): Int {
        return getInt(PREF_POSITION, 0)
    }

    fun getPosition(): Int {
        return position
    }

    fun putPosition(token: Int) {
        putInt(PREF_POSITION, token)
        this.position = token
    }
    //-----------

}