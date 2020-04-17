package com.timekl.worldvent

import android.os.Bundle
import android.view.KeyEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
    }

    // pass key events to the first fragment on top of navigation stack (if it can handle them)
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        val keyEventsFragment = navHostFragment?.childFragmentManager?.fragments?.firstOrNull() as? KeyEventsFragment ?: return super.onKeyDown(keyCode, event)
        return if (keyEventsFragment.onKeyDown(keyCode, event)) true else super.onKeyDown(keyCode, event)
    }
}
