/*
 * WorldVentAndroid
 * BulletinActivity.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_bulletin.*

class BulletinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_bulletin)
        val url = intent.getStringExtra("url")
        webView.loadUrl(url)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }


    companion object {
        fun start(from: AppCompatActivity, url: String) {
            val intent = Intent(from, BulletinActivity::class.java)
            intent.putExtra("url", url)
            from.startActivity(intent)
        }
    }
}
