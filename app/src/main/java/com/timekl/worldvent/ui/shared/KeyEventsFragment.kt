/*
 * WorldVentAndroid
 * KeyEventsFragment.kt
 * Created by Michal Bojanowicz on 2020/4/19
 * Copyright (c) 2020. Michal Bojanowicz. All rights reserved
 */

package com.timekl.worldvent.ui.shared

import android.view.KeyEvent

interface KeyEventsFragment {

    fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean

}