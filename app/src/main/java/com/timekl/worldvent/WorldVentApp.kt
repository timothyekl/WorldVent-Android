package com.timekl.worldvent

import android.app.Application

class WorldVentApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: WorldVentApp
            private set
    }
}