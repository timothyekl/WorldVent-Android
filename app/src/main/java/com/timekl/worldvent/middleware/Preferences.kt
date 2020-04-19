/*
 * WorldVentAndroid
 * Preferences.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.middleware

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class Preferences(context: Context) {

    private val BULLETIN_DATE = "BULLETIN_DATE"

    val preferences: SharedPreferences

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    var bulletinDate: String?
        get() = preferences.getString(BULLETIN_DATE, null)
        set(value) = preferences.edit().putString(BULLETIN_DATE, value).apply()

}