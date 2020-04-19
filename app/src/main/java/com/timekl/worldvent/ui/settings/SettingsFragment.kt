/*
 * WorldVentAndroid
 * SettingsFragment.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.ui.settings

import android.os.Bundle
import androidx.preference.*
import com.timekl.worldvent.BuildConfig
import com.timekl.worldvent.R

class SettingsFragment: PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val appVersion = "World Vent Docs " + BuildConfig.VERSION_NAME
        val appVersionPref: Preference? = preferenceManager.findPreference("pref_app_version")
        appVersionPref?.title = appVersion
    }

    companion object {
        val TAG = "Settings"
    }
}