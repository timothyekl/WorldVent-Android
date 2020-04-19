/*
 * WorldVentAndroid
 * WorldVentApp.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent

import android.app.Application
import com.timekl.worldvent.middleware.NetworkClient
import com.timekl.worldvent.middleware.NetworkInjection
import com.timekl.worldvent.middleware.Preferences

class WorldVentApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        preferences = Preferences(this)
        val api = NetworkInjection.provideApi("https://borama.co")
        networkClient = NetworkClient(api)
    }

    companion object {
        lateinit var instance: WorldVentApp
            private set
        lateinit var preferences: Preferences
        lateinit var networkClient: NetworkClient
    }
}