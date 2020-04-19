/*
 * WorldVentAndroid
 * BulletinFragment.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.ui.bulletin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timekl.worldvent.R
import kotlinx.android.synthetic.main.fragment_webview.*

class BulletinFragment(val url: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_webview, container, false)
        webView.loadUrl(url)
        return root
    }
}