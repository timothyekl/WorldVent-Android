/*
 * WorldVentAndroid
 * MainActivity.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.timekl.worldvent.middleware.Preferences
import com.timekl.worldvent.ui.bulletin.BulletinFragment
import com.timekl.worldvent.ui.shared.KeyEventsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_worldvent, R.id.navigation_controls, R.id.navigation_glossary
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, _, _ ->
            checkForNewBulletin()
        }
    }

    override fun onResume() {
        super.onResume()
        checkForNewBulletin()
    }

    // pass key events to the first fragment on top of navigation stack (if it can handle them)
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        val keyEventsFragment = navHostFragment?.childFragmentManager?.fragments?.firstOrNull() as? KeyEventsFragment ?: return super.onKeyDown(keyCode, event)
        return if (keyEventsFragment.onKeyDown(keyCode, event)) true else super.onKeyDown(keyCode, event)
    }

    private fun checkForNewBulletin() {
        WorldVentApp.networkClient.getBulletinJSON { bulletinData ->
            // we fall quietly don't need to show user an error message
            if (bulletinData == null) {
                Log.e(TAG, "bulletin response NULL")
                return@getBulletinJSON
            }

            val currentBulletinDate = WorldVentApp.preferences.bulletinDate
            val published = bulletinData.published
            val url = bulletinData.url

            if (published == currentBulletinDate) {
                return@getBulletinJSON
            }

            WorldVentApp.preferences.bulletinDate = published
            BulletinActivity.start(this, url)
        }
    }

    companion object {
        val TAG = "MainActivity"
    }
}
