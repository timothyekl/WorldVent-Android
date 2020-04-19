/*
 * WorldVentAndroid
 * GlossaryFragment.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.ui.glossary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timekl.worldvent.R

class GlossaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_webview, container, false)
        return root
    }
}